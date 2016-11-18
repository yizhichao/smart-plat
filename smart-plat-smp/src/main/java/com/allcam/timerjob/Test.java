package com.allcam.timerjob;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.UUID;

import com.allcam.utils.StringUtil;

public class Test
{
    
    /**
     * <一句话功能简述> <功能详细描述>
     * 
     * @param args
     * @see [类、类#方法、类#成员]
     */
    public static void main(String[] args)
    {
        try
        {
            // TODO Auto-generated method stub
            // D:\taide\bluesky_channel\出入管理系统应用服务管理中心\Service\Home\BlueSky_Image\2015-08-04\17\0001_00
            // ~/BlueSky_Image/2015-08-04/17/0001_00/20150804174920_0004.jpg
            // String fileServer = "D:\\taide\\bluesky_channel\\出入管理系统应用服务管理中心\\Service\\Home\\";
            String fileServer = "E:\\Program Files (x86)\\bluesky_channel\\出入管理系统应用服务管理中心\\Service\\Home\\";
            String filePath = "~/BlueSky_Image/2015-08-04/17/0001_00/20150804174920_0004.jpg";
            if (!StringUtil.isNull(filePath))
            {
                filePath = fileServer + filePath.substring(2);// ~/BlueSky_Image/2015-08-04/17/0001_00/20150804174920_0004.jpg;
            }
            
            File file = new File(filePath);
            InputStream inputSteam = new FileInputStream(file);
            System.out.println(inputSteam);
            
            System.out.println(filePath);
            
            System.out.println(UUID.randomUUID().toString());
//            String msgBody= "{\"receiveId\":\"ddddgadsfasdfsadfasdf\"}";
            String msgBody= "{receiveId=1000}";
            System.out.println(msgBody);
            System.out.println(msgBody.substring(msgBody.indexOf("=")+1,msgBody.lastIndexOf("}")));
        }
        catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.exit(0);
    }
    
}
