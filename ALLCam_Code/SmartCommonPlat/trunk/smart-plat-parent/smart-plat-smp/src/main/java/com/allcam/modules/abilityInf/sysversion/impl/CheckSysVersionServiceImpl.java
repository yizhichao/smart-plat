package com.allcam.modules.abilityInf.sysversion.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.allcam.common.ServiceContants;
import com.allcam.daoall.agent.dao.CuVersionDao;
import com.allcam.modules.abilityInf.sysversion.inf.CheckSysVersionService;
import com.allcam.modules.abilityInf.sysversion.model.CheckSysVersionReq;
import com.allcam.modules.abilityInf.sysversion.model.CheckSysVersionResp;
import com.allcam.pojo.CuVersionInfo;

/**
 * 
 * <一句话功能简述> <功能详细描述>
 * 
 * @author Administrator
 * @version [版本号, 2015年10月21日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Service
public class CheckSysVersionServiceImpl implements CheckSysVersionService
{
    @Resource
    CuVersionDao cuVersionDao;
    
    private static final Log LOG = LogFactory.getLog(CheckSysVersionServiceImpl.class);
    
    public CheckSysVersionResp checkSysVersion(CheckSysVersionReq req)
    {
        CheckSysVersionResp resp = new CheckSysVersionResp();
        try
        {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("checkSysVersionReq", req);
            CuVersionInfo cuVersionInfo = cuVersionDao.queryCuVersionInfo(map);
            if (null != cuVersionInfo)
            {
                resp.setCompatible(cuVersionInfo.getCompatible());
                resp.setCuVersion(cuVersionInfo.getVersionId());
                resp.setCuVersionMd5(cuVersionInfo.getVersionMd5());
                resp.setCuVersionAddress(cuVersionInfo.getVersionUrl());
                resp.setCuVersionDesc(cuVersionInfo.getVersionDesc());
                resp.setCuVersionName(cuVersionInfo.getVersionName());
            }
            resp.setSchoolId(req.getSchoolId());
            resp.setDeviceId(req.getDeviceId());
            resp.setErrorCode(ServiceContants.SUCCESS_CODE);
            resp.setErrorDes(ServiceContants.SUCCESS_DES);
        }
        catch (Exception e)
        {
            LOG.error("Exception", e);
            resp.setErrorCode(ServiceContants.FAIL_CODE);
            resp.setErrorDes(ServiceContants.FAIL_DES);
        }
        return resp;
    }
}
