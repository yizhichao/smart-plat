package com.allcam.pojo;

public class PageBean
{
    private int pageNo = 1;

    private int pageSize = 10;

    private int totalCount;

    private int totalPage;

    public int getPageNo()
    {
        return pageNo;
    }

    public void setPageNo(int pageNo)
    {
        this.pageNo = pageNo;
    }

    public int getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }

    public int getTotalCount()
    {
        return totalCount;
    }

    public void setTotalCount(int totalCount)
    {
        this.totalCount = totalCount;
    }

    public int getTotalPage()
    {
        int k = this.totalCount % this.pageSize;
        if (k == 0)
        {
            totalPage = this.totalCount / this.pageSize;
        }
        else
        {
            totalPage = this.totalCount / this.pageSize + 1;
        }
        return totalPage;
    }

    public void setTotalPage(int totalPage)
    {
        this.totalPage = totalPage;
    }

    @Override
    public String toString()
    {
        return "PageBean [pageNo=" + pageNo + ", pageSize=" + pageSize + ", totalCount="
                + totalCount + ", totalPage=" + totalPage + "]";
    }

}
