package com.allcam.utils.page;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.LogManager;

/**
 * 分页控制类
 *
 * @author  marui
 * @version  [版本号, 2015-10-15]
 */
public class PageControl<T> implements Serializable
{
    /**
     * 本类的序列代对象
     */
    private static final long serialVersionUID = -639155900102098498L;
    
    /**
     * 默认每页大小
     */
    public static final int DEFAULT_COUNT_PER_PAGE = 10;

    /**
     * 默认当前页
     */
    public static final int DEFAULT_CURRENT_PAGE = 1;

    /**
     * 每页大小
     */
    private int countPerPage = 10;

    /**
     * 总记录数
     */
    private int total;

    /**
     * 当前显示页数
     */
    private int currentPage = 1;

    /**
     * 每页要显示的集合
     */
    private List<T> items = new LinkedList<T>();

    /**
     * 总页数
     */
    private int totalPage;

    /**
     * 前一页数
     */
    private int previous;

    /**
     * 后一页数
     */
    private int next;

    /**
     * 记录查询开始数
     */
    private int begin;

    /**
     * 记录查询结束数
     */
    private int end;

    /**
     * 分页页号的索引
     */
    private int[] index;

    /**
     * 每页显示记录数数组
     */
    private String[] pageSizes = { "10", "20", "50", "100" };

    @Deprecated
    public PageControl()
    {
    }

    /**
     * 构造函数
     * @param total 总记录数
     * @param pageNo 当前页
     * @param pageSize 每页大小
     */
    public PageControl(int total, int pageNo, int pageSize)
    {
        this.countPerPage = (pageSize > 0 ? pageSize : total);
        this.currentPage = pageNo;
        setTotal(total);
    }

    public int getCountPerPage()
    {
        return this.countPerPage;
    }

    public int getTotal()
    {
        return this.total;
    }

    /**
     * 根据总记录数设置相关属性值
     * @param totalCount 总记录数
     *
     */
    private void setTotal(int totalCount)
    {
        this.total = totalCount;

        if (0 == this.total)
        {
            this.totalPage = 1;
        }
        else
        {
            this.totalPage = (1 + (this.total - 1) / this.countPerPage);
        }

        if (this.currentPage < 1)
        {
            this.currentPage = 1;
        }
        else if (this.currentPage > this.totalPage)
        {
            this.currentPage = this.totalPage;
        }

        if (1 == this.currentPage)
        {
            this.previous = 1;
        }
        else
        {
            this.previous = (this.currentPage - 1);
        }

        if (this.totalPage == this.currentPage)
        {
            this.next = this.currentPage;
        }
        else
        {
            this.next = (this.currentPage + 1);
        }

        this.begin = (this.countPerPage * (this.currentPage - 1));

        if (this.currentPage == this.totalPage)
        {
            this.end = this.total;
        }
        else
        {
            this.end = (this.countPerPage * this.currentPage);
        }

        if (0 == this.total)
        {
            this.index = new int[1];
            this.index[0] = 1;
        }
        else
        {
            this.index = new int[this.totalPage];
            for (int i = 0; i < this.totalPage; i++)
            {
                this.index[i] = (i + 1);
            }
        }
    }

    public int getCurrentPage()
    {
        return this.currentPage;
    }

    public List<T> getItems()
    {
        return this.items;
    }

    /**
     * 将查询到的数据保存到分页对象中
     * @param ts 查询到的数据
     *
     */
    public void setItems(List<T> ts)
    {
        this.items = new LinkedList<T>();
        if (null != ts)
        {
            int itemsSize = ts.size();
            if ((itemsSize <= this.countPerPage) || (this.begin == this.end))
            {
                this.items = ts;
            }
            else
            {
                this.items = ts.subList(getBegin(), getEnd());
            }
        }
    }

    /**
     * 将查询到的数据保存到分页对象中
     * @param ts 查询到的数据
     *
     */
    public void setItems(T[] ts)
    {
        this.items = new LinkedList<T>();
        if (null != ts)
        {
            int tsSize = ts.length;
            if ((tsSize <= this.countPerPage) || (this.begin == this.end))
            {
                for (int i = 0; i < tsSize; i++)
                {
                    this.items.add(ts[i]);
                }

            }
            else
            {
                for (int j = getBegin(); j < getEnd(); j++)
                {
                    this.items.add(ts[j]);
                }
            }
        }
    }

    public int getTotalPage()
    {
        return this.totalPage;
    }

    public int getPrevious()
    {
        return this.previous;
    }

    public int getNext()
    {
        return this.next;
    }

    public int getBegin()
    {
        return this.begin;
    }

    public int getEnd()
    {
        return this.end;
    }

    public String[] getPageSizes()
    {
        return this.pageSizes;
    }

    public int[] getIndex()
    {
        return this.index;
    }

    /**
     * toString方法
     * @return 返回本类有意义的对象
     */
    public String toString()
    {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("begin=").append(this.begin).append("|");
        sBuilder.append("pageSize=").append(this.countPerPage).append("|");
        sBuilder.append("pageNo=").append(this.currentPage).append("|");
        sBuilder.append("end=").append(this.end).append("|");
        sBuilder.append("next=").append(this.next).append("|");
        sBuilder.append("total=").append(this.total).append("|");
        sBuilder.append("totalPage=").append(this.totalPage).append("|");
        sBuilder.append("items=").append(this.items).append("|");

        return sBuilder.toString();
    }

    public void setCountPerPage(int countPerPage)
    {
        this.countPerPage = countPerPage;
    }

    public void setCurrentPage(int currentPage)
    {
        this.currentPage = currentPage;
    }

    /**
     * 将字符串的当前显示页面转换为数字类型
     * @param currentPageTmp 字符串的当前显示页数
     *
     */
    public void setCpStr(String currentPageTmp)
    {
        if ((null == currentPageTmp)
                || (!currentPageTmp.trim().matches("\\d+")))
        {
            this.currentPage = 1;
        }
        else
        {
            try
            {
                this.currentPage = Integer.parseInt(currentPageTmp.trim());
            }
            catch (NumberFormatException e)
            {
                LogManager.getLogger(PageControl.class)
                        .warn("The currentPageTmp can not be parsed to Integer",
                                e);
                this.currentPage = 1;
            }
        }
    }
}