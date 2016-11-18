package com.allcam.modules.sysncdataservice.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 同步老师接口的响应主体对象
 * 
 * @author marui
 * @version [版本号, Aug 28, 2015]
 */
public class SyncStudentResBody
{
    @JsonProperty(value = "pageInfo")
    private SyncStudentResBodyPageInfo pageInfo;
    
    @JsonProperty(value = "studentList")
    private List<SyncStudentInfo> studentList;
    
    public SyncStudentResBodyPageInfo getPageInfo()
    {
        return pageInfo;
    }
    
    public void setPageInfo(SyncStudentResBodyPageInfo pageInfo)
    {
        this.pageInfo = pageInfo;
    }
    
    public List<SyncStudentInfo> getStudentList()
    {
        return studentList;
    }
    
    public void setStudentList(List<SyncStudentInfo> studentList)
    {
        this.studentList = studentList;
    }
}
