package com.allcam.modules.school.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import com.allcam.daoall.agent.dao.SchoolDao;
import com.allcam.modules.school.inf.SchoolService;
import com.allcam.pojo.SchoolInfo;

/**
 * 学校相关业务处理层的接口
 * 
 * @author marui
 * @version [版本号, 2015-3-6]
 */
@Service
public class SchoolServiceImpl implements SchoolService
{
    @Resource
    private SchoolDao schoolDao;
    
    /**
     * 添加学校信息
     * 
     * @param schoolInfo 学校信息
     * 
     * @return int 受影响的行数
     */
    public int addSchoolInfo(SchoolInfo schoolInfo)
    {
        return schoolDao.addSchoolInfo(schoolInfo);
    }
    
    /**
     * 删除学校信息
     * 
     * @param schoolInfo 学校信息
     * 
     * @return int 受影响的行数
     */
    public int deleteSchoolInfo(SchoolInfo schoolInfo)
    {
        return schoolDao.deleteSchoolInfo(schoolInfo);
    }
    
    /**
     * 修改学校信息
     * 
     * @param schoolInfo 学校信息
     * 
     * @return int 受影响的行数
     */
    public int updateSchoolInfo(SchoolInfo schoolInfo)
    {
        return schoolDao.updateSchoolInfo(schoolInfo);
    }
    
    /**
     * 查询学校信息
     * 
     * @param map 查询条件
     * 
     * @return List<SchoolInfo> 查询到的学校信息
     */
    public List<SchoolInfo> querySchoolInfoByCer(Map<String, Object> map)
    {
        return schoolDao.querySchoolInfoByCer(map);
    }
    
    /**
     * 查询学校信息
     * 
     * @param map 查询条件
     * 
     * @return SchoolInfo 查询到的学校信息
     */
    public SchoolInfo queryOneSchoolInfoByCer(String schoolId)
    {
        return schoolDao.queryOneSchoolInfoByCer(schoolId);
    }
    
    /**
     * 根据学校信息查询学校的详细信息
     * 
     * @param schoolInfo 查询条件
     * 
     * @return SchoolInfo 查询到的学校信息
     */
    public SchoolInfo getSchoolInfoByCer(SchoolInfo schoolInfo)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("schoolInfo", schoolInfo);
        
        SchoolInfo resultSchoolInfo = null;
        
        List<SchoolInfo> schoolInfoList = querySchoolInfoByCer(map);
        
        if (CollectionUtils.isNotEmpty(schoolInfoList))
        {
            resultSchoolInfo = schoolInfoList.get(0);
        }
        
        return resultSchoolInfo;
    }
    
    public List<SchoolInfo> getSchoolInfo(Map<String, Object> map)
        throws Exception
    {
        List<SchoolInfo> schoolList = schoolDao.getSchoolInfo(map);
        return schoolList;
    }
    
    public int getSchoolTotal(Map<String, Object> map)
        throws Exception
    {
        int total = schoolDao.getSchoolTotal(map);
        return total;
    }
}
