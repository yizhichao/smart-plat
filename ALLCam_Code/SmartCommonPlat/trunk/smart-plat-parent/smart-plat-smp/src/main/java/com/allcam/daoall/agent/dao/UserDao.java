package com.allcam.daoall.agent.dao;

import java.util.List;
import java.util.Map;

import com.allcam.pojo.UserInfo;

/**
 * 用户相关的数据库接口层
 * 
 * @author marui
 * @version [版本号, Jul 4, 2015]
 */
public interface UserDao
{
    /**
     * 增加用户信息
     * 
     * @param userInfo 用户信息
     * 
     * @return int 返回受影响的行数
     */
    int addUserInfo(UserInfo userInfo);
    
    /**
     * 增加用户扩展信息
     * 
     * @param userInfo 用户信息
     * 
     * @return int 返回受影响的行数
     */
    int addUserExtendInfo(UserInfo userInfo);
    
    /**
     * 根据条件查询用户信息
     * 
     * @param userInfo 查询条件
     * 
     * @return UserInfo 查询到的用户信息
     */
    UserInfo getUserInfoByCer(UserInfo userInfo);
    
    /**
     * 更新用户信息
     * 
     * @param userInfo 更新条件
     * 
     * @return int 返回受影响的行数
     */
    int updateUserInfoByCer(UserInfo userInfo);
    
    /**
     * 更新用户扩展信息
     * 
     * @param userInfo 更新条件
     * 
     * @return int 返回受影响的行数
     */
    int updateUserExtendInfoByCer(UserInfo userInfo);
    
    /**
     * 删除用户信息
     * 
     * @param userInfo 删除条件
     * 
     * @return int 返回受影响的行数
     */
    int deleteUserInfoByCer(UserInfo userInfo);
    
    /**
     * 删除用户扩展信息
     * 
     * @param userInfo 删除条件
     * 
     * @return int 返回受影响的行数
     */
    int deleteUserExtendInfoByCer(UserInfo userInfo);
    
    /**
     * 根据条件查询用户
     * 
     * @param map 查询条件
     * 
     * @return List<UserInfo> 查询到的结果
     */
    List<UserInfo> queryDeviceSyncTeacherByPage(Map<String, Object> map);
    
    /**
     * 根据条件查询用户
     * 
     * @param map 查询条件
     * 
     * @return List<UserInfo> 查询到的结果
     */
    List<UserInfo> queryUserInfoListByCer(Map<String, Object> map);
    
    /**
     * 根据条件查询用户
     * 
     * @param map 查询条件
     * 
     * @return List<UserInfo> 查询到的结果
     */
    public List<UserInfo> queryUserInfoListByPage(Map<String, Object> map);
    
    /**
     * 根据条件搜索查询用户
     * 
     * @param map 查询条件
     * 
     * @return List<UserInfo> 查询到的结果
     */
    List<UserInfo> searchUserInfo(Map<String, Object> map);
    
    List<UserInfo> getUserInfo(Map<String, Object> map);
    
    int getUserTotal(Map<String, Object> map);
}
