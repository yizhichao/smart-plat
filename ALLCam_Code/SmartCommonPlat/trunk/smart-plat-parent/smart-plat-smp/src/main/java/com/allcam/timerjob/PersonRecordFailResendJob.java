package com.allcam.timerjob;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.annotation.Resource;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import com.allcam.common.ServiceContants;
import com.allcam.daoall.agent.dao.FailResendDao;
import com.allcam.pojo.PersonFailResendInfo;
import com.allcam.utils.ConfigHelper;
import com.allcam.utils.JsonParseUtil;

@Service
public class PersonRecordFailResendJob implements ServiceContants
{
    public static final Log LOG = LogFactory.getLog(PersonRecordFailResendJob.class);
    
    @Resource
    private FailResendDao failResendDao;
    
    private static final HttpClient httpClient = new HttpClient();
    
    protected static final int httpConnectionTimeOut =
        Integer.parseInt(ConfigHelper.getValueByKey("http.connection.timeout"));
    
    protected static final String failResendPageSize = ConfigHelper.getValueByKey("sys.fail.resend.page.pageSize");
    
    protected static final String failResendMaxCount = ConfigHelper.getValueByKey("sys.fail.resend.resend.max.count");
    
    public void personRecordFailResend()
    {
        LOG.info("QueryPersonRecordJobFailResend.queryFailResendPersonRecord begin.");
        PersonFailResendInfo personFailResendInfo = new PersonFailResendInfo();
        personFailResendInfo.setPageSize(failResendPageSize);
        List<PersonFailResendInfo> list = failResendDao.queryPersonFailResendInfo(personFailResendInfo);
        
        LOG.info("List<PersonFailResendInfo> list:[" + list + "]");
        if (null != list && 0 < list.size())
        {
            // 循环 通过记录，对应上报到BPC
            for (int i = 0; i < list.size(); i++)
            {
                PersonFailResendInfo personRecord = list.get(i);
                sendDataToBPC(personRecord);
            }
        }
        LOG.info("QueryPersonRecordJobFailResend.queryFailResendPersonRecord end.");
    }
    
    private void sendDataToBPC(PersonFailResendInfo personRecord)
    {
        PersonFailResendInfo failResendInfo = new PersonFailResendInfo();
        failResendInfo.setResendId(UUID.randomUUID().toString());
        failResendInfo.setIsModPhoto(0);
        failResendInfo.setReceiveId(personRecord.getReceiveId());
        failResendInfo.setFilePath(personRecord.getFilePath());
        failResendInfo.setNurId(personRecord.getNurId());
        PostMethod method = null;
        try
        {
            StringBuffer buf = new StringBuffer(0);
            buf.append(personRecord.getBpcUrl());
            buf.append("/BPC/BDGWChannelServer");
            buf.append("?version=").append("1.0");
            buf.append("&direction=request&msgType=ENTRY_EXIT_NOTIFY&schoolId=");
            buf.append(personRecord.getNurId());
            
            if (USER_TYPE_STUDENT.equals(personRecord.getUserType()))
            {
                buf.append(personRecord.getStudentData());
            }
            else
            {
                buf.append(personRecord.getUserData());
            }
            
            method = new PostMethod(buf.toString());
            httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(1000 * httpConnectionTimeOut); // 链接超时30秒
            httpClient.getHttpConnectionManager().getParams().setSoTimeout(1000 * httpConnectionTimeOut); // 读取超时30秒
            httpClient.executeMethod(method);
            String response = method.getResponseBodyAsString();
            System.out.println(response);
            if (null != response)
            {
                // {"SUCCESS":true,"URL":"http://bj.bcebos.com/v1/transcoded/yigu/4c7dd8c7-9edf-4df1-9927-a4b121df2a2b.mp4?authorization\u003dbce-auth-v1%2F535f3834e538448aa88f3c589bab2ea3%2F2015-06-23T07%3A28%3A45Z%2F300%2F%2Fd3d8627f5e7739cb783ddcadbebe67ed3101d1265a38f00afebb478064e815be"}
                Map<String, Object> map = JsonParseUtil.json2Map(response);
                
                LOG.info(map.get("Result").toString());
                if ("{resultCode=1000, resultDesc=SUCCESS}".equalsIgnoreCase(map.get("Result").toString()))
                {
                    LOG.info("\"resultCode\":\"1000\"");
                    // delete from
                    // tbl_fail_resend_info where
                    // resendId=#{resendId}
                    PersonFailResendInfo person = new PersonFailResendInfo();
                    person.setResendId(personRecord.getResendId());
                    failResendDao.delPersonFailResendInfo(person);
                }
                else
                {
                    LOG.error(map.get("Result").toString());
                    failResendInfo.setExceptionMsg("response 200 but response body Result is ["
                        + map.get("Result").toString() + "].");
                    updatePersonFailResendInfo(personRecord);
                }
            }
            else
            {
                // 入重新上传的失败
                failResendInfo.setExceptionMsg("response 200 but response body is null.");
                updatePersonFailResendInfo(personRecord);
            }
        }
        catch (MalformedURLException e)
        {
            LOG.error("MalformedURLException", e);
            failResendInfo.setExceptionMsg(e.getMessage());
            updatePersonFailResendInfo(personRecord);
        }
        catch (IOException e)
        {
            LOG.error("IOException", e);
            failResendInfo.setExceptionMsg(e.getMessage());
            updatePersonFailResendInfo(personRecord);
        }
        catch (Exception e)
        {
            LOG.error("Exception", e);
            failResendInfo.setExceptionMsg(e.getMessage());
            updatePersonFailResendInfo(personRecord);
        }
        finally
        {
            if (method != null)
            {
                method.releaseConnection();
            }
        }
    }
    
    private void updatePersonFailResendInfo(PersonFailResendInfo person)
    {
        // update
        // tbl_fail_resend_info set
        // receiveId=#{receiveId},isModPhoto=#{isModPhoto},status=#{status},resendCount=#{resendCount}
        // where
        // resendId=#{resendId}
        // 如果默认 当前次数是最大次数
        if (Integer.parseInt(failResendMaxCount) <= person.getResendCount() + 1)
        {
            person.setStatus(1);
            person.setResendCount(person.getResendCount() + 1);
        }
        else
        {
            person.setStatus(0);
            person.setResendCount(person.getResendCount() + 1);
        }
        failResendDao.modPersonFailResendInfo(person);
    }
}
