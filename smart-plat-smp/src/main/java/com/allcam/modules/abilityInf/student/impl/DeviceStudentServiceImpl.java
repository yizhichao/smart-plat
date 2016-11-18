package com.allcam.modules.abilityInf.student.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;

import com.allcam.common.ServiceContants;
import com.allcam.daoall.agent.dao.StudentDao;
import com.allcam.modules.abilityInf.student.inf.DeviceStudentService;
import com.allcam.modules.abilityInf.student.model.DeviceSyncStudentReq;
import com.allcam.modules.abilityInf.student.model.DeviceSyncStudentResp;
import com.allcam.modules.abilityInf.user.model.DeviceSyncTeacherReq;
import com.allcam.modules.abilityInf.user.model.TeacherInfo;
import com.allcam.modules.bean.PageInfo;
import com.allcam.pojo.PageBean;
import com.allcam.pojo.StudentInfo;
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
public class DeviceStudentServiceImpl implements DeviceStudentService
{
    @Resource
    private StudentDao studentDao;
    
    /**
     * 
     * @param req 设备注册接口
     * @return 设备响应
     * @throws Exception
     */
    public DeviceSyncStudentResp syncStudent(DeviceSyncStudentReq req)
    {
        DeviceSyncStudentResp resp = new DeviceSyncStudentResp();
        try
        {
            Map<String, Object> map = new HashMap<String, Object>();
            
            PageBean pageBean = getPageBean(req);
            map.put("pageBean", pageBean);
            map.put("req", req);
            List<StudentInfo> result = studentDao.queryDeviceSyncStudentByPage(map);
            PageInfo pageInfo = new PageInfo();
            pageInfo.setPageNo(String.valueOf(pageBean.getPageNo()));
            pageInfo.setPageSize(String.valueOf(pageBean.getPageSize()));
            pageInfo.setTotalCount(String.valueOf(pageBean.getTotalCount()));
            pageInfo.setTotalPage(String.valueOf(pageBean.getTotalPage()));
            resp.setPageInfo(pageInfo);
            resp.setStudentList(result);
            resp.setPageInfo(pageInfo);
            resp.setTaskServerUrl("http://".concat(Env.getWebCommon().get("httpSever/localIP"))
                .concat(Env.getWebCommon().get(":"))
                .concat(Env.getWebCommon().get("httpSever/localPort"))
                .concat("/BDGW/SYNC_STUDENT")
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
    
    protected PageBean getPageBean(DeviceSyncStudentReq req)
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
