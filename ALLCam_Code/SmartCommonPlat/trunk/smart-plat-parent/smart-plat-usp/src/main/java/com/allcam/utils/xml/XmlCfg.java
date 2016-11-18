/**
 * <p>
 * Copyright (C), 1988-2012
 * </p>
 * <p>
 * FileName: XmlCfg.java
 * </p>
 * <p>
 * Author:InternetTeam3 Version :1.0 Date:2007
 * </p>
 * <p>
 * Description: 基于XML格式的配置文件读写类。和JDK1.4的Preferences类用法类似
 * </p>
 * <p>
 * Version: 1.0
 * </p>
 * <p>
 * Function List:
 * </p>
 */
package com.allcam.utils.xml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.locks.ReentrantLock;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.allcam.utils.Args;
import com.allcam.utils.Base64;
import com.allcam.utils.Cfg;
import com.allcam.utils.StringUtil;


/**
 * <p>
 * Title: XmlCfg
 * </p>
 * <p>
 * Description: 基于XML格式的配置文件读写类。和JDK1.4的Preferences类用法类似
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * 
 * @version 1.0
 */
public class XmlCfg implements Cfg
{
    /** XML头。 */
    // private static final String XML_HEAD = "<?xml version=\"1.0\"
    // encoding=\""
    // + System.getProperty("file.encoding") + "\"?>";
    static final String XML_HEAD = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

    /** 缩进前缀。 */
    static String indent = "  ";

    /** XML解析器工厂。 */
    private static DocumentBuilderFactory factory;

    /** XML解析器。 */
    private static DocumentBuilder builder;

    /** 该配置内存中数据是否与配置文件内容一致，不一致则为脏。 */
    private boolean isDirty;

    /** 代表该配置文件的文档类。 */
    private Document doc;

    /** 配置根节点。 */
    private Element root;

    /** 配置文件名。 */
    private String file;

    /** 增加锁，解决多线程并发读取Resource文件时出现的问题*/
    private final ReentrantLock mainLock = new ReentrantLock();
     
    
    /**
     * 构造方法。
     * 
     * @param file 保存配置信息的XML文件路径。
     * @param create 当配置文件不存在时，是否允许新建文件。
     * @throws IOException 配置文件访问或内容解析异常。
     */
    public XmlCfg(String file, boolean create) throws IOException
    {

        // 得到配置信息
        if (file == null)
        {
            throw new IllegalArgumentException("file name is null");
        }
        this.file = file;
        // URL url = new URL("file", "localhost", file); //创建文件对象
        try
        {
            load(); // 读取配置文件
        }
        catch (IOException ex)
        {
            if (!create)
            { // 文件不存在，且不允许新建
                throw new FileNotFoundException(file);
            }
            else
            { // 文件不存在，但允许新建
                loadXMLParser(); // 加载XML解析器
                doc = builder.newDocument(); // 创建空文档对象
                root = doc.createElement("config");
                doc.appendChild(root); // 增加根节点
                isDirty = true;
                flush(); // 保存到文件
                return;
            }
        }
    }

    /**
     * 输出缩进空格。
     * 
     * @param pw 输出目的地。
     * @param level 缩进深度。
     */
    static void writeIndent(PrintWriter pw, int level)
    {
        for (int i = 0; i < level; i++)
        {
            pw.print(indent);
        }
    }

    /**
     * 以XML格式递归输出一个节点。
     * 
     * @param node 输出起始节点。
     * @param pw 输出目的地。
     * @param 递归调用的深度标记，请输入0。
     */
    private static void writeNode(Node node, PrintWriter pw, int deep)
    {
        switch (node.getNodeType())
        {
            case Node.COMMENT_NODE: // 注释节点
                writeIndent(pw, deep);
                pw.print("<!--");
                pw.print(node.getNodeValue());
                pw.println("-->");
                return;
            case Node.TEXT_NODE: // 文本节点
                String value = node.getNodeValue().trim(); // 文本trim防止破坏缩进格式
                if (value.length() == 0)
                {
                    return;
                }
                writeText(pw, deep, value);//输出文本
                return;
            case Node.ELEMENT_NODE: // 标记节点
                if (!node.hasChildNodes())
                {
                    return;
                }
                for (int i = 0; i < deep; i++)
                {
                    pw.print(indent);
                }
                String nodeName = node.getNodeName();
                pw.print('<');
                pw.print(nodeName);

                // 输出属性
                NamedNodeMap nnm = node.getAttributes();
                if (nnm != null)
                {
                    for (int i = 0; i < nnm.getLength(); i++)
                    {
                        Node attr = nnm.item(i);
                        pw.print(' ');
                        pw.print(attr.getNodeName());
                        pw.print("=\"");
                        pw.print(attr.getNodeValue());
                        pw.print('\"');
                    }
                }

                writeSonNode(node, pw, deep, nodeName);
                
                return;
            case Node.DOCUMENT_NODE: // 文档节点
                pw.println(XML_HEAD);
                NodeList nl = node.getChildNodes();
                for (int i = 0; i < nl.getLength(); i++)
                {
                    writeNode(nl.item(i), pw, 0);
                }
                return;
            default:
        }
    }

