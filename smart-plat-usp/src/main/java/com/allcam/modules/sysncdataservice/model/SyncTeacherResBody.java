package com.allcam.modules.sysncdataservice.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 同步老师接口的响应主体对象
 * 
 * @author  marui
 * @version  [版本号, Aug 28, 2015]
 */
public class SyncTeacherResBody
{
    @JsonProperty(value = "pageInfo")
    private SyncTeacherResBodyPageInfo pageInfo;
    
    @JsonProperty(value = "userList")
    private List<SyncTeacherInfo> userList;
    
    public SyncTeacherResBodyPageInfo getPageInfo()
    {
        return pageInfo;
    }
    
    public void setPageInfo(SyncTeacherResBodyPageInfo pageInfo)
    {
        this.pageInfo = pageInfo;
    }
    
    public List<SyncTeacherInfo> getUserList()
    {
        return userList;
    }
    
    public void setUserList(List<SyncTeacherInfo> userList)
    {
        this.userList = userList;
    }
}
