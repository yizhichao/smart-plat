package com.allcam.framework.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;

/**
 * 权限验证类
 * 
 * @author  marui
 * @version  [版本号, 2015-3-4]
 */
public class SecurityGradRealm extends AuthorizingRealm
{
    
    public SecurityGradRealm()
    {
        super();
        setAuthenticationTokenClass(MyExUsernamePasswordToken.class);
    }
    
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principalcollection)
    {
        SimpleAuthorizationInfo info = null;
        
        info = new SimpleAuthorizationInfo();
        info.addRole("manager");
        info.addStringPermission("*");
        return info;
    }
    
    /** * 更新用户授权信息缓存. */
    public void clearCachedAuthorizationInfo(String principal)
    {
        SimplePrincipalCollection principals = new SimplePrincipalCollection(
                principal, getName());
        clearCachedAuthorizationInfo(principals);
    }
    
    /**
     * 清除所有用户授权信息缓存.
     */
    public void clearAllCachedAuthorizationInfo()
    {
        Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
        if (cache != null)
        {
            for (Object key : cache.keys())
            {
                cache.remove(key);
            }
        }
    }
    
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authenticationtoken)
            throws AuthenticationException
    {
        //令牌——基于用户名和密码的令牌  
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationtoken;
        //令牌中可以取出用户名密码  
        String accountName = token.getUsername();
        
        /*此处无需比对，比对的逻辑Shiro会做，我们只需返回一个和令牌相关的正确的验证信息，*/
        return new SimpleAuthenticationInfo(accountName, token.getPassword(),
                getName());
    }
}