    /** 
     * 写子节点
     * @param node 节点
     * @param pw 输出流
     * @param deep 缩进
     * @param nodeName 节点名
     * @see [类、类#方法、类#成员]
     */
    private static void writeSonNode(Node node, PrintWriter pw, int deep, String nodeName)
    {
        if (null == node || null == pw || StringUtil.isNull(nodeName))
        {
            return;
        }
        // 输出子节点
        if (node.hasChildNodes())
        {
            NodeList children = node.getChildNodes();
            if (children.getLength() == 0)
            {
                pw.print('<');
                pw.print(nodeName);
                pw.println("/>");
                return;
            }
            if (children.getLength() == 1)
            {
                Node n = children.item(0);
                if (n.getNodeType() == Node.TEXT_NODE)
                {
                    String v = n.getNodeValue();
                    if (v != null)
                    {
                        v = v.trim();
                    }
                    if (v == null || v.length() == 0)
                    {
                        pw.println(" />");
                        return;
                    }
                    else
                    {
                        pw.print('>');
                        v = v.replaceAll("&", "&amp;");
                        v = v.replaceAll("<", "&lt;");
                        v = v.replaceAll(">", "&gt;");
                        pw.print(v);
                        pw.print("</");
                        pw.print(nodeName);
                        pw.println('>');
                        return;
                    }
                }
            }
            pw.println(">");
            for (int i = 0; i < children.getLength(); i++)
            {
                writeNode(children.item(i), pw, deep + 1);
            }
            for (int i = 0; i < deep; i++)
            {
                pw.print(indent);
            }
            pw.print("</");
            pw.print(nodeName);
            pw.println(">");
        }
        else
        {
            pw.println("/>");
        }
    }

    /** 
     * 文本写入打印流中
     * @param pw 打印流
     * @param deep 缩进
     * @param value 文本值
     * @see [类、类#方法、类#成员]
     */
    private static void writeText(PrintWriter pw, int deep, String value)
    {
        writeIndent(pw, deep);
        for (int i = 0; i < value.length(); i++)
        {
            char c = value.charAt(i);
            switch (c)
            {
                case '<':
                    pw.print("&lt;");
                    break;
                case '>':
                    pw.print("&gt;");
                    break;
                case '&':
                    pw.print("&amp;");
                    break;
                case '\'':
                    pw.print("&apos;");
                    break;
                case '\"':
                    pw.print("&quot;");
                    break;
                default:
                    pw.print(c);
            }
        }
        pw.println();
    }

    /**
     * 根据key指定的关键字查找节点，在查找的过程中顺便将不存在的节点创建出来。
     * 
     * @param key 所查找节点的关键字。
     * @return 返回查到的节点，没查到则返回null。
     */
    private Node findNode(String key)
    {
        Node ancestor = root;
        StringTokenizer st = new StringTokenizer(key, "/");
        while (st.hasMoreTokens())
        {
            String nodeName = st.nextToken();
            NodeList nl = ancestor.getChildNodes();
            if (null != nl)
            {
                for (int i = 0; i < nl.getLength(); i++)
                {
                    Node n = nl.item(i);
                    if (null != n && nodeName.equals(n.getNodeName()))
                    {
                        ancestor = n;
                        if (!st.hasMoreTokens())
                        { // 到达key的最低一级了
                            return n;
                        }
                        break;
                    }
                }
            }
        }
        return null;
    }

