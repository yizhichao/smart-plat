package com.allcam.utils;

import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpStatus;

import com.allcam.utils.exception.SystemException;

/**
 * HTTP请求工具类
 * 
 * @author marui
 * @version [版本号, 2014-8-15]
 */
public abstract class HttpRequestUtil
{
    private static final Log LOG = LogFactory.getLog(HttpRequestUtil.class);
    
    // /**
    // * 消息请求头json
    // */
    // private static final String APPLICATION_JSON = "application/json";
    //
    // /**
    // * 内容类型为text/json
    // */
    // private static final String CONTENT_TYPE_TEXT_JSON = "text/json";
    //
    // /**
    // * 内容编码格式UTF-8
    // */
    // private static final String CONTENT_CODE_UTF_8 = "UTF-8";
    //
    // /**
    // * 接口的请求URL地址
    // */
    // private static final String url = ConfigHelper.getValueByKey("interface.requestURL");
    
    /**
     * 通过Apache的方法发送HTTP+POST JSON请求
     * 
     * @param json json数据
     * @param requestUrl 接口的请求URL地址
     * @return String 接收到的响应数据
     */
    public static String httpPostWithJSON(String json, String requestUrl)
        throws Exception
    {
        
        String result = null;
        PostMethod method = null;
        try
        {
            HttpClient httpClient = new HttpClient();
            method = new PostMethod(requestUrl);
            RequestEntity requestEntity = new ByteArrayRequestEntity(json.getBytes("UTF-8"), "UTF-8");
            method.setRequestEntity(requestEntity);
            int statusCode = httpClient.executeMethod(method);
            result = method.getResponseBodyAsString();
            if (statusCode != HttpStatus.SC_OK)
            {
                throw new SystemException("1000", "请求失败!");
            }
        }
        catch (Exception e)
        {
            LOG.error("HttpRequestUtil.httpPostWithJSON(String json, String requestUrl).Exception", e);
        }
        finally
        {
            method.releaseConnection();
        }
        return result;
    }
    
    /**
     * 发送HTTP请求，并获得响应
     * 
     * @param urlString 请求的URL
     * 
     * @return String 响应的数据
     */
    public static String getConnectionResult(String urlString)
    {
        byte[] info = null;
        try
        {
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();
            HttpURLConnection httpConn = (HttpURLConnection)connection;
            InputStream is;
            if (httpConn.getResponseCode() >= 400)
            {
                is = httpConn.getErrorStream();
            }
            else
            {
                is = httpConn.getInputStream();
            }
            info = new byte[is.available()];
            is.read(info);
        }
        catch (Exception e)
        {
            LOG.error("HttpRequestUtil request " + urlString + " fail," + e);
        }
        return new String(info);
    }
    
    /**
     * 通过http+post的方式发送对象
     * 
     * @param file 需要发送的文件对象
     * @param url 需要发送的URL
     * 
     * @return int 发送后的URL地址
     */
    public static int postFile(File file, String uploadUrl)
        throws Exception
    {
        PostMethod filePost = new PostMethod(uploadUrl)
        {
            public String getRequestCharSet()
            {
                return "UTF-8";// 这个用来解决中文乱码
            }
        };
        
        int status = HttpStatus.SC_OK;
        
        try
        {
            Part[] parts = {new CustomFilePart(file.getName(), file)};
            filePost.setRequestEntity(new MultipartRequestEntity(parts, filePost.getParams()));
            
            org.apache.commons.httpclient.HttpClient client = new org.apache.commons.httpclient.HttpClient();
            
            client.getHttpConnectionManager().getParams().setConnectionTimeout(1500000);
            
            status = client.executeMethod(filePost);
        }
        finally
        {
            filePost.releaseConnection();
        }
        return status;
    }
}
