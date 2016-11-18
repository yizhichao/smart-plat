package com.allcam.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * 系统配置帮助类，用于解析属性配置文件。
 * @author YiZhichao
 * @version [版本号, 2015-7-15]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class ConfigHelper
{
    /**
     * 日志记录器
     */
    private static Logger log = LogManager.getLogger(ConfigHelper.class);

    /**
     * 存储主属性资源文件
     */
    private static Properties defaultConfig = null;

    /**
     * 属性配置文件加载器实例
     */
    private static ConfigLoader loader = new ConfigLoader();

    /**
     * 缓存除主配置文件外的子模块配置文件内容。
     */
    private static Map<String, Properties> propMap = new HashMap<String, Properties>(
            5);

    /**
     * 主配置文件路径，支持绝对路径和相对路径。 可以通过Spring配置注入修改，默认为widbeans.properties。
     */
    private String defaultConfigFile = "systemConfig.properties";

    /**
     * TODO 根据数组中的键去取配置文件中的值，若取不到给定默认值
     * @param subPropKey String
     * @param params 键
     * @param defaultValue 默认值
     * @return 值
     */
    public static String getValueByKey(String subPropKey, String[] params,
            String defaultValue)
    {
        String value = defaultValue;
        try
        {
            for (int i = 0; i < params.length; i++)
            {
                if (containsKey(subPropKey, params[i]))
                {
                    value = getValueFromSubProp(subPropKey, params[i]);
                    break;
                }

            }
        }
        catch (Exception e)
        {
            log.info("Exception,defaultValue:" + defaultValue);
        }
        return value;
    }

    /**
     * 根据配置项关键字获取主配置文件中配置项的值。当key不存在时，默认返回空字符串。
     *
     * @param key 配置项关键字。
     * @return String 配置项的值。当key不存在时，默认返回空字符串。
     */
    public static String getValueByKey(String key)
    {
        return defaultConfig.getProperty(key, "");
    }

    /**
     * 根据配置项关键字获取主配置文件中配置项的值。当不存在关键字为key的配置项时，返回defaultValue。
     *
     * @param key 配置项关键字。
     * @param defaultValue 配置项的默认值。当key不存在时，默认返回该值。
     * @return String 配置项的值。
     */
    public static String getValueByKey(String key, String defaultValue)
    {
        return defaultConfig.getProperty(key, defaultValue);
    }

    /**
     * 根据配置项关键字获取子配置文件（在主配置文件中指定）中配置项的值。 当key不存在时，默认返回空字符串。
     *
     * @param subPropKey 主配置文件中指定的属性配置文件关键字。
     * @param key 配置项关键字。
     * @return 配置项的值。当key不存在时，默认返回空字符串。
     */
    public static String getValueFromSubProp(String subPropKey, String key)
    {
        return getValueFromSubProp(subPropKey, key, "");
    }

    /**
     * 根据配置项关键字获取子配置文件（在主配置文件中指定）中配置项的值。 当不存在关键字为key的配置项时，返回defaultValue。
     *
     * @param subPropKey 主配置文件中指定的属性配置文件关键字。
     * @param key 配置项关键字。
     * @param defaultValue 配置项的默认值。当key不存在时，默认返回该值。
     * @return 配置项的值。
     */
    public static String getValueFromSubProp(String subPropKey, String key,
            String defaultValue)
    {
        Properties prop = getProperties(subPropKey);

        if (null == prop)
        {
            return defaultValue;
        }

        String val = prop.getProperty(key, defaultValue);
        log.debug("config key= " + key + " value= " + val);
        return val;
    }

    /**
     * 获取子配置属性文件实例（在主配置文件中指定）。
     *
     * @param subPropKey
     *            主配置文件中指定的属性配置文件关键字。
     * @return 子配置属性实例。
     */
    public static Properties getSubProp(String subPropKey)
    {
        return getProperties(subPropKey);
    }

    /**
     * 同步处理文件读取
     * @param subPropKey key值
     * @return 返回属性对象
     */
    private static Properties getProperties(String subPropKey)
    {
        Properties prop = propMap.get(subPropKey);
        if (null == prop)
        {
            synchronized (ConfigHelper.class)
            {
                String specifiedCfgFile = defaultConfig.getProperty(subPropKey);

                try
                {
                    prop = loader.loadProperties(specifiedCfgFile);
                    propMap.put(subPropKey, prop);
                }
                catch (ConfigException e)
                {
                    return null;
                }
            }
        }

        return prop;
    }
    /**
     * 根据配置项关键字获取配置文件（指定路径）中配置项的值。当key不存在时，默认返回空字符串。
     *
     * @param filePath 指定配置文件的路径
     * @param key 配置项关键字。
     * @return 配置项的值。当key不存在时，默认返回空字符串。
     * @throws ConfigException 加载指定路径配置文件时导致的异常
     */
    public static String getValueFromSpecifiedProp(String filePath, String key)
            throws ConfigException
    {
        return getValueFromSpecifiedProp(filePath, key, "");
    }

    /**
     * 根据配置项关键字获取配置文件（指定路径）中配置项的值。当不存在关键字为key的配置项时，返回defaultValue。
     *
     * @param filePath 指定配置文件的路径
     * @param key 配置项关键字。
     * @param defaultValue 配置项的默认值。当key不存在时，默认返回该值。
     * @return 配置项的值。
     * @throws ConfigException 加载指定路径配置文件时导致的异常
     */
    public static String getValueFromSpecifiedProp(String filePath, String key,
            String defaultValue) throws ConfigException
    {
        return loader.loadProperties(filePath).getProperty(key, defaultValue);
    }

    /**
     * 获取指定路径的配置属性实例
     *
     * @param filePath 指定配置文件的路径
     * @return 配置属性实例
     * @throws ConfigException
     *             加载指定路径配置文件时导致的异常
     */
    public static Properties getSpecifiedProp(String filePath)
            throws ConfigException
    {
        return loader.loadProperties(filePath);
    }

    /**
     * 判断主配置文件是否存在配置项
     *
     * @return boolean true：没有任何配置项，false：存在至少一个配置项
     */
    public static boolean isEmpty()
    {
        return defaultConfig.isEmpty();
    }

    /**
     * 根据配置项关键字判断配置项是否存在。
     *
     * @param key 置项关键字。
     * @return boolean true：包含关键字为key的配置项，false：不包含关键字为key的配置项。
     */
    public static boolean containsKey(String key)
    {
        return defaultConfig.containsKey(key);
    }

    /**
     * 根据配置项关键字判断配置项是否存在。
     *
     * @param subPropKey String
     * @param key 置项关键字。
     * @return boolean true：包含关键字为key的配置项，false：不包含关键字为key的配置项。
     */
    public static boolean containsKey(String subPropKey, String key)
    {
        Properties prop = getSubProp(subPropKey);

        if (prop == null)
        {
            return false;
        }

        return prop.containsKey(key);
    }

    /**
     * 根据配置文件路径初始化加载配置文件信息。 作为初始化入口方法，在Spring中配置。
     * @exception ConfigException e
     */
    public void init() throws ConfigException
    {
        defaultConfig = loader.loadProperties(this.defaultConfigFile);
    }

    /**
     * 属性配置文件加载器
     */
    private static class ConfigLoader
    {
        /**
         * 资源文件解析路径根
         */
        private static final String DELIMITER_PATH_ROOT = "/";

        /**
         * 加载指定的properties文件
         *
         * @param filePath 待加载的属性配置文件路径
         * @return 加载后的属性实例
         * @throws ConfigException 加载指定路径配置文件时导致的异常
         */
        private Properties loadProperties(String filePath)
                throws ConfigException
        {
            // 先解析绝对路径
            File configFile = new File(filePath);

            // 不是绝对路径
            if (!configFile.exists())
            {
                if (!filePath.startsWith(DELIMITER_PATH_ROOT))
                {
                    filePath = DELIMITER_PATH_ROOT + filePath;
                }

                URL url = null;
                try
                {
                    url = new URL(this.getClass()
                            .getClassLoader()
                            .getResource("/")
                            + filePath);
                }
                catch (MalformedURLException e)
                {
                    log.error("MalformedURLException=" + e);
                }

                // 文件不文件抛出异常
                if (null == url)
                {

                    throw new ConfigException("The Config File[filePath="
                            + filePath + "] does not exist.");
                }

                // 创建文件实例
                try
                {
                    configFile = new File(url.toURI());
                }
                catch (URISyntaxException uriEx)
                {
                    throw new ConfigException("The Config File[filePath="
                            + filePath + "] does not exist.", uriEx);
                }
            }

            // 校验不能是目录，必须是文件
            if (!configFile.isFile())
            {
                throw new ConfigException("The Config File[filePath="
                        + filePath + "] is not a file.");
            }

            InputStream is = null;
            try
            {
                Properties prop = new Properties();
                is = new FileInputStream(configFile);
                prop.load(is);

                return prop;
            }
            catch (IOException e)
            {
                throw new ConfigException(
                        "Fail to load the config file[filePath=" + filePath
                                + "].", e);
            }
            finally
            {
                if (is != null)
                {
                    try
                    {
                        is.close();
                    }
                    catch (IOException e)
                    {
                        log.info("IOException=" + e);
                    }
                }
            }
        }
    }
}
