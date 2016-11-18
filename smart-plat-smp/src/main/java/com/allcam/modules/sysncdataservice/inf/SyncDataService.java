package com.allcam.modules.sysncdataservice.inf;

/**
 * 数据同步相关
 * 
 * @author YiZhichao
 * @version [版本号, 2015年10月15日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface SyncDataService
{
    
    boolean syncSchool(String sessionId, String schoolId, String schoolName)
        throws Exception;
    
    boolean syncTeacher(String sessionId, String schoolId)
        throws Exception;
    
    boolean syncStudent(String sessionId, String schoolId)
        throws Exception;
    
}
