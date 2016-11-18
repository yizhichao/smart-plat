package com.allcam.common;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.allcam.utils.DateUtil;
import com.allcam.utils.Env;
import com.allcam.utils.RandomUtil;

/**
 * OSS工具类
 * 
 * @author marui
 * @version [版本号, 2015-06-26]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class OSSUtil
{
    /** 定义日志对象 */
    public static final Log LOG = LogFactory.getLog(OSSUtil.class);
    
    public static final String BUCKET_NAME = Env.getWebCommon().get("common/OSS/BUCKET/NAME");
    
    public static final String ACCESS_ID = Env.getWebCommon().get("common/OSS/ACCESS_ID");
    
    public static final String ACCESS_KEY = Env.getWebCommon().get("common/OSS/ACCESS_KEY");
    
    public static final String OSS_ENDPOINT = Env.getWebCommon().get("common/OSS/OSS_ENDPOINT");
    
    public static final String OSS_ENDPOINT_PUBLIC = Env.getWebCommon().get("common/OSS/OSS_ENDPOINT_PUBLIC");
    
    public static final OSSClient client = new OSSClient(OSS_ENDPOINT, ACCESS_ID, ACCESS_KEY);
    
    public static final OSSClient client_public = new OSSClient(OSS_ENDPOINT_PUBLIC, ACCESS_ID, ACCESS_KEY);
    
    /**
     * 上传文件至OSS
     * 
     * @param key
     * @param inputStream
     * @return
     */
    public static String putObject(String key, InputStream inputStream)
    {
        
        // 入口日志记录
        if (LOG.isInfoEnabled())
        {
            LOG.info("Enter OSSUtil.putObject()");
        }
        PutObjectResult result = new PutObjectResult();
        try
        {
            result = client.putObject(BUCKET_NAME, key, inputStream, new ObjectMetadata());
            if (LOG.isDebugEnabled())
            {
                LOG.debug("Put Object Result:" + result.getETag());
            }
        }
        catch (OSSException e)
        {
            LOG.error("OSSUtil.putObject().OSSException", e);
        }
        catch (ClientException e)
        {
            LOG.error("OSSUtil.putObject().ClientException", e);
        }
        catch (Exception e)
        {
            LOG.error("OSSUtil.putObject().Exception", e);
        }
        finally
        {
            try
            {
                inputStream.close();
            }
            catch (IOException e)
            {
                LOG.error("OSSUtil.putObject():InputStream Close Fail", e);
            }
            // 记录出口日志
            if (LOG.isInfoEnabled())
            {
                LOG.info("Exit OSSUtil.putObject()");
            }
        }
        return result.getETag();
    }
    
    /**
     * 上传文件至OSS
     * 
     * @param key
     * @param inputStream
     * @return
     */
    public static boolean putObjectReturnResult(String key, InputStream inputStream)
    {
        boolean result = false;
        // 入口日志记录
        if (LOG.isInfoEnabled())
        {
            LOG.info("Enter OSSUtil.putObjectReturnResult()");
        }
        try
        {
            PutObjectResult putResult = client.putObject(BUCKET_NAME, key, inputStream, new ObjectMetadata());
            if (LOG.isDebugEnabled())
            {
                LOG.debug("Put Object Result:" + putResult.getETag());
            }
            result = true;
        }
        catch (OSSException e)
        {
            LOG.error("OSSUtil.putObjectReturnResult().OSSException", e);
        }
        catch (ClientException e)
        {
            LOG.error("OSSUtil.putObjectReturnResult().ClientException", e);
        }
        catch (Exception e)
        {
            LOG.error("OSSUtil.putObjectReturnResult().Exception", e);
        }
        finally
        {
            try
            {
                if(null != inputStream)
                {
                    inputStream.close();
                }
            }
            catch (IOException e)
            {
                LOG.error("OSSUtil.putObjectReturnResult():InputStream Close Fail", e);
            }
            // 记录出口日志
            if (LOG.isInfoEnabled())
            {
                LOG.info("Exit OSSUtil.putObjectReturnResult()");
            }
        }
        return result;
    }
    
    /**
     * 获取文件URL
     * 
     * @param key
     * @return
     */
    public static String generatePresignedUrl(String key)
    {
        
        // 入口日志记录
        if (LOG.isInfoEnabled())
        {
            LOG.info("Enter OSSUtil.generatePresignedUrl()");
        }
        URL url = null;
        try
        {
            
            // 设置URL过期时间为1小时
            Date expiration = new Date(new Date().getTime() + 3600 * 1000);
            url = client_public.generatePresignedUrl(BUCKET_NAME, key, expiration);
        }
        catch (OSSException e)
        {
            LOG.error("OSSUtil.generatePresignedUrl().OSSException", e);
        }
        catch (ClientException e)
        {
            LOG.error("OSSUtil.generatePresignedUrl().ClientException", e);
        }
        catch (Exception e)
        {
            LOG.error("OSSUtil.generatePresignedUrl().Exception", e);
        }
        finally
        {
            // 记录出口日志
            if (LOG.isInfoEnabled())
            {
                LOG.info("Exit OSSUtil.generatePresignedUrl()");
            }
        }
        return String.valueOf(url);
    }
    
    public static String buildOssFileKey()
    {
        return DateUtil.formatTime(new Date(), DateUtil.DATE_17).concat(RandomUtil.randomStringa(8));
    }
}
