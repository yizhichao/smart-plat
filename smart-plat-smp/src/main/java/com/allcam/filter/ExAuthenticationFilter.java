package com.allcam.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import com.raising.system.framework.enums.Enums.UserType;

/**
 * 普通用户需要登录的部分的认证Filter
 * 
 */
public class ExAuthenticationFilter extends FormAuthenticationFilter
{
    protected boolean checkUserType(Subject subject, UserType userType)
    {
        //		try {
        //			ManagerUser shiroUser = (ManagerUser) subject.getPrincipal();
        //			return shiroUser.getUserType() == userType;
        //		} catch (Exception e) {
        //			return false;
        //		}
        
        return true;
    }
}
