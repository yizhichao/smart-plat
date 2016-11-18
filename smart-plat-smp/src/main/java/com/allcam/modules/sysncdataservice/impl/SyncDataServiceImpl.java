package com.allcam.modules.sysncdataservice.impl;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.websocket.Session;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.allcam.daoall.agent.dao.SchoolDao;
import com.allcam.daoall.agent.dao.UserDao;
import com.allcam.modules.bean.MsgHead;
import com.allcam.modules.organization.inf.OrganizationService;
import com.allcam.modules.school.inf.SchoolService;
import com.allcam.modules.student.inf.StudentService;
import com.allcam.modules.sysncdataservice.inf.SyncDataService;
import com.allcam.modules.sysncdataservice.model.SyncSchoolInfo;
import com.allcam.modules.sysncdataservice.model.SyncSchoolReq;
import com.allcam.modules.sysncdataservice.model.SyncSchoolReqBody;
import com.allcam.modules.sysncdataservice.model.SyncSchoolRes;
import com.allcam.modules.sysncdataservice.model.SyncSchoolResBody;
import com.allcam.modules.sysncdataservice.model.SyncStudentInfo;
import com.allcam.modules.sysncdataservice.model.SyncStudentReq;
import com.allcam.modules.sysncdataservice.model.SyncStudentReqBody;
import com.allcam.modules.sysncdataservice.model.SyncStudentRes;
import com.allcam.modules.sysncdataservice.model.SyncStudentResBodyPageInfo;
import com.allcam.modules.sysncdataservice.model.SyncTeacherInfo;
import com.allcam.modules.sysncdataservice.model.SyncTeacherReq;
import com.allcam.modules.sysncdataservice.model.SyncTeacherReqBody;
import com.allcam.modules.sysncdataservice.model.SyncTeacherRes;
import com.allcam.modules.sysncdataservice.model.SyncTeacherResBodyPageInfo;
import com.allcam.modules.user.inf.UserService;
import com.allcam.pojo.OrganizationInfo;
import com.allcam.pojo.PageBean;
import com.allcam.pojo.SchoolInfo;
import com.allcam.pojo.StudentInfo;
import com.allcam.pojo.UserInfo;
import com.allcam.utils.ConfigHelper;
import com.allcam.utils.DateUtil;
import com.allcam.utils.HttpRequestUtil;
import com.allcam.utils.JSonUtils;
import com.allcam.utils.StringUtil;
import com.allcam.utils.SystemConstant;
import com.allcam.utils.WebSocket;

