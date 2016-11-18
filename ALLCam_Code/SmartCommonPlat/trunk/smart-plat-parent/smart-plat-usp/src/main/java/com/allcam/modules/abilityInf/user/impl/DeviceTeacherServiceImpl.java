package com.allcam.modules.abilityInf.user.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;

import com.allcam.common.ServiceContants;
import com.allcam.daoall.agent.dao.UserDao;
import com.allcam.modules.abilityInf.user.inf.DeviceTeacherService;
import com.allcam.modules.abilityInf.user.model.DeviceSyncTeacherReq;
import com.allcam.modules.abilityInf.user.model.DeviceSyncTeacherResp;
import com.allcam.modules.abilityInf.user.model.TeacherInfo;
import com.allcam.modules.bean.PageInfo;
import com.allcam.pojo.PageBean;
import com.allcam.pojo.UserInfo;
import com.allcam.utils.DateUtil;
import com.allcam.utils.Env;

/**
 * 设备相关业务处理层的接口
 * 
 * @author YiZhichao
 * @version [版本号, 2015-3-6]
 */
@Service
public class DeviceTeacherServiceImpl implements DeviceTeacherService
{
    @Resource
    private UserDao userDao;
    
    /**
     * 
     * @param req 设备注册接口
     * @return 设备响应
     * @throws Exception
     */
    public DeviceSyncTeacherResp syncTeacher(DeviceSyncTeacherReq req)
    {
        DeviceSyncTeacherResp resp = new DeviceSyncTeacherResp();
        try
        {
            Map<String, Object> map = new HashMap<String, Object>();
            PageBean pageBean = getPageBean(req);
            map.put("pageBean", pageBean);
            map.put("req", req);
            List<UserInfo> result = userDao.queryDeviceSyncTeacherByPage(map);
            PageInfo pageInfo = new PageInfo();
            pageInfo.setPageNo(String.valueOf(pageBean.getPageNo()));
            pageInfo.setPageSize(String.valueOf(pageBean.getPageSize()));
            pageInfo.setTotalCount(String.valueOf(pageBean.getTotalCount()));
            pageInfo.setTotalPage(String.valueOf(pageBean.getTotalPage()));
            List<TeacherInfo> userList = new ArrayList<TeacherInfo>();
            if (CollectionUtils.isNotEmpty(result))
            {
                for (int i = 0; i < result.size(); i++)
                {
                    TeacherInfo teacherInfo = new TeacherInfo();
                    teacherInfo.setAccType(result.get(i).getAccType());
                    teacherInfo.setAddress(result.get(i).getHomeAddress());
                    teacherInfo.setCardId(result.get(i).getCardId());
                    teacherInfo.setDisplayName(result.get(i).getUserName());
                    teacherInfo.setEmail(result.get(i).getEmail());
                    teacherInfo.setFixedPhone(result.get(i).getFixedPhone());
                    teacherInfo.setPhone(result.get(i).getPhone());
                    teacherInfo.setPhoto(result.get(i).getPhoto());
                    teacherInfo.setPostCode(result.get(i).getPostCode());
                    teacherInfo.setSex(result.get(i).getSex());
                    teacherInfo.setShortPhone(result.get(i).getShortPhone());
                    teacherInfo.setUserCode(result.get(i).getUserCode());
                    teacherInfo.setUserId(result.get(i).getUserId());
                    teacherInfo.setUserName(result.get(i).getUserName());
                    userList.add(teacherInfo);
                }
            }
            resp.setUserList(userList);
            resp.setPageInfo(pageInfo);
            resp.setTaskServerUrl("http://".concat(Env.getWebCommon().get("httpSever/localIP"))
                .concat(":")
                .concat(Env.getWebCommon().get("httpSever/localPort"))
                .concat("/BDGW/SYNC_TEACHER")
                .concat("?encrypt=")
                .concat(Env.getWebCommon().get("httpSever/encryptKey"))
                .concat("&timestamp=")
                .concat(DateUtil.formatTime(new Date(), DateUtil.DATE_14)));
            resp.setSchoolId(req.getSchoolId());
            resp.setDeviceId(req.getDeviceId());
            resp.setErrorCode(ServiceContants.SUCCESS_CODE);
            resp.setErrorDes(ServiceContants.SUCCESS_DES);
        }
        catch (Exception e)
        {
            resp.setErrorCode(ServiceContants.FAIL_CODE);
            resp.setErrorDes(ServiceContants.FAIL_DES);
        }
        return resp;
    }
    
    protected PageBean getPageBean(DeviceSyncTeacherReq req)
    {
        PageBean pageBean = new PageBean();
        if (StringUtils.isNotBlank(req.getPageNo()))
        {
            pageBean.setPageNo(NumberUtils.toInt(req.getPageNo()));
        }
        if (StringUtils.isNotBlank(req.getPageSize()))
        {
            pageBean.setPageSize(NumberUtils.toInt(req.getPageSize()));
        }
        return pageBean;
    }
}
