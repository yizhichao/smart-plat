package com.allcam.modules.sysncdataservice.model;

import com.allcam.utils.SystemUtil;
import com.allcam.utils.Tools;

/**
 * 同步学校的请求主体数据
 * 
 * @author  marui
 * @version  [版本号, Aug 28, 2015]
 */
public class SyncSchoolReqBody
{
    /**
     * BDGW(考勤系统)
     */
    private String sysType = "1";
    
    /**
     * BDGW令牌
     */
    private String sysKey = SystemUtil.getBDGWKey();
    
    /**
     * 学校ID
     */
    private String schoolId;
    
    /**
     * 学校名称
     */
    private String schoolName;
    
    public String getSysType()
    {
        return sysType;
    }
    
    public void setSysType(String sysType)
    {
        this.sysType = sysType;
    }
    
    public String getSysKey()
    {
        return sysKey;
    }
    
    public void setSysKey(String sysKey)
    {
        this.sysKey = sysKey;
    }
    
    public String getSchoolId()
    {
        return schoolId;
    }
    
    public void setSchoolId(String schoolId)
    {
        this.schoolId = schoolId;
    }
    
    public String getSchoolName()
    {
        return schoolName;
    }
    
    public void setSchoolName(String schoolName)
    {
        this.schoolName = schoolName;
    }

    /**
     * 重写toString方法
     * @return 返回本类有意义的信息
     */
    public String toString()
    {
        return Tools.beanToString(this);
    }
}