    /**
     * 根据key指定的关键字创建节点，将会把key代表的整个路径上的节点都创建出来。
     * 
     * @param key 所查找节点的关键字。
     * @return 返回最底层节点，即使已经存在，没有创建新节点。
     */
    private Node createNode(String key)
    {
        Node ancestor = root;
        StringTokenizer st = new StringTokenizer(key, "/");
    token: 
        while (st.hasMoreTokens())
        {
            String nodeName = st.nextToken();
            NodeList nl = ancestor.getChildNodes();
            for (int i = 0; i < nl.getLength(); i++)
            {
                Node n = nl.item(i);
                if (nodeName.equals(n.getNodeName()))
                {
                    // 该级子节点存在则继续找下一级子节点
                    ancestor = n;
                    if (st.hasMoreTokens())
                    {
                        continue token;
                    }
                    else
                    {
                        return ancestor;
                    }
                }
            }

            // 该级子节点不存在
            while (true)
            {
                // 死循环
                Node n = doc.createElement(nodeName);
                ancestor.appendChild(n);
                ancestor = n;
                if (!st.hasMoreTokens())
                {
                    return ancestor;
                }
                nodeName = st.nextToken();
            }
        }
        // 不可能执行到这里
        return null;
    }

    /**
     * 根据key指定的关键字查找节点，在查找的过程中顺便将不存在的节点创建出来。
     * 
     * @param ancestor
     *            以该节点为祖先开始查找。
     * @param key
     *            所查找节点的关键字。
     * @return 返回查到的节点，没查到则返回null。
     */
    // private Node createNode(Node ancestor, String key)
    // {
    //
    // searchToken: //用来跳出两层循环用的标记
    // for (StringTokenizer st = new StringTokenizer(key, "/"); st
    // .hasMoreTokens(); )
    // {
    // String nodeName = st.nextToken();
    // NodeList nl = ancestor.getChildNodes();
    // for (int i = 0; i < nl.getLength(); i++)
    // {
    // if (nodeName.equals(nl.item(i).getNodeName()))
    // {
    // ancestor = nl.item(i);
    // continue searchToken;
    // }
    // }
    // return null;
    // }
    // return ancestor;
    // }
    /**
     * 获取节点值 (non-Javadoc)
     * 
     * @param key 节点关键字
     * @param def 默认值
     * @return 返回节点值
     * @see com.huawei.insa2.util.Cfg#get(java.lang.String, java.lang.String)
     */
    public String get(String key, String def)
    {
        if (key == null)
        {
            throw new NullPointerException("parameter key is null");
        }
        
        //增加锁，解决多线程并发读取Resrouce文件时的空指针异常
        final ReentrantLock localLock = this.mainLock;
        localLock.lock();
        try
        {
            Node node = findNode(key);
            
            if (node == null)
            { // 节点不存在返回空
                return def;
            }
            try
            {
                NodeList nl = node.getChildNodes();
                for (int i = 0; i < nl.getLength(); i++)
                {
                    if (nl.item(i).getNodeType() == Node.TEXT_NODE)
                    {
                        if (Charset.isSupported("GBK"))
                        {
                            byte[] bByte = nl.item(i).getNodeValue().trim().getBytes("iso-8859-1");
                            return new String(bByte, "GBK");
                        }
                        
                        return nl.item(i).getNodeValue().trim();
                        
                    }
                }
                node.appendChild(doc.createTextNode(def));
                return def;
            }
            catch (Exception e)
            {
                e.printStackTrace();
                
                return def;
            }
            
        }
        finally
        {
            localLock.unlock();
        }
    }

    /**
     * 查找某节点下的所有子节点的名
     * 
     * @param key 子节点名
     * @return 返回子节点
     * @see com.huawei.insa2.util.Cfg#getArgs(java.lang.String)
     */
    public Args getArgs(String key)
    {
        Map<String, Object> args = new HashMap<String, Object>();
        String[] children = childrenNames(key);
        if (children == null)
        {
            return null;
        }
        for (int i = 0; i < children.length; i++)
        {
            args.put(children[i], get(key + '/' + children[i], null));
        }
        return new Args(args);
    }

