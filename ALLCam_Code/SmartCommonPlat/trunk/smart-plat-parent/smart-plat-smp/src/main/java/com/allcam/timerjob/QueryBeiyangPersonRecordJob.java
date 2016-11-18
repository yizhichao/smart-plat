package com.allcam.timerjob;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.allcam.daoall.agent.dao.FailResendDao;
import com.allcam.daoall.agent.dao.NurSeryBeiyangMapDao;
import com.allcam.daoall.beiyangmiddle.dao.OriginalRecordDao;
import com.allcam.pojo.NurSeryBeiyangMapInfo;
import com.allcam.pojo.OriginalRecordInfo;
import com.allcam.pojo.PersonFailResendInfo;
import com.allcam.utils.ConfigHelper;
import com.allcam.utils.DateUtil;
import com.allcam.utils.JsonParseUtil;
import com.allcam.utils.StringUtil;

@Service
public class QueryBeiyangPersonRecordJob
{
    public static final Log LOG = LogFactory.getLog(QueryBeiyangPersonRecordJob.class);
    
    @Resource
    private FailResendDao failResendDao;
        
    @Resource
    private NurSeryBeiyangMapDao nurSeryBeiyangMapDao;
    
    @Resource
    private OriginalRecordDao originalRecordDao;
    
    private static final HttpClient httpClient = new HttpClient();
    
    protected static final int httpConnectionTimeOut =
        Integer.parseInt(ConfigHelper.getValueByKey("http.connection.timeout"));
    
    protected static final String BPC_SERVER_INTERFACE = ConfigHelper.getValueByKey("BPC.SERVER.INTERFACE");
    
    protected static final String version = ConfigHelper.getValueByKey("beiyang.httpMsgVersion");
    
    protected static final String deviceType = ConfigHelper.getValueByKey("beiyang.deviceType");
    
    protected static final String softVersion = ConfigHelper.getValueByKey("beiyang.softVersion");
    
    protected static final String pageSize = ConfigHelper.getValueByKey("beiyang.page.pageSize");
    
    protected static final String fileServer = ConfigHelper.getValueByKey("beiyang.file.server");
    
    protected static final String fileType = ConfigHelper.getValueByKey("beiyang.file.type");
    
    protected static final String fileTypeHttp = "0";
    
    protected static final String fileTypeLocal = "1";
    
    protected static final String goIn = "10";
    
    protected static final String goInSchool = "1";
    
    protected static final String goOutSchool = "2";
    
    public void queryBeiyangPersonRecord()
    {
        System.out.println("QueryBeiyangPersonRecordJob.queryBeiyangPersonRecord begin.");
        
        NurSeryBeiyangMapInfo nurSeryBeiyangMapInfo = new NurSeryBeiyangMapInfo();
        List<NurSeryBeiyangMapInfo> list = nurSeryBeiyangMapDao.queryNurSeryBeiyangMap(nurSeryBeiyangMapInfo);
        LOG.info("List<NurSeryBeiyangMapInfo> list:[" + list + "]");
        if (null != list && 0 < list.size())
        {
            for (int n = 0; n < list.size(); n++)
            {
                NurSeryBeiyangMapInfo nurseryInfo = list.get(n);
                int startIndex = list.get(0).getStartIndex();
                // Date startTime = nurseryInfo.getStartTime();
                OriginalRecordInfo originalRecordInfo = new OriginalRecordInfo();
                // if (null != startTime)
                // {
                // SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                // originalRecordInfo.setStartTime(df.format(new java.sql.Timestamp(startTime.getTime())));
                // }
                originalRecordInfo.setSerialNum(startIndex);
                originalRecordInfo.setPageSize(pageSize);
                originalRecordInfo.setTableName(nurseryInfo.getOriginalrecordTblname());
                List<OriginalRecordInfo> result = originalRecordDao.getOriginalRecordInfo(originalRecordInfo);
                // Date maxDate = startTime;
                int maxNum = startIndex;
                if (null != result && 0 < result.size())
                {
                    // 循环 通过记录 ，上报到BPC
                    for (int i = 0; i < result.size(); i++)
                    {
                        OriginalRecordInfo studentInfo = result.get(i);
                        // 赋值
                        if (maxNum < studentInfo.getSerialNum())
                        {
                            maxNum = studentInfo.getSerialNum();
                        }
                        // // 赋值
                        // if (null == maxDate || maxDate.getTime() < studentInfo.getUploadTime().getTime())
                        // {
                        // maxDate = studentInfo.getUploadTime();
                        // }
                        StringBuffer studentData = new StringBuffer(0);
                        studentData.append("&users=").append("");// 没有家长手机号码
                        studentData.append("&studentCode=").append(studentInfo.getPersonID()); // 学号
                        // 进出入类型：1:入园 2:离园
                        studentData.append("&action=");
                        if (goIn.equals(studentInfo.getDirection()))
                        {
                            studentData.append(goInSchool);
                        }
                        else
                        {
                            studentData.append(goOutSchool);
                        }
                        studentData.append("&dateTime=")
                            .append(DateUtil.getLongToDate(Long.valueOf(studentInfo.getTime())));
                        // String studentData = "20150618094422";
                        // 20150525145307
                        String nurId = nurseryInfo.getNurId();
                        String bpcUrl =
                            nurseryInfo.getBpcServerUrl().substring(0,
                                nurseryInfo.getBpcServerUrl().indexOf("/BPC/HttpServer"));
                        sendDataToBPC(nurId, bpcUrl, studentInfo.getCatchPicture(), studentData.toString());
                    }
                    // // 修改 startTime
                    // nurseryInfo.setStartTime(maxDate);
                    // 修改StartIndex
                    nurseryInfo.setStartIndex(maxNum);
                    nurSeryBeiyangMapDao.modNurSeryBeiyangMap(nurseryInfo);
                }
            }
        }
        // LOG.info("QueryBeiyangPersonRecordJob.queryBeiyangPersonRecord end.");
    }
    
