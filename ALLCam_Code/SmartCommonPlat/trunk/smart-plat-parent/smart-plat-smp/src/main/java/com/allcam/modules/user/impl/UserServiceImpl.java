package com.allcam.modules.user.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.allcam.daoall.agent.dao.UserDao;
import com.allcam.modules.bean.MsgHead;
import com.allcam.modules.bean.ResponseCommon;
import com.allcam.modules.user.inf.UserService;
import com.allcam.modules.user.model.AuthLoginMsgBody;
import com.allcam.modules.user.model.AuthLoginOutMsgBody;
import com.allcam.modules.user.model.AuthLoginRequest;
import com.allcam.modules.user.model.AuthLoginResponse;
import com.allcam.modules.user.model.AuthLoginoutRequest;
import com.allcam.modules.user.model.GetUserInfoMsgBody;
import com.allcam.modules.user.model.GetUserInfoRequest;
import com.allcam.modules.user.model.GetUserInfoResponse;
import com.allcam.pojo.UserInfo;
import com.allcam.utils.ConfigHelper;
import com.allcam.utils.Des3Util;
import com.allcam.utils.HttpRequestUtil;
import com.allcam.utils.JSonUtils;
import com.allcam.utils.SystemConstant;

/**
 * 用户相关业务处理层的接口
 * 
 * @author marui
 * @version [版本号, 2015-3-6]
 */
@Service
public class UserServiceImpl implements UserService
{
    @Resource
    private UserDao userDao;
    
    /**
     * 用户登录
     * 
     * @param userName 用户名
     * @param password 密码
     * 
     * @return AuthLoginResponse 返回登录接口响应的对象
     */
    public AuthLoginResponse login(String userName, String password)
        throws Exception
    {
        AuthLoginResponse authLoginResponse = null;
        
        AuthLoginRequest authLoginRequest = new AuthLoginRequest();
        
        // 设置鉴权的消息头
        MsgHead msgHead = new MsgHead();
        msgHead.setMsgType("AUTH_LOGIN");
        msgHead.setDirection(SystemConstant.DIRECTION_REQUEST);
        authLoginRequest.setMsgHead(msgHead);
        
        // 设置鉴权的消息体
        AuthLoginMsgBody authLoginMsgBody = new AuthLoginMsgBody();
        
        authLoginMsgBody.setUserName(userName);
        
        Des3Util des3Util = new Des3Util(ConfigHelper.getValueByKey("des.key"));
        
        authLoginMsgBody.setPassWord(des3Util.encode(password));
        
        authLoginRequest.setMsgHead(msgHead);
        // 设置消息体
        authLoginRequest.setMsgBody(authLoginMsgBody);
        String url = ConfigHelper.getValueByKey("interface.requestURL");
        // 发送鉴权请求
        String responseBody = HttpRequestUtil.httpPostWithJSON(JSonUtils.toJSon(authLoginRequest), url);
        
        // 将字符串转换为对象
        authLoginResponse = JSonUtils.readValue(responseBody, AuthLoginResponse.class);
        
        return authLoginResponse;
    }
    
    /**
     * 获取用户信息
     * 
     * @param token 鉴权接口返回的令牌
     * 
     * @return GetUserInfoResponse 返回获取用户信息接口响应的对象
     */
    public GetUserInfoResponse getUserInfo(String token)
        throws Exception
    {
        GetUserInfoResponse getUserInfoResponse = null;
        
        // 设置的消息头
        MsgHead msgHead = new MsgHead();
        msgHead.setMsgType("GET_USER_INFO");
        msgHead.setDirection(SystemConstant.DIRECTION_REQUEST);
        
        GetUserInfoMsgBody getUserInfoMsgBody = new GetUserInfoMsgBody();
        getUserInfoMsgBody.setToken(token);
        
        GetUserInfoRequest getUserInfoRequest = new GetUserInfoRequest();
        getUserInfoRequest.setMsgHead(msgHead);
        
        // 设置消息体
        getUserInfoRequest.setGetUserInfoMsgBody(getUserInfoMsgBody);
        String url = ConfigHelper.getValueByKey("interface.requestURL");
        // 发送获取用户信息请求
        String responseBody = HttpRequestUtil.httpPostWithJSON(JSonUtils.toJSon(getUserInfoRequest), url);
        
        // 将字符串转换为对象
        getUserInfoResponse = JSonUtils.readValue(responseBody, GetUserInfoResponse.class);
        
        return getUserInfoResponse;
    }
    
    /**
     * 用户注销
     * 
     * @param token 鉴权接口返回的token
     * 
     * @return ResponseCommon 接口响应对象
     */
    public ResponseCommon loginout(String token)
        throws Exception
    {
        AuthLoginoutRequest authLoginoutRequest = new AuthLoginoutRequest();
        
        // 设置的消息头
        MsgHead msgHead = new MsgHead();
        msgHead.setMsgType("AUTH_LOGOUT");
        msgHead.setDirection(SystemConstant.DIRECTION_REQUEST);
        authLoginoutRequest.setMsgHead(msgHead);
        
        AuthLoginOutMsgBody msgBody = new AuthLoginOutMsgBody();
        msgBody.setToken(token);
        
        authLoginoutRequest.setMsgBody(msgBody);
        String url = ConfigHelper.getValueByKey("interface.requestURL");
        // 发送用户注销请求
        String responseBody = HttpRequestUtil.httpPostWithJSON(JSonUtils.toJSon(authLoginoutRequest), url);
        
        // 将字符串转换为对象
        ResponseCommon responseCommon = JSonUtils.readValue(responseBody, ResponseCommon.class);
        
        return responseCommon;
    }
    
    /**
     * 增加用户信息
     * 
     * @param userInfo 用户信息
     * 
     * @return int 返回受影响的行数
     */
    public int addUserInfo(UserInfo userInfo)
    {
        return userDao.addUserInfo(userInfo);
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
        if (StringUtils.isNotBlank(userInfo.getUserName()))
        {
            // userInfo.setUserNamePinYin(SpellHelper.getEname(userInfo.getUserName()));
        }
        
        return userDao.addUserExtendInfo(userInfo);
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
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userInfo", userInfo);
        // List<UserInfo> userInfoList = userDao.getUserInfoByCer(userInfo);
        
        UserInfo resultUserInfo = userDao.getUserInfoByCer(userInfo);
        
        // if (CollectionUtils.isNotEmpty(userInfoList))
        // {
        // resultUserInfo = userInfoList.get(0);
        // }
        
        return resultUserInfo;
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
        return userDao.updateUserInfoByCer(userInfo);
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
        if (StringUtils.isNotBlank(userInfo.getUserName()))
        {
            // userInfo.setUserNamePinYin(SpellHelper.getEname(userInfo.getUserName()));
        }
        return userDao.updateUserExtendInfoByCer(userInfo);
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
        return userDao.deleteUserInfoByCer(userInfo);
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
        return userDao.deleteUserExtendInfoByCer(userInfo);
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
        return userDao.queryUserInfoListByCer(map);
    }
    
    /**
     * 根据条件搜索查询用户
     * 
     * @param map 查询条件
     * 
     * @return List<UserInfo> 查询到的结果
     */
    public List<UserInfo> searchUserInfo(Map<String, Object> map)
    {
        return userDao.searchUserInfo(map);
    }
    
    public List<UserInfo> getUserInfo(Map<String, Object> map)
        throws Exception
    {
        List<UserInfo> userList = userDao.getUserInfo(map);
        return userList;
    }
    
    public int getUserTotal(Map<String, Object> map)
        throws Exception
    {
        int total = userDao.getUserTotal(map);
        return total;
    }
}