    /**
     * 节点写入新值
     * 
     * @param key 节点关键字
     * @param value 节点值
     * @see com.huawei.insa2.util.Cfg#put(java.lang.String, java.lang.String)
     */
    public void put(String key, String value)
    {
        if (key == null)
        {
            throw new NullPointerException("parameter key is null");
        }
        if (value == null)
        {
            throw new NullPointerException("parameter value is null");
        }
        value = value.trim();
        Node node = createNode(key);

        // node节点的第一个文本子节点(不包括trim后为空的)放置该节点的值
        NodeList nl = node.getChildNodes();
        for (int i = 0; i < nl.getLength(); i++)
        {
            Node child = nl.item(i);
            if (child.getNodeType() == Node.TEXT_NODE)
            { // 遇到第一个文本子节点
                String childValue = child.getNodeValue().trim();
                if (childValue.length() == 0)
                {
                    continue;
                }
                // put的值和原来一样，直接返回即可
                if (childValue.equals(value))
                {
                    return;
                }
                else
                {
                    child.setNodeValue(value);
                    isDirty = true;
                    return;
                }
            }
        }

        // 没有trim后还有内容的文本子节点
        if (nl.getLength() == 0)
        { // 节点为空
            node.appendChild(doc.createTextNode(value));
        }
        else
        { // 节点非空
            Node f = node.getFirstChild();
            if (f.getNodeType() == Node.TEXT_NODE)
            {
                f.setNodeValue(value);
            }
            else
            {
                node.insertBefore(doc.createTextNode(value), f);
            }
        }
        isDirty = true; // 修改后,脏标记设为真
    }

    /**
     * 获取节点值
     * 
     * @param key 节点关键字
     * @param def 默认值
     * @return 返回节点值
     * @see com.huawei.insa2.util.Cfg#getBoolean(java.lang.String, boolean)
     */
    public boolean getBoolean(String key, boolean def)
    {
        String str = String.valueOf(def); // 把布尔型def变成字符串类str
        boolean result;
        String resstr = get(key, str);
        Boolean resboolean = Boolean.valueOf(resstr);
        result = resboolean.booleanValue();
        return result;
    }

    /**
     * 获取节点值
     * 
     * @param key 节点关键字
     * @param def 默认值
     * @return 返回节点值
     * @see com.online.schedule.util.xml#getInt(java.lang.String, int)
     */
    public int getInt(String key, int def)
    {
        int result;
        String str = String.valueOf(def); // 把整型def变成字符串类str
        String resstr = get(key, str);
        try
        {
            result = Integer.parseInt(resstr); // 把字符串类resstr变成整型result
        }
        catch (NumberFormatException e)
        {
            return def;
        }
        return result;
    }

    /**
     * 获取节点值
     * 
     * @param key 节点关键字
     * @param def 默认值
     * @return 返回节点值
     * @see com.online.schedule.util.xml#getFloat(java.lang.String, float)
     */
    public float getFloat(String key, float def)
    {
        float result;
        String str = String.valueOf(def); // 把浮点型def变成字符串类str
        String resstr = get(key, str);
        try
        {
            result = Float.parseFloat(resstr); // 把字符串类resstr变成浮点型result
        }
        catch (NumberFormatException e)
        {
            return def;
        }
        return result;
    }

    /**
     * 获取节点值
     * 
     * @param key 节点关键字
     * @param def 默认值
     * @return 返回节点值
     * @see com.online.schedule.util.xml#getDouble(java.lang.String, double)
     */
    public double getDouble(String key, double def)
    {
        double result;
        String str = String.valueOf(def); // 把double型def变成字符串类str
        String resstr = get(key, str);
        try
        {
            result = Double.parseDouble(resstr); // 把字符串类resstr变成double型result
        }
        catch (NumberFormatException e)
        {
            return def;
        }
        return result;
    }

    /**
     * 获取节点值
     * 
     * @param key 节点关键字
     * @param def 默认值
     * @return 返回节点值
     * @see com.online.schedule.util.xml#getLong(java.lang.String, long)
     */
    public long getLong(String key, long def)
    {
        long result;
        String str = String.valueOf(def); // 把long型def变成字符串类str
        String resstr = get(key, str);
        try
        {
            result = Long.parseLong(resstr); // 把字符串类resstr变成long型result
        }
        catch (NumberFormatException e)
        {
            return def;
        }
        return result;
    }

    /**
     * 获取节点值
     * 
     * @param key 节点关键字
     * @param def 默认值
     * @return 返回节点值
     * @see com.online.schedule.util.xml#getByteArray(java.lang.String, byte[])
     */
    public byte[] getByteArray(String key, byte[] def)
    {
        byte[] result;
        String str = new String(def); // 把byte[]型def变成字符串类str
        String resstr = get(key, str);
        result = resstr.getBytes(); // 把字符串类resstr变成byte[]型result
        return result;
    }

