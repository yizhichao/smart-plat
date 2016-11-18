package com.allcam.modules.user.inf;

import java.util.List;
import java.util.Map;

import com.allcam.modules.bean.ResponseCommon;
import com.allcam.modules.user.model.AuthLoginResponse;
import com.allcam.modules.user.model.GetUserInfoResponse;
import com.allcam.pojo.UserInfo;

/**
 * 用户相关业务处理层的接口
 * 
 * @author marui
 * @version [版本号, 2015-3-6]
 */
public interface UserService
{
    /**
     * 用户登录
     * 
     * @param userName 用户名
     * @param password 密码
     * 
     * @return AuthLoginResponse 返回登录接口响应的对象
     */
    AuthLoginResponse login(String userName, String password)
        throws Exception;
    
    /**
     * 获取用户信息
     * 
     * @param token 鉴权接口返回的令牌
     * 
     * @return GetUserInfoResponse 返回获取用户信息接口响应的对象
     */
    GetUserInfoResponse getUserInfo(String token)
        throws Exception;
    
    /**
     * 用户注销
     * 
     * @param token 鉴权接口返回的token
     * 
     * @return ResponseCommon 接口响应对象
     */
    ResponseCommon loginout(String token)
        throws Exception;
    
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
    List<UserInfo> queryUserInfoListByCer(Map<String, Object> map);
    
    /**
     * 根据条件搜索查询用户
     * 
     * @param map 查询条件
     * 
     * @return List<UserInfo> 查询到的结果
     */
    List<UserInfo> searchUserInfo(Map<String, Object> map);
    
    /**
     * 获取用户列表
     * 
     * @param map 查询条件
     * 
     * @return List<StudentInfo> 用户信息
     */
    List<UserInfo> getUserInfo(Map<String, Object> map)
        throws Exception;
    
    /**
     * 获取用户总数
     * 
     * @param map 查询条件
     * 
     * @return int 用户总数
     */
    int getUserTotal(Map<String, Object> map)
        throws Exception;
}
