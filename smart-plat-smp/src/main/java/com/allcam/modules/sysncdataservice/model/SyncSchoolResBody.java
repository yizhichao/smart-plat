package com.allcam.modules.sysncdataservice.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 同步学校的响应主体数据
 * 
 * @author  marui
 * @version  [版本号, Aug 28, 2015]
 */
public class SyncSchoolResBody
{
    @JsonProperty(value = "schoolList")
    private List<SyncSchoolInfo> schoolList;
    
    public List<SyncSchoolInfo> getSchoolList()
    {
        return schoolList;
    }
    
    public void setSchoolList(List<SyncSchoolInfo> schoolList)
    {
        this.schoolList = schoolList;
    }
}
