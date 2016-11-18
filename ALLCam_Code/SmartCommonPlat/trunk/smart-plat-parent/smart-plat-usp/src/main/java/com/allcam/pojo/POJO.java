package com.allcam.pojo;

import com.allcam.utils.Tools;

/**
 * 基础实体bean
 * 
 * @author marui
 * 
 */
public abstract class POJO
{
//    private int pageNo=1;
//    
//    private int pageSize=10;
//    
//    private String condition;
//    
//    private String sortCol;
//    
//    private String sortType;
//    
//    public int getPageNo()
//    {
//        return pageNo;
//    }
//    
//    public void setPageNo(int pageNo)
//    {
//        this.pageNo = pageNo;
//    }
//    
//    public int getPageSize()
//    {
//        return pageSize;
//    }
//    
//    public void setPageSize(int pageSize)
//    {
//        this.pageSize = pageSize;
//    }
//    
//    public String getCondition()
//    {
//        return condition;
//    }
//
//    public void setCondition(String condition)
//    {
//        this.condition = condition;
//    }
//
//    public String getSortCol()
//    {
//        return sortCol;
//    }
//
//    public void setSortCol(String sortCol)
//    {
//        this.sortCol = sortCol;
//    }
//
//    public String getSortType()
//    {
//        return sortType;
//    }
//
//    public void setSortType(String sortType)
//    {
//        this.sortType = sortType;
//    }

    public String toString()
    {
        return Tools.beanToString(this);
    }
}
