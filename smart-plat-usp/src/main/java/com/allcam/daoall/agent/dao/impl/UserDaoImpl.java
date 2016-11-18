package com.allcam.daoall.agent.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.allcam.daoall.BaseDao;
import com.allcam.daoall.agent.dao.UserDao;
import com.allcam.pojo.UserInfo;

/**
 * 用户相关的数据库实现类
 * 
 * @author marui
 * @version [版本号, Jul 4, 2015]
 */
@Repository
public class UserDaoImpl extends BaseDao<Object> implements UserDao
{
    public static final Log LOG = LogFactory.getLog(UserDaoImpl.class);
    
    /**
     * 增加用户信息
     * 
     * @param userInfo 用户信息
     * 
     * @return int 返回受影响的行数
     */
    public int addUserInfo(UserInfo userInfo)
    {
        int k = 0;
        try
        {
            k = getSqlSession().insert("UserInfo.addUserInfo", userInfo);
        }
        catch (Exception e)
        {
            LOG.error("UserDaoImpl.addUserInfo Error....", e);
        }
        return k;
    }
    
    /**
     * 增加用户扩展信息
     * 
     * @param userInfo 用户信息
     * 
     * @return int 返回受影响的行数
     */
    public int addUserExtendInfo(UserInfo userInfo)
    {
        int k = 0;
        try
        {
            k = getSqlSession().insert("UserInfo.addUserExtendInfo", userInfo);
        }
        catch (Exception e)
        {
            LOG.error("UserDaoImpl.addUserExtendInfo Error....", e);
        }
        return k;
    }
    
    /**
     * 根据条件查询用户信息
     * 
     * @param userInfo 查询条件
     * 
     * @return UserInfo 查询到的用户信息
     */
    public UserInfo getUserInfoByCer(UserInfo userInfo)
    {
        UserInfo returnUserInfo = null;
        
        try
        {
            returnUserInfo = getSqlSession().selectOne("UserInfo.getUserInfoByCer", userInfo);
        }
        catch (Exception e)
        {
            LOG.error("UserDaoImpl.getUserInfoByCer Error....", e);
        }
        return returnUserInfo;
    }
    
    /**
     * 删除用户信息
     * 
     * @param userInfo 删除条件
     * 
     * @return int 返回受影响的行数
     */
    public int deleteUserInfoByCer(UserInfo userInfo)
    {
        int k = 0;
        try
        {
            k = getSqlSession().delete("UserInfo.delUserInfo", userInfo);
        }
        catch (Exception e)
        {
            LOG.error("UserDaoImpl.deleteUserInfoByCer Error....", e);
        }
        return k;
    }
    
    /**
     * 删除用户扩展信息
     * 
     * @param userInfo 删除条件
     * 
     * @return int 返回受影响的行数
     */
    public int deleteUserExtendInfoByCer(UserInfo userInfo)
    {
        int k = 0;
        try
        {
            k = getSqlSession().delete("UserInfo.delUserExtendInfo", userInfo);
        }
        catch (Exception e)
        {
            LOG.error("UserDaoImpl.deleteUserExtendInfoByCer Error....", e);
        }
        return k;
    }
    
    /**
     * 更新用户信息
     * 
     * @param userInfo 更新条件
     * 
     * @return int 返回受影响的行数
     */
    public int updateUserInfoByCer(UserInfo userInfo)
    {
        int k = 0;
        try
        {
            k = getSqlSession().update("UserInfo.updateUserInfo", userInfo);
        }
        catch (Exception e)
        {
            LOG.error("UserDaoImpl.updateUserInfoByCer Error....", e);
        }
        return k;
    }
    
    /**
     * 更新用户扩展信息
     * 
     * @param userInfo 更新条件
     * 
     * @return int 返回受影响的行数
     */
    public int updateUserExtendInfoByCer(UserInfo userInfo)
    {
        int k = 0;
        try
        {
            k = getSqlSession().update("UserInfo.updateUserExtInfo", userInfo);
        }
        catch (Exception e)
        {
            LOG.error("UserDaoImpl.updateUserExtendInfoByCer Error....", e);
        }
        return k;
    }
    
    /**
     * 根据条件查询用户
     * 
     * @param map 查询条件
     * 
     * @return List<UserInfo> 查询到的结果
     */
    public List<UserInfo> queryUserInfoListByCer(Map<String, Object> map)
    {
        List<UserInfo> userInfoList = new ArrayList<UserInfo>();
        try
        {
            userInfoList = getSqlSession().selectList("UserInfo.queryUserInfoListByCer", map);
        }
        catch (Exception e)
        {
            LOG.error("UserDaoImpl.queryUserInfoListByCer Error...", e);
        }
        return userInfoList;
    }
    
    /**
     * 根据条件查询用户
     * 
     * @param map 查询条件
     * 
     * @return List<UserInfo> 查询到的结果
     */
    public List<UserInfo> queryUserInfoListByPage(Map<String, Object> map)
    {
        List<UserInfo> userInfoList = new ArrayList<UserInfo>();
        try
        {
            userInfoList = getSqlSession().selectList("UserInfo.queryUserInfoByPage", map);
        }
        catch (Exception e)
        {
            LOG.error("UserDaoImpl.queryUserInfoByPage Error...", e);
        }
        return userInfoList;
    }
    
    /**
     * 根据条件模糊搜索用户
     * 
     * @param map 查询条件
     * 
     * @return List<UserInfo> 查询到的结果
     */
    public List<UserInfo> searchUserInfo(Map<String, Object> map)
    {
        List<UserInfo> userInfoList = new ArrayList<UserInfo>();
        try
        {
            userInfoList = getSqlSession().selectList("UserInfo.searchUserInfoByPage", map);
        }
        catch (Exception e)
        {
            LOG.error("UserDaoImpl.queryUserInfoListByCer Error...", e);
        }
        return userInfoList;
    }
    
    @Override
    public List<UserInfo> queryDeviceSyncTeacherByPage(Map<String, Object> map)
    {
        List<UserInfo> userInfoList = new ArrayList<UserInfo>();
        try
        {
            userInfoList = getSqlSession().selectList("UserInfo.queryDeviceSyncTeacherByPage", map);
        }
        catch (Exception e)
        {
            LOG.error("UserDaoImpl.queryDeviceSyncTeacherByPage Error...", e);
        }
        return userInfoList;
    }
    
    @Override
    public List<UserInfo> getUserInfo(Map<String, Object> map)
    {
        return getSqlSession().selectList("UserInfo.queryUserInfo", map);
    }
    
    @Override
    public int getUserTotal(Map<String, Object> map)
    {
        return getSqlSession().selectOne("UserInfo.queryUserTotal", map);
    }
}