/**
 * 
 * 同步数据处理
 * 
 * @author YiZhichao
 * @version [版本号, 2015年10月16日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Service
public class SyncDataServiceImpl implements SyncDataService
{
    public static final Log LOG = LogFactory.getLog(SyncDataServiceImpl.class);
    
    @Resource
    private UserDao userDao;
    
    @Resource
    private SchoolService schoolService;
    
    @Resource
    private UserService userService;
    
    @Resource
    private StudentService studentService;
    
    @Resource
    private SchoolDao schoolDao;
    
    @Resource
    private OrganizationService organizationService;
    
    @Override
    public boolean syncSchool(String sessionId, String schoolId, String schoolName)
        throws Exception
    {
        boolean result = false;
        LOG.debug("BDGW system begin sync school info");
        try
        {
            WebSocket ws = new WebSocket();
            
            SyncSchoolReq syncSchoolReq = new SyncSchoolReq();
            
            MsgHead msgHead = new MsgHead();
            msgHead.setMsgType("SYNC_SCHOOL");
            msgHead.setDirection(SystemConstant.DIRECTION_REQUEST);
            SyncSchoolReqBody syncSchoolReqBody = new SyncSchoolReqBody();
            
            syncSchoolReq.setMsgHead(msgHead);
            syncSchoolReq.setSyncSchoolReqBody(syncSchoolReqBody);
            
            String syncSchoolAddress = ConfigHelper.getValueByKey("sync.schoolinfo.request.address");
            // 发送同步学校请求
            String responseBody = HttpRequestUtil.httpPostWithJSON(JSonUtils.toJSon(syncSchoolReq), syncSchoolAddress);
            
            // 将字符串转换为对象
            SyncSchoolRes syncSchoolRes = JSonUtils.readValue(responseBody, SyncSchoolRes.class);
            
            SyncSchoolResBody syncSchoolResBody = syncSchoolRes.getSyncSchoolResBody();
            
            if (null != syncSchoolResBody)
            {
                List<SyncSchoolInfo> syncSchoolInfoList = syncSchoolResBody.getSchoolList();
                
                if (CollectionUtils.isNotEmpty(syncSchoolInfoList))
                {
                    SchoolInfo schoolInfo = null;
                    SchoolInfo querySchoolInfo = null;
                    int total = syncSchoolInfoList.size();
                    int index = 0;
                    for (SyncSchoolInfo syncSchoolInfo : syncSchoolInfoList)
                    {
                        index++;
                        schoolInfo = new SchoolInfo();
                        schoolInfo.setSchoolId(syncSchoolInfo.getSchoolId());
                        querySchoolInfo = schoolService.queryOneSchoolInfoByCer(syncSchoolInfo.getSchoolId());
                        
                        // 如果根据学校ID获取到的学校信息不为空，则表示是更新操作，否则是新增操作
                        if (null != querySchoolInfo)
                        {
                            querySchoolInfo.setSchoolName(syncSchoolInfo.getSchoolName());
                            querySchoolInfo.setAnonymousName(syncSchoolInfo.getAnonymousName());
                            querySchoolInfo.setSchoolLogo(syncSchoolInfo.getLogoUrl());
                            querySchoolInfo.setSchoolHome(syncSchoolInfo.getShopUrl());
                            querySchoolInfo.setSort(syncSchoolInfo.getSort());
                            
                            querySchoolInfo.setBpmServerUrl(syncSchoolInfo.getBpmServerUrl());
                            querySchoolInfo.setBpcServerUrl(syncSchoolInfo.getBpcServerUrl());
                            querySchoolInfo.setBpcHttpsServerUrl(syncSchoolInfo.getBpcHttpsServerUrl());
                            
                            schoolService.updateSchoolInfo(querySchoolInfo);
                        }
                        else
                        {
                            schoolInfo.setSchoolName(syncSchoolInfo.getSchoolName());
                            schoolInfo.setAnonymousName(syncSchoolInfo.getAnonymousName());
                            schoolInfo.setSchoolLogo(syncSchoolInfo.getLogoUrl());
                            schoolInfo.setSchoolHome(syncSchoolInfo.getShopUrl());
                            schoolInfo.setSort(syncSchoolInfo.getSort());
                            schoolInfo.setBpmServerUrl(syncSchoolInfo.getBpmServerUrl());
                            schoolInfo.setBpcServerUrl(syncSchoolInfo.getBpcServerUrl());
                            schoolInfo.setBpcHttpsServerUrl(syncSchoolInfo.getBpcHttpsServerUrl());
                            
                            schoolService.addSchoolInfo(schoolInfo);
                            
                            // 添加该学校的顶级组织
                            OrganizationInfo organizationInfo = new OrganizationInfo();
                            organizationInfo.setOrganizationId(schoolInfo.getSchoolId());
                            organizationInfo.setOrganizationName(schoolInfo.getSchoolName());
                            organizationInfo.setParentOrganizationId("1");
                            organizationInfo.setSchoolId(schoolInfo.getSchoolId());
                            organizationInfo.setSort("1");
                            organizationService.addOrganizationInfo(organizationInfo);
                        }
                        if (StringUtils.isNotBlank(sessionId))
                        {
                            Session session = WebSocket.sessionPool.get(sessionId);
                            if (null != session && session.isOpen())
                            {
                                ws.onMessage(index * 100 / total + "%", session);
                            }
                            
                        }
                        
                    }
                }
                else
                {
                    Session session = WebSocket.sessionPool.get(sessionId);
                    if (null != session && session.isOpen())
                    {
                        ws.onMessage("100%", session);
                    }
                }
            }
            result = true;
        }
        catch (Exception e)
        {
            LOG.error("BDGW system sync school info fail!", e);
            throw new Exception();
        }
        LOG.debug("BDGW system end sync school info");
        return result;
    }
    
    @Override
    public boolean syncTeacher(String sessionId, String schoolId)
        throws Exception
    {
        boolean result = false;
        LOG.debug("BDGW system begin sync teacher info");
        try
        {
            WebSocket websocket = new WebSocket();
            Session session = WebSocket.sessionPool.get(sessionId);
            SchoolInfo schoolInfo = new SchoolInfo();
            Map<String, Object> map = new HashMap<String, Object>();
            schoolInfo.setSchoolId(schoolId);
            map.put("schoolInfo", schoolInfo);
            PageBean pageBean = new PageBean();
            pageBean.setPageNo(1);
            pageBean.setPageSize(1000);
            map.put("pageBean", pageBean);
            List<SchoolInfo> schoolInfoList = schoolDao.querySchoolInfoByCer(map);
            if (CollectionUtils.isNotEmpty(schoolInfoList))
            {
                for (SchoolInfo syncSchoolInfo : schoolInfoList)
                {
                    syncTeacherInfo(websocket, session, syncSchoolInfo.getSchoolId(), syncSchoolInfo.getBpmServerUrl());
                }
            }
            result = true;
        }
        catch (Exception e)
        {
            LOG.error("BDGW system sync teacher info fail!", e);
            throw new Exception();
        }
        LOG.debug("BDGW system end sync teacher info");
        return result;
    }
    
    /**
     * 定时任务同步老师信息
     * 
     * @param schoolId 学校ID
     * @param bpmServerUrl 学校管理系统HTTP URL
     */
    public void syncTeacherInfo(WebSocket ws, Session session, String schoolId, String bpmServerUrl)
    {
        try
        {
            LOG.debug("BDGW system begin sync teacher info");
            
            SyncTeacherRes syncTeacherRes = reqSyncTeacher("1", schoolId, bpmServerUrl);
            
            if (null != syncTeacherRes && null != syncTeacherRes.getMsgBody())
            {
                SyncTeacherResBodyPageInfo pageInfo = syncTeacherRes.getMsgBody().getPageInfo();
                
                List<SyncTeacherInfo> syncTeacherInfoList = syncTeacherRes.getMsgBody().getUserList();
                
                // 保存同步的用户信息
                saveSyncTeacherInfoList(ws, session, syncTeacherInfoList, schoolId);
                
                if (null != pageInfo)
                {
                    int totalPage = Integer.parseInt(pageInfo.getTotalPage());
                    
                    for (int i = 2; i <= totalPage; i++)
                    {
                        syncTeacherRes = reqSyncTeacher(String.valueOf(i), schoolId, bpmServerUrl);
                        
                        syncTeacherInfoList = syncTeacherRes.getMsgBody().getUserList();
                        
                        // 保存同步的用户信息
                        saveSyncTeacherInfoList(ws, session, syncTeacherInfoList, schoolId);
                    }
                }
            }
            else
            {
                if (null != session && session.isOpen())
                {
                    ws.onMessage("100%", session);
                }
            }
            LOG.debug("BDGW system end sync teacher info");
        }
        catch (IOException e)
        {
            LOG.error("BDGW system sync teacher info fail!", e);
        }
        catch (Exception e)
        {
            LOG.error("BDGW system sync teacher info fail!", e);
        }
    }
    
    private void saveSyncTeacherInfoList(WebSocket ws, Session session, List<SyncTeacherInfo> syncTeacherInfoList,
        String schoolId)
    {
        try
        {
            if (CollectionUtils.isNotEmpty(syncTeacherInfoList))
            {
                int total = syncTeacherInfoList.size();
                int index = 0;
                for (SyncTeacherInfo syncTeacherInfo : syncTeacherInfoList)
                {
                    index++;
                    UserInfo userInfoParam = new UserInfo();
                    userInfoParam.setUserId(syncTeacherInfo.getUserId());
                    UserInfo userInfo = userService.getUserInfoByCer(userInfoParam);
                    // 如果根据登录名获取到的用户信息不为空，则表示是更新操作，否则是新增操作
                    if (null != userInfo)
                    {
                        userInfo.setCardId(syncTeacherInfo.getCardId());
                        userInfo.setUserId(syncTeacherInfo.getUserId());
                        userInfo.setUserCode(syncTeacherInfo.getUserCode());
                        userInfo.setLoginName(syncTeacherInfo.getUserName());
                        userInfo.setUserName(syncTeacherInfo.getDisplayName());
                        userInfo.setAccType(syncTeacherInfo.getAccType());
                        userInfo.setStatus(syncTeacherInfo.getStatus());
                        userInfo.setSex(syncTeacherInfo.getSex());
                        userInfo.setEmail(syncTeacherInfo.getEmail());
                        userInfo.setPhone(syncTeacherInfo.getPhone());
                        userInfo.setHomeAddress(syncTeacherInfo.getAddress());
                        userInfo.setPostCode(syncTeacherInfo.getPostCode());
                        userInfo.setPhoto(syncTeacherInfo.getPhoto());
                        userInfo.setShortPhone(syncTeacherInfo.getShortPhone());
                        userInfo.setFixedPhone(syncTeacherInfo.getFixedPhone());
                        userInfo.setHomeAddress(syncTeacherInfo.getAddress());
                        
                        userService.updateUserInfoByCer(userInfo);
                        userService.updateUserExtendInfoByCer(userInfo);
                    }
                    else
                    {
                        if (!StringUtil.isNull(syncTeacherInfo.getCardId()))
                        {
                            userInfo = new UserInfo();
                            // userInfo.setPassword(DASASEEncryptUtil.encryptData("123456",
                            // syncTeacherInfo.getUserId()));
                            // userInfo.setUserCode("1111");
                            userInfo.setCardId(syncTeacherInfo.getCardId());
                            // 角色编号默认为5(老师)
                            userInfo.setRoleId("5");
                            userInfo.setSchoolId(schoolId);
                            userInfo.setOrganizationId(userInfo.getSchoolId());
                            
                            userInfo.setUserId(syncTeacherInfo.getUserId());
                            userInfo.setUserCode(syncTeacherInfo.getUserCode());
                            userInfo.setLoginName(syncTeacherInfo.getUserName());
                            userInfo.setUserName(syncTeacherInfo.getDisplayName());
                            userInfo.setAccType(syncTeacherInfo.getAccType());
                            userInfo.setStatus(syncTeacherInfo.getStatus());
                            userInfo.setSex(syncTeacherInfo.getSex());
                            userInfo.setEmail(syncTeacherInfo.getEmail());
                            userInfo.setPhone(syncTeacherInfo.getPhone());
                            userInfo.setHomeAddress(syncTeacherInfo.getAddress());
                            userInfo.setPostCode(syncTeacherInfo.getPostCode());
                            userInfo.setPhoto(syncTeacherInfo.getPhoto());
                            userInfo.setShortPhone(syncTeacherInfo.getShortPhone());
                            userInfo.setFixedPhone(syncTeacherInfo.getFixedPhone());
                            userInfo.setHomeAddress(syncTeacherInfo.getAddress());
                            
                            userService.addUserInfo(userInfo);
                            userService.addUserExtendInfo(userInfo);
                        }
                    }
                    if (null != session && session.isOpen())
                    {
                        ws.onMessage(index * 100 / total + "%", session);
                    }
                }
            }
            else
            {
                if (null != session && session.isOpen())
                {
                    ws.onMessage("100%", session);
                }
            }
        }
        catch (Exception e)
        {
            LOG.error("BDGW system sync teacher info fail!", e);
        }
    }
    
    private SyncTeacherRes reqSyncTeacher(String pageNo, String schoolId, String bpmServerUrl)
        throws IOException, Exception
    {
        SyncTeacherReq syncTeacherReq = new SyncTeacherReq();
        
        MsgHead msgHead = new MsgHead();
        msgHead.setMsgType("SYNC_TEACHER");
        msgHead.setDirection(SystemConstant.DIRECTION_REQUEST);
        
        SyncTeacherReqBody syncTeacherReqBody = new SyncTeacherReqBody();
        syncTeacherReqBody.setPageNo(pageNo);
        syncTeacherReqBody.setPageSize("100");
        syncTeacherReqBody.setSchoolId(schoolId);
        
        syncTeacherReq.setMsgHead(msgHead);
        syncTeacherReq.setSyncTeacherReqBody(syncTeacherReqBody);
        
        // 发送用户单点登录请求
        String responseBody = HttpRequestUtil.httpPostWithJSON(JSonUtils.toJSon(syncTeacherReq), bpmServerUrl);
        
        // 将字符串转换为对象
        SyncTeacherRes syncTeacherRes = JSonUtils.readValue(responseBody, SyncTeacherRes.class);
        
        return syncTeacherRes;
    }
    
    @Override
    public boolean syncStudent(String sessionId, String schoolId)
        throws Exception
    {
        boolean result = false;
        LOG.debug("BDGW system begin sync student info");
        try
        {
            WebSocket websocket = new WebSocket();
            Session session = WebSocket.sessionPool.get(sessionId);
            SchoolInfo schoolInfo = new SchoolInfo();
            Map<String, Object> map = new HashMap<String, Object>();
            schoolInfo.setSchoolId(schoolId);
            map.put("schoolInfo", schoolInfo);
            PageBean pageBean = new PageBean();
            pageBean.setPageNo(1);
            pageBean.setPageSize(1000);
            map.put("pageBean", pageBean);
            List<SchoolInfo> schoolInfoList = schoolDao.querySchoolInfoByCer(map);
            if (CollectionUtils.isNotEmpty(schoolInfoList))
            {
                for (SchoolInfo syncSchoolInfo : schoolInfoList)
                {
                    syncStudentInfo(websocket, session, syncSchoolInfo.getSchoolId(), syncSchoolInfo.getBpmServerUrl());
                }
            }
            else
            {
                if (null != session && session.isOpen())
                {
                    websocket.onMessage("100%", session);
                }
            }
            result = true;
        }
        catch (Exception e)
        {
            LOG.error("BDGW system sync student info fail!", e);
            throw new Exception();
        }
        LOG.debug("BDGW system end sync student info");
        return result;
    }
    
    /**
     * 定时任务同步老师信息
     * 
     * @param schoolId 学校ID
     * @param bpmServerUrl 学校管理系统HTTP URL
     */
    public void syncStudentInfo(WebSocket ws, Session session, String schoolId, String bpmServerUrl)
    {
        try
        {
            LOG.debug("BDGW system begin sync student info");
            
            SyncStudentRes syncStudentRes = reqSyncStudent("1", schoolId, bpmServerUrl);
            
            if (null != syncStudentRes && null != syncStudentRes.getMsgBody())
            {
                SyncStudentResBodyPageInfo pageInfo = syncStudentRes.getMsgBody().getPageInfo();
                
                List<SyncStudentInfo> syncStudentInfoList = syncStudentRes.getMsgBody().getStudentList();
                
                // 保存同步的用户信息
                saveSyncStudentInfoList(ws, session, syncStudentInfoList, schoolId);
                
                if (null != pageInfo)
                {
                    int totalPage = Integer.parseInt(pageInfo.getTotalPage());
                    
                    for (int i = 2; i <= totalPage; i++)
                    {
                        syncStudentRes = reqSyncStudent(String.valueOf(i), schoolId, bpmServerUrl);
                        
                        syncStudentInfoList = syncStudentRes.getMsgBody().getStudentList();
                        
                        // 保存同步的用户信息
                        saveSyncStudentInfoList(ws, session, syncStudentInfoList, schoolId);
                    }
                }
            }
            else
            {
                if (null != session && session.isOpen())
                {
                    ws.onMessage("100%", session);
                }
            }
            LOG.debug("BDGW system end sync student info");
        }
        catch (IOException e)
        {
            LOG.error("BDGW system sync student info fail!", e);
        }
        catch (Exception e)
        {
            LOG.error("BDGW system sync student info fail!", e);
        }
    }
    
    private void saveSyncStudentInfoList(WebSocket ws, Session session, List<SyncStudentInfo> syncStudentInfoList,
        String schoolId)
    {
        try
        {
            if (CollectionUtils.isNotEmpty(syncStudentInfoList))
            {
                int total = syncStudentInfoList.size();
                int index = 0;
                for (SyncStudentInfo syncStudentInfo : syncStudentInfoList)
                {
                    index++;
                    if (!StringUtil.isNull(syncStudentInfo.getCardId()))
                    {
                        StudentInfo studentInfo = new StudentInfo();
                        studentInfo.setSchoolId(schoolId);
                        studentInfo.setCardId(syncStudentInfo.getCardId());
                        studentInfo.setUserId(syncStudentInfo.getUserId());
                        studentInfo.setUserName(syncStudentInfo.getUserName());
                        studentInfo.setDisplayName(syncStudentInfo.getDisplayName());
                        studentInfo.setUserPhoto(syncStudentInfo.getUserPhoto());
                        studentInfo.setStudentId(syncStudentInfo.getStudentId());
                        studentInfo.setStudentCode(syncStudentInfo.getStudentCode());
                        studentInfo.setStudentName(syncStudentInfo.getStudentName());
                        studentInfo.setStudentEnName(syncStudentInfo.getStudentEnName());
                        studentInfo.setGender(syncStudentInfo.getGender());
                        studentInfo.setGradeName(syncStudentInfo.getGradeName());
                        studentInfo.setClassName(syncStudentInfo.getClassName());
                        studentInfo.setPhoto(syncStudentInfo.getPhoto());
                        studentInfo.setLastDate(DateUtil.formatTime(new Date(), DateUtil.DATE_14));
                        studentService.addStudentInfo(studentInfo);
                    }
                    if (null != session && session.isOpen())
                    {
                        ws.onMessage(index * 100 / total + "%", session);
                    }
                }
            }
            else
            {
                if (null != session && session.isOpen())
                {
                    ws.onMessage("100%", session);
                }
            }
        }
        catch (IOException e)
        {
            LOG.error("BDGW system sync student info fail!", e);
        }
        catch (InterruptedException e)
        {
            LOG.error("BDGW system sync student info fail!", e);
        }
    }
    
    private SyncStudentRes reqSyncStudent(String pageNo, String schoolId, String bpmServerUrl)
        throws IOException, Exception
    {
        SyncStudentReq syncStudentReq = new SyncStudentReq();
        
        MsgHead msgHead = new MsgHead();
        msgHead.setMsgType("SYNC_STUDENT");
        msgHead.setDirection(SystemConstant.DIRECTION_REQUEST);
        
        SyncStudentReqBody syncStudentReqBody = new SyncStudentReqBody();
        syncStudentReqBody.setPageNo(pageNo);
        syncStudentReqBody.setPageSize("100");
        syncStudentReqBody.setSchoolId(schoolId);
        
        syncStudentReq.setMsgHead(msgHead);
        syncStudentReq.setSyncStudentReqBody(syncStudentReqBody);
        
        // 发送用户单点登录请求
        String responseBody = HttpRequestUtil.httpPostWithJSON(JSonUtils.toJSon(syncStudentReq), bpmServerUrl);
        
        // 将字符串转换为对象
        SyncStudentRes syncStudentRes = JSonUtils.readValue(responseBody, SyncStudentRes.class);
        
        return syncStudentRes;
    }
}
