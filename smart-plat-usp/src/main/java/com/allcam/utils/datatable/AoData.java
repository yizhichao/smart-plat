package com.allcam.utils.datatable;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.allcam.utils.DateUtil;

public class AoData implements Serializable 
{
    private static final long serialVersionUID = 3000435890207787236L;

    private int sEcho;
    
    private int iDisplayStart;
    
    private int iDisplayLength;
    
    private String sColumns;
    
    private int iSortCol_;
    
    private String sSortDir_;
    
    private String sSearch;
    
    private String sSortCol_;
    
    private String sSchoolId;
    
    private String sDeviceId;
    
    private String sZoneId;
    
    private String sPlatId;
    
    private String sClassName;
    
    private String sMonth;
    
    private String sDate;
    
    private String sStudentCode;
    
    public AoData()
    {
        
    }
    
    public AoData(String aoData)
        throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
        InvocationTargetException
    {
        JSONArray arr = JSONArray.fromObject(aoData);
        for (int i = 0; i < arr.size(); i++)
        {
            JSONObject obj = (JSONObject)arr.get(i);
            Field fields[] = this.getClass().getDeclaredFields();
            for (Field field : fields)
            {
                String fieldName = field.getName();
                if (String.valueOf(obj.get("name")).contains(fieldName))
                {
                    String setMethodName = "set" + fieldName;
                    Method setMethod = this.getClass().getMethod(setMethodName, new Class[] {field.getType()});
                    setMethod.invoke(this, obj.get("value"));
                }
            }
        }
        this.setsSortCol_(this.getsColumns().split(",")[this.getiSortCol_()]);
    }
    
    public int getsEcho()
    {
        return sEcho;
    }
    
    public void setsEcho(int sEcho)
    {
        this.sEcho = sEcho;
    }
    
    public int getiDisplayStart()
    {
        return iDisplayStart;
    }
    
    public void setiDisplayStart(int iDisplayStart)
    {
        this.iDisplayStart = iDisplayStart;
    }
    
    public int getiDisplayLength()
    {
        return iDisplayLength;
    }
    
    public void setiDisplayLength(int iDisplayLength)
    {
        this.iDisplayLength = iDisplayLength;
    }
    
    public String getsColumns()
    {
        return sColumns;
    }
    
    public void setsColumns(String sColumns)
    {
        this.sColumns = sColumns;
    }
    
    public int getiSortCol_()
    {
        return iSortCol_;
    }
    
    public void setiSortCol_(int iSortCol_)
    {
        this.iSortCol_ = iSortCol_;
    }
    
    public String getsSortDir_()
    {
        return sSortDir_;
    }
    
    public void setsSortDir_(String sSortDir_)
    {
        this.sSortDir_ = sSortDir_;
    }
    
    public String getsSearch()
    {
        return sSearch;
    }
    
    public void setsSearch(String sSearch)
    {
        this.sSearch = sSearch;
    }
    
    public String getsSortCol_()
    {
        return sSortCol_;
    }
    
    public void setsSortCol_(String sSortCol_)
    {
        this.sSortCol_ = sSortCol_;
    }
    
    public String getsSchoolId()
    {
        return sSchoolId;
    }
    
    public void setsSchoolId(String sSchoolId)
    {
        this.sSchoolId = sSchoolId;
    }
    
    public String getsDeviceId()
    {
        return sDeviceId;
    }
    
    public void setsDeviceId(String sDeviceId)
    {
        this.sDeviceId = sDeviceId;
    }
    
    public String getsClassName()
    {
        return sClassName;
    }
    
    public void setsClassName(String sClassName)
    {
        this.sClassName = sClassName;
    }
    
    public String getsMonth()
    {
        return sMonth;
    }
    
    public void setsMonth(String sMonth)
    {
        try
        {
            this.sMonth = DateUtil.formatTime(
                    DateUtil.timeStr2Date(sMonth, DateUtil.DATE_7),
                    DateUtil.DATE_6);
        }
        catch (Exception e)
        {
            this.sMonth = sMonth;
        }
    }
    
    public String getsDate()
    {
        return sDate;
    }
    
    public void setsDate(String sDate)
    {
        try
        {
            this.sDate = DateUtil.formatTime(
                    DateUtil.timeStr2Date(sDate, DateUtil.DATE_10),
                    DateUtil.DATE_8);
        }
        catch (Exception e)
        {
            this.sDate = sDate;
        }
    }
    
    public String getsStudentCode()
    {
        return sStudentCode;
    }
    
    public void setsStudentCode(String sStudentCode)
    {
        this.sStudentCode = sStudentCode;
    }

    public String getsZoneId()
    {
        return sZoneId;
    }

    public void setsZoneId(String sZoneId)
    {
        this.sZoneId = sZoneId;
    }

    public String getsPlatId()
    {
        return sPlatId;
    }

    public void setsPlatId(String sPlatId)
    {
        this.sPlatId = sPlatId;
    }
}