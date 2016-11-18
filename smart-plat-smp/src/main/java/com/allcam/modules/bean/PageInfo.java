package com.allcam.modules.bean;

public class PageInfo
{
    private String pageNo;// String Y 分页查询-当前页
    
    private String pageSize = "100";// String Y 分页查询-页大小 默认 100
    
    private String totalCount;// String Y 分页查询-总条数
    
    private String totalPage;// String Y 分页查询-总页数 默认 100
    
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
    
    @Override
    public String toString()
    {
        return "PageInfo [pageNo=" + pageNo + ", pageSize=" + pageSize + ", totalCount=" + totalCount + ", totalPage="
            + totalPage + "]";
    }
}
