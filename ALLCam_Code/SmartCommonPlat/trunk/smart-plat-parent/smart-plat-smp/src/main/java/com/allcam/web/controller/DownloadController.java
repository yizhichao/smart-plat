package com.allcam.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.allcam.utils.SystemUtil;

/**
 * 下载文件的controller，该类实现下载文件时，会弹出浏览器的保存对话框
 * 
 * @author marui
 * @version [版本号, 2014-12-1]
 */
@Controller()
public class DownloadController extends BaseController
{
    // 日志
    public static final Log LOG = LogFactory.getLog(DownloadController.class);
    
    /**
     * 在前台页面调用该方法实现下载，需要传入二个参数： filePath：为针于对工程的路径 browseType：浏览器类型，直接使用mycommon.js中的getBrowseType方法即可
     * 
     * @param request
     * @param response
     */
    @RequestMapping(value = "/downloadController", method = {
            RequestMethod.POST, RequestMethod.GET })
    public void downloadController(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        LOG.debug("begin download");
        
        String filePath = request.getParameter("filePath");
        
        String systemReqUrl = SystemUtil.getServiceAddress(request);
        
        if (filePath.indexOf(systemReqUrl) != -1)
        {
            filePath = filePath.substring(filePath.indexOf(systemReqUrl)
                    + systemReqUrl.length());
        }
        
        if (!filePath.startsWith("/"))
        {
            filePath = "/" + filePath;
        }
        
        filePath = request.getSession()
                .getServletContext()
                .getRealPath(filePath);
        File fileload = new File(filePath);
        
        if (!fileload.exists())
        {
            try
            {
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html; charset=utf-8");
                PrintWriter out = response.getWriter();
                out.println("下载文件不存在。");
                out.flush();
                out.close();
            }
            catch (IOException iex)
            {
                LOG.error("download file!", iex);
                
                iex.printStackTrace();
            }
            return;
        }
        
        try
        {
            String fileName = fileload.getName();
            String browseType = request.getParameter("browseType");
            // IE内核浏览器
            if (null != browseType && "IE".equalsIgnoreCase(browseType))
            {
                fileName = URLEncoder.encode(fileName, "UTF-8");
                fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
                fileName = fileName.replace("+", "%20");// 处理IE文件名中有空格会变成+"的问题;
            }
            else if (null != browseType
                    && "Safari".equalsIgnoreCase(browseType))//解决safari浏览器文件名乱码
            {
                fileName = fileload.getName();
                fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
            }
            else
            {
                // 非IE
                fileName = URLDecoder.decode(fileName, "UTF-8");
                fileName = "=?UTF-8?B?"
                        + (new String(
                                Base64.encodeBase64(fileName.getBytes("UTF-8"))))
                        + "?="; // 火狐文件名空格被截断问题
            }
            // 客服端使用保存文件的对话框
            response.setHeader("Content-disposition", "attachment;filename="
                    + fileName);
            OutputStream outputStream = response.getOutputStream();
            // 通知客户文件的长度
            long fileLength = fileload.length();
            String length = String.valueOf(fileLength);
            response.setHeader("Content_length", length);
            // 读取文件，并发送给客服端下载
            FileInputStream inputStream = new FileInputStream(fileload);
            int n = 0;
            // 输出文件用的字节数组，每次向输出流发送600个字节
            byte b[] = new byte[600];
            while ((n = inputStream.read(b)) != -1)
            {
                outputStream.write(b, 0, n);
            }
        }
        catch (FileNotFoundException fnfe)
        {
            LOG.error("download file!", fnfe);
            
            fnfe.printStackTrace();
            try
            {
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html; charset=utf-8");
                PrintWriter out = response.getWriter();
                out.println("下载的文件不存在");
                out.flush();
                out.close();
            }
            catch (IOException ie)
            {
                LOG.error("download file!", ie);
                
                ie.printStackTrace();
            }
        }
        catch (IOException ie)
        {
            LOG.error("download file!", ie);
            
            ie.printStackTrace();
            
            try
            {
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html; charset=utf-8");
                PrintWriter out = response.getWriter();
                out.println("下载存在问题");
                out.flush();
                out.close();
            }
            catch (IOException iex)
            {
                LOG.error("download file!", iex);
                
                iex.printStackTrace();
            }
        }
        catch (Exception ie)
        {
            LOG.error("download file!", ie);
            
            ie.printStackTrace();
            
            try
            {
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html; charset=utf-8");
                PrintWriter out = response.getWriter();
                out.println("下载存在问题");
                out.flush();
                out.close();
            }
            catch (IOException iex)
            {
                LOG.error("download file!", iex);
                
                iex.printStackTrace();
            }
        }
    }
}
