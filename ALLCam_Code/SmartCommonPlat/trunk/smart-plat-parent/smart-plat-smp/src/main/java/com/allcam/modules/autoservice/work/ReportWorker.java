package com.allcam.modules.autoservice.work;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.allcam.common.ServiceContants;
import com.allcam.daoall.agent.dao.FailResendDao;
import com.allcam.modules.autoservice.model.ReportBean;
import com.allcam.pojo.PersonFailResendInfo;
import com.allcam.pojo.ReceiveStudentInfo;
import com.allcam.pojo.ReceiveUserInfo;
import com.allcam.utils.Base64;
import com.allcam.utils.ConfigHelper;
import com.allcam.utils.JsonParseUtil;

/**
 * 推送工作类
 * 
 * @author YiZhichao
 * @version [版本号, 2015-4-25]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class ReportWorker extends Thread implements ServiceContants
{
    private static final Log LOG = LogFactory.getLog(ReportWorker.class);
    
    protected static final int httpConnectionTimeOut =
        Integer.parseInt(ConfigHelper.getValueByKey("http.connection.timeout"));
    
    private ReportBean proxy;
    
    public ReportWorker()
    {
        
    }
    
    public ReportWorker(ReportBean bean)
    {
        this.proxy = bean;
    }
    
    public void run()
    {
        handleReportBean();
    }
    
    public void handleReportBean()
    {
        if (ENTRY_EXIT_NOTIFY.equals(this.proxy.getMsgType()))
        {
            PostMethod method = null;
            HttpClient httpClient = null;
            String bpcUrl = null;
            StringBuffer userData = new StringBuffer(0);
            StringBuffer studentData = new StringBuffer(0);
            PersonFailResendInfo failResendInfo = new PersonFailResendInfo();
            failResendInfo.setResendId(UUID.randomUUID().toString());
            failResendInfo.setIsModPhoto(0);
            
            try
            {
                StringBuffer buf = new StringBuffer(0);
                if (USER_TYPE_STUDENT.equals(proxy.getUserType()))
                {
                    ReceiveStudentInfo dataBean = proxy.getReceiveStudentInfo();
                    failResendInfo.setReceiveId(dataBean.getReceiveId());
                    failResendInfo.setUserType(0);
                    failResendInfo.setFilePath(dataBean.getPhotoUrl());
                    failResendInfo.setNurId(dataBean.getNurId());
                    bpcUrl =
                        dataBean.getBpcServerUrl().substring(0, dataBean.getBpcServerUrl().indexOf("/BPC/HttpServer"));
                    failResendInfo.setBpcUrl(bpcUrl);
                    buf.append(bpcUrl);
                    buf.append("/BPC/BDGWChannelServer");
                    buf.append("?version=").append("1.0");
                    buf.append("&direction=request&msgType=ENTRY_EXIT_NOTIFY&schoolId=");
                    buf.append(dataBean.getNurId());
                    studentData.append("&receiveId=").append(dataBean.getReceiveId());
                    studentData.append("&deviceType=").append("5");
                    studentData.append("&softVersion=").append("v1.0");
                    studentData.append("&userMobiles=")
                        .append(dataBean.getMobile() == null ? "" : dataBean.getMobile());
                    studentData.append("&userCode=").append(dataBean.getStudentCode() == null ? ""
                        : dataBean.getStudentCode());
                    studentData.append("&userType=").append(0);
                    studentData.append("&userId=").append(dataBean.getUserId());
                    studentData.append("&userName=").append(Base64.encode(new String(dataBean.getUserName()).getBytes()));
                    studentData.append("&picture=")
                        .append(dataBean.getPhotoUrl() == null ? "" : dataBean.getPhotoUrl());
                    studentData.append("&action=").append(dataBean.getReceiveType());
                    studentData.append("&dateTime=").append(dataBean.getReceiveTime());
                    failResendInfo.setStudentData(studentData.toString());
                    buf.append(studentData);
                }
                else
                {
                    ReceiveUserInfo dataBean = proxy.getReceiveUserInfo();
                    failResendInfo.setReceiveId(dataBean.getReceiveId());
                    failResendInfo.setUserType(1);
                    failResendInfo.setFilePath(dataBean.getPhotoUrl());
                    failResendInfo.setNurId(dataBean.getNurId());
                    bpcUrl =
                        dataBean.getBpcServerUrl().substring(0, dataBean.getBpcServerUrl().indexOf("/BPC/HttpServer"));
                    failResendInfo.setBpcUrl(bpcUrl);
                    buf.append(bpcUrl);
                    buf.append("/BPC/BDGWChannelServer");
                    buf.append("?version=").append("1.0");
                    buf.append("&direction=request&msgType=ENTRY_EXIT_NOTIFY&schoolId=");
                    buf.append(dataBean.getNurId());
                    userData.append("&receiveId=").append(dataBean.getReceiveId());
                    userData.append("&deviceType=").append("5");
                    userData.append("&softVersion=").append("v1.0");
                    userData.append("&userMobiles=").append(dataBean.getMobile() == null ? "" : dataBean.getMobile());
                    userData.append("&userCode=").append(dataBean.getUserCode() == null ? "" : dataBean.getUserCode());
                    userData.append("&userType=").append(1);
                    userData.append("&userId=").append(dataBean.getUserId());
                    userData.append("&userName=").append(Base64.encode(new String(dataBean.getUserName()).getBytes()));
                    userData.append("&picture=").append(dataBean.getPhotoUrl() == null ? "" : dataBean.getPhotoUrl());
                    userData.append("&action=").append(dataBean.getReceiveType());
                    userData.append("&dateTime=").append(dataBean.getReceiveTime());
                    failResendInfo.setUserData(userData.toString());
                    buf.append(userData);
                }
                
                httpClient = new HttpClient();
                method = new PostMethod(buf.toString());
                httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(1000 * httpConnectionTimeOut);
                // 链接超时30秒
                httpClient.getHttpConnectionManager().getParams().setSoTimeout(1000 * httpConnectionTimeOut); //
                // 读取超时30秒
                httpClient.executeMethod(method);
                String response = method.getResponseBodyAsString();
                if (null != response)
                {
                    // {"SUCCESS":true,"URL":"http://bj.bcebos.com/v1/transcoded/yigu/4c7dd8c7-9edf-4df1-9927-a4b121df2a2b.mp4?authorization\u003dbce-auth-v1%2F535f3834e538448aa88f3c589bab2ea3%2F2015-06-23T07%3A28%3A45Z%2F300%2F%2Fd3d8627f5e7739cb783ddcadbebe67ed3101d1265a38f00afebb478064e815be"}
                    Map<String, Object> map = JsonParseUtil.json2Map(response);
                    
                    LOG.info(map.get("Result").toString());
                    if ("{resultCode=1000, resultDesc=SUCCESS}".equalsIgnoreCase(map.get("Result").toString()))
                    {
                        LOG.info("\"resultCode\":\"1000\"");
                    }
                    else
                    {
                        LOG.error(map.get("Result").toString());
                        failResendInfo.setExceptionMsg("response 200 but response body Result is ["
                            + map.get("Result").toString() + "].");
                        insertPersonFailResendInfo(failResendInfo);
                    }
                }
                else
                {
                    // 入重新上传的失败
                    failResendInfo.setExceptionMsg("response 200 but response body is null.");
                    insertPersonFailResendInfo(failResendInfo);
                }
            }
            catch (MalformedURLException e)
            {
                LOG.error("MalformedURLException", e);
                failResendInfo.setExceptionMsg(e.getMessage());
                insertPersonFailResendInfo(failResendInfo);
            }
            catch (IOException e)
            {
                LOG.error("IOException", e);
                failResendInfo.setExceptionMsg(e.getMessage());
                insertPersonFailResendInfo(failResendInfo);
            }
            catch (Exception e)
            {
                LOG.error("Exception", e);
                failResendInfo.setExceptionMsg(e.getMessage());
                insertPersonFailResendInfo(failResendInfo);
            }
            finally
            {
                if (method != null)
                {
                    method.releaseConnection();
                }
            }
        }
        else
        {
            LOG.warn("error msgType.");
        }
        this.proxy = null;
    }
    
    private void insertPersonFailResendInfo(PersonFailResendInfo failResendInfo)
    {
        // insert
        // tbl_fail_resend_info(resendId,NURID,bpcUrl,filePath,userType,userData,studentData,receiveId,isModPhoto,exceptionMsg)
        // values(#{resendId},#{nurId},#{bpcUrl},#{filePath},#{userType},#{userData},#{studentData},#{receiveId},#{isModPhoto},#{exceptionMsg})
        WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
        FailResendDao failResendDao = (FailResendDao)context.getBean("failResendDao");
        failResendDao.addPersonFailResendInfo(failResendInfo);
    }
}