    private String sendDataToBPC(String nurId, String bpcUrl, String filePath, String studentData)
    {
        String resultUrl = null;
        boolean readPhotoFail = false;
        try
        {
            StringBuffer buf = new StringBuffer(0);
            buf.append(bpcUrl);
            buf.append(BPC_SERVER_INTERFACE);
            buf.append("?version=").append(version);
            buf.append("&direction=request&msgType=ENTRY_EXIT_NOTIFY&sysId=");
            buf.append(nurId);
            buf.append("&deviceType=").append(deviceType);
            buf.append("&softVersion=").append(softVersion);
            buf.append(studentData);
            InputStream inputSteam = null;
            if (fileTypeHttp.equals(fileType) && !StringUtil.isNull(filePath))
            {
                try
                {
                    String httpUrl = fileServer + filePath;
                    URL url = new URL(httpUrl);
                    URLConnection conn = url.openConnection();
                    inputSteam = conn.getInputStream();
                }
                catch (Exception e)
                {
                    inputSteam = null;
                    buf.append("&isUpPhoto=").append("readPhotoFail");
                    readPhotoFail = true;
                    LOG.error("Exception", e);
                }
            }
            else if (fileTypeLocal.equals(fileType) && !StringUtil.isNull(filePath))
            {
                try
                {
                    filePath = fileServer + filePath;
                    File file = new File(filePath);
                    inputSteam = new FileInputStream(file);
                }
                catch (Exception e)
                {
                    inputSteam = null;
                    buf.append("&isUpPhoto=").append("readPhotoFail");
                    readPhotoFail = true;
                    LOG.error("Exception", e);
                }
            }
            else
            {
                buf.append("&isUpPhoto=").append("false");
            }
            PostMethod method = new PostMethod(buf.toString());
            RequestEntity requestEntity = null;
            if (null != inputSteam)
            {
                requestEntity = new InputStreamRequestEntity(inputSteam, "UTF-8");
                method.setRequestEntity(requestEntity);
            }
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
                    // 入二次修改图片的失败记录
                    if (readPhotoFail)
                    {
                        // ,\"MsgBody\":{\"receiveId\":\""+ req.getReceiveId() + "\"}}";
                        // {receiveId=sdfasdfdfdfsdfasdfasdf}
                        String msgBody = map.get("MsgBody").toString();
                        String receiveId = msgBody.substring(msgBody.indexOf("=")+1,msgBody.lastIndexOf("}"));
                        insertPersonFailResendInfo(nurId,
                            bpcUrl,
                            filePath,
                            studentData,
                            receiveId,
                            readPhotoFail,
                            "response 200 , localPhoto read fail.");
                    }
                }
                else
                {
                    LOG.error(map.get("Result").toString());
                    insertPersonFailResendInfo(nurId,
                        bpcUrl,
                        filePath,
                        studentData,
                        "",
                        readPhotoFail,
                        "response 200 but response body Result is [" + map.get("Result").toString() + "].");
                }
            }
            
            method.releaseConnection();
        }
        catch (MalformedURLException e)
        {
            LOG.error("MalformedURLException", e);
            insertPersonFailResendInfo(nurId, bpcUrl, filePath, studentData, "", readPhotoFail, e.getMessage());
        }
        catch (IOException e)
        {
            LOG.error("IOException", e);
            insertPersonFailResendInfo(nurId, bpcUrl, filePath, studentData, "", readPhotoFail, e.getMessage());
        }
        catch (Exception e)
        {
            LOG.error("Exception", e);
            insertPersonFailResendInfo(nurId, bpcUrl, filePath, studentData, "", readPhotoFail, e.getMessage());
        }
        return resultUrl;
    }
    
    private void insertPersonFailResendInfo(String nurId, String bpcUrl, String filePath, String studentData,
        String receiveId, boolean readPhotoFail, String exceptionMsg)
    {
        // insert
        // tbl_fail_resend_info(resendId,NURID,bpcUrl,filePath,studentData,receiveId,isModPhoto,status)
        // values(#{receiveId},#{nurId},#{bpcUrl},#{filePath},#{studentData},#{receiveId},#{isModPhoto},#{status})
        PersonFailResendInfo person = new PersonFailResendInfo();
        person.setResendId(UUID.randomUUID().toString());
        person.setNurId(nurId);
        person.setBpcUrl(bpcUrl);
        person.setFilePath(filePath);
        person.setStudentData(studentData);
        person.setReceiveId("");
        person.setExceptionMsg(exceptionMsg);
        if (readPhotoFail)
        {
            person.setIsModPhoto(1);
        }
        else
        {
            person.setIsModPhoto(0);
        }
        failResendDao.addPersonFailResendInfo(person);
    }
}
