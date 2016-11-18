package com.allcam.modules.sysncdataservice.model;

/**
 * 同步老师响应对象中的分页信息
 * 
 * @author  marui
 * @version  [版本号, Aug 28, 2015]
 */
public class SyncStudentResBodyPageInfo
{
    /**
     * 分页查询-当前页
     */
    private String pageNo;
    
    /**
     * 分页查询-页大小 默认 100
     */
    private String pageSize;
    
    /**
     * 分页查询-总条数
     */
    private String totalCount;
    
    /**
     * 分页查询-总页数 默认 100
     */
    private String totalPage;

    public String getPageNo()
    {
        return pageNo;
    }

    public void setPageNo(String pageNo)
    {
        this.pageNo = pageNo;
    }

    public String getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(String pageSize)
    {
        this.pageSize = pageSize;
    }

    public String getTotalCount()
    {
        return totalCount;
    }

    public void setTotalCount(String totalCount)
    {
        this.totalCount = totalCount;
    }

    public String getTotalPage()
    {
        return totalPage;
    }

    public void setTotalPage(String totalPage)
    {
        this.totalPage = totalPage;
    }
}