    /**
     * 节点写入新值
     * 
     * @param key 节点关键字
     * @param value 值
     * @see com.online.schedule.util.xml#putBoolean(java.lang.String, boolean)
     */
    public void putBoolean(String key, boolean value)
    {
        String str = String.valueOf(value); // 将boolean型转换成String类型
        try
        {
            put(key, str);
        }
        catch (RuntimeException e)
        {
            throw e;
        }
    }

    /**
     * 节点写入新值
     * 
     * @param key 节点关键字
     * @param value 值
     * @see com.online.schedule.util.xml#putInt(java.lang.String, int)
     */
    public void putInt(String key, int value)
    {
        String str = String.valueOf(value); // 将int型转换成String类型
        try
        {
            put(key, str);
        }
        catch (RuntimeException e)
        {
            throw e;
        }
    }

    /**
     * 节点写入新值
     * 
     * @param key 节点关键字
     * @param value 值
     * @see com.online.schedule.util.xml#putFloat(java.lang.String, float)
     */
    public void putFloat(String key, float value)
    {
        String str = String.valueOf(value); // 将float型转换成String类型
        try
        {
            put(key, str);
        }
        catch (RuntimeException e)
        {
            throw e;
        }
    }

    /**
     * 节点写入新值
     * 
     * @param key 节点关键字
     * @param value 值
     * @see com.online.schedule.util.xml#putDouble(java.lang.String, double)
     */
    public void putDouble(String key, double value)
    {
        String str = String.valueOf(value); // 将double型转换成String类型
        try
        {
            put(key, str);
        }
        catch (RuntimeException e)
        {
            throw e;
        }
    }

    /**
     * 节点写入新值
     * 
     * @param key 节点关键字
     * @param value 值
     * @see com.online.schedule.util.xml#putLong(java.lang.String, long)
     */
    public void putLong(String key, long value)
    {
        String str = String.valueOf(value); // 将long型转换成String类型
        try
        {
            put(key, str);
        }
        catch (RuntimeException e)
        {
            throw e;
        }
    }

    /**
     * 节点写入新值
     * 
     * @param key 节点关键字
     * @param value 值
     * @see com.online.schedule.util.xml#putByteArray(java.lang.String, byte[])
     */
    public void putByteArray(String key, byte[] value)
    {
        put(key, Base64.encode(value));
    }

    /**
     * 删除某个节点。
     * 
     * @param key 该节点的名称。
     */
    public void removeNode(String key)
    {
        Node node = findNode(key); // 查找该节点
        if (node == null)
        { // 该节点不存在
            return;
        }
        Node parentnode = node.getParentNode(); // 取父节点
        if (parentnode != null)
        {
            parentnode.removeChild(node); // 删掉该节点
            isDirty = true; // 脏标志设为真
        }
    }

    /**
     * 清理某节点的所有子节点。
     * 
     * @param key 该节点的名称。
     */
    public void clear(String key)
    {
        Node node = findNode(key); // 查找该节点
        if (node == null) // 未找到就抛出异常
        {
            throw new RuntimeException("InvalidName");
        }
        Node lastnode = null;
        // 依次把最后一个子节点清除
        while (node.hasChildNodes())
        {
            lastnode = node.getLastChild();
            node.removeChild(lastnode);
        }
        // 若有子节点被清除,脏标志设为真
        if (lastnode != null)
        {
            isDirty = true;
        }
    }

