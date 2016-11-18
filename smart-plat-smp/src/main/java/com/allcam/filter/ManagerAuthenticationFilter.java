package com.allcam.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;

import com.raising.system.framework.enums.Enums.UserType;

/**
 * 管理人员的认证Filter
 * 
 */
public class ManagerAuthenticationFilter extends ExAuthenticationFilter
{
    
    public ManagerAuthenticationFilter()
    {
    }
    
    @Override
    protected boolean isAccessAllowed(ServletRequest request,
            ServletResponse response, Object mappedValue)
    {
        Subject subject = getSubject(request, response);
        return subject.isAuthenticated()
                && checkUserType(subject, UserType.MANAGER);
    }
    
}