    /**
     * 查找某节点下的所有子节点的名字。
     * 
     * @param key 被查节点的名字。
     * @return String[] 子节点名字的字符串数组，如果不存在key对应的子节点， 则返回长度为0的空数组。
     */
    public String[] childrenNames(String key)
    {
        Node node = findNode(key); // 查找key节点
        if (node == null)
        {
            return null;
        }
        NodeList nl = node.getChildNodes();
        LinkedList<String> list = new LinkedList<String>();
        for (int i = 0; i < nl.getLength(); i++)
        {
            Node child = nl.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE
                    && child.hasChildNodes())
            {
                list.add(child.getNodeName());
            }
        }
        String[] ret = new String[list.size()];
        for (int i = 0; i < ret.length; i++)
        {
            ret[i] = (String) list.get(i);
        }
        return ret;
    }

    /**
     * 节点是否存在 (non-Javadoc)
     * 
     * @param key 所查找节点的关键字
     * @see com.online.schedule.util.xml#nodeExist(java.lang.String)
     * @return true节点存在 false节点不存在
     */
    public boolean nodeExist(String key)
    {
        Node theNode = this.findNode(key);
        if (theNode == null || !theNode.hasChildNodes())
        {
            return false;
        }
        return true;
    }

    /**
     * 加载XML解析器驱动程序。
     */
    private void loadXMLParser() throws IOException
    {

        // 如果尚未加载过，则加载XML解析器驱动程序
        if (builder == null)
        {
            try
            {
                factory = DocumentBuilderFactory.newInstance();
                builder = factory.newDocumentBuilder();
            }
            catch (ParserConfigurationException ex)
            {
                throw new IOException("XML Parser load error:"
                        + ex.getLocalizedMessage());
            }
        }
    }

    /**
     * 重新读取XML文件。
     * 
     * @throws IOException 可能抛出I/O异常
     */
    public void load() throws IOException
    {

        loadXMLParser();

        // 解析配置文件
        try
        {
            this.doc = builder.parse(file);
        }
        catch (SAXException ex)
        {
            String message = ex.getMessage();
            Exception e = ex.getException();
            if (e != null)
            {
                message += "embedded exception:" + e;
            }
            throw new IOException("XML file parse error:" + message);
        }
        root = doc.getDocumentElement();
        if (!"config".equals(root.getNodeName()))
        {
            throw new IOException("Config file format error, "
                    + "root node must be <config>");
        }
    }

    /**
     * 刷新 (non-Javadoc)
     * 
     * @see com.online.schedule.util.xml#flush()
     * @throws IOException
     *             可能抛出I/O异常
     */
    public void flush() throws IOException
    {
        if (isDirty)
        { // 如果配置发生过修改
            OutputStreamWriter bos = new OutputStreamWriter(
                    new FileOutputStream(file), "UTF-8");

            PrintWriter pw = new PrintWriter(bos);
            writeNode(doc, pw, 0); // 输出整个文档
            pw.flush();
            pw.close();
            isDirty = false; // 脏标志设为假
        }
    }

    /**
     * 将字符串中的大于号、小于号等特殊字符做转义处理。
     * 
     * @param str
     *            转义前字符串。
     * @return 转义后的字符串。
     */
    // private String change(String str) throws IOException
    // {
    // if (str.indexOf('&') != -1 || str.indexOf('<') != -1
    // || str.indexOf('>') != -1)
    // {
    // ByteArrayOutputStream bos = new ByteArrayOutputStream();
    // ByteArrayInputStream bis = new ByteArrayInputStream(str.getBytes());
    // byte temp;
    // byte[] ba1 =
    // {'&', 'a', 'm', 'p', ';'};
    // byte[] ba2 =
    // {'&', 'l', 't', ';'};
    // byte[] ba3 =
    // {'&', 'g', 't', ';'};
    // while ((temp = (byte) bis.read()) != -1)
    // {
    // switch (temp)
    // {
    // case '&':
    // bos.write(ba1);
    // break;
    // case '<':
    // bos.write(ba2);
    // break;
    // case '>':
    // bos.write(ba3);
    // break;
    // default:
    // bos.write(temp);
    // }
    // }
    // return bos.toString();
    // }
    // return str; //不含有需转义的字符，则直接将原字符串返回
    // }
    // /**
    // * 测试入口。
    // */
    // public static void main(String[] args) throws Exception {
    // Cfg c = new XmlCfg("testcfg.xml", true);
    // c.put("a/b", "bvalue");
    // c.put("c", "");
    // c.put("a", "avalue");
    // c.flush();
    // System.out.println("Config file content:");
    // BufferedReader in = new BufferedReader(new FileReader("testcfg.xml"));
    // String line;
    // while ((line = in.readLine()) != null) {
    // System.out.println(line);
    // }
    // System.out.println("-------------"+Cfg.getDisplayMsg("ab","okbutton"));
    // System.out.println("-------------"+Cfg.getPromptMsg("zh","common/success"));
    // }
    /**
     * 获取参数
     * 
     * @param key key
     * @return 参数
     */
    public Map getArgsMap(String key)
    {
        // TODO Auto-generated method stub
        return null;
    }
}
