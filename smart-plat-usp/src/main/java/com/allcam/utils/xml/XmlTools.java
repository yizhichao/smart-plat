/**
 * <p>
 * FileName: XmlTools.java
 * </p>
 * <p>
 * Author:not attributable Version :1.0 Date:2014
 * </p>
 * <p>
 * Description: 
 * </p>
 * <p>
 * Version: 1.0
 * </p>
 * <p>
 * Function List:
 * </p>
 */
package com.allcam.utils.xml;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.io.IOUtils;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * xml文档解析工具类
 */
public class XmlTools
{
    private static final int DECIMAL_HEX = 16; // 十六进制

    private static final int POFIX_LENGTH = 2;

    /**
     * 构造方法
     */
    public XmlTools()
    {

    }

    /**
     * 生成根节点
     * 
     * @param xml
     *            xml文档资源
     * @return 返回该xml文档的根节点对象
     */
    public static Element createRootElement(URL xml)
    {
        DocumentBuilder builder;
        try
        {
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            return builder.parse(xml.openStream()).getDocumentElement();
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Can't parse the xml file!");
        }
    }

    /**
     * 生成根节点
     * 
     * @param f
     *            xml文档资源
     * @return 返回该xml文档的根节点对象
     */
    public static Element createRootElement(File f)
    {
        DocumentBuilder builder;
        try
        {
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            return builder.parse(f).getDocumentElement();
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Can't parse the xml file!");
        }
    }

    /**
     * 生成根节点
     * 
     * @param inputStream
     *            xml文档资源
     * @return 返回该xml文档的根节点对象
     */
    public static Element createRootElement(InputStream inputStream)
    {
        DocumentBuilder builder;
        try
        {
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            return builder.parse(inputStream).getDocumentElement();
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Can't parse the xml file!");
        }
    }

    /**
     * 生成根节点
     * 
     * @param inputStream
     *            xml文档资源
     * @return 返回该xml文档的根节点对象
     */
    public static Element createRootElement(String stringXml)
    {
        DocumentBuilder builder;
        try
        {
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            return builder.parse(IOUtils.toInputStream(stringXml, "UTF-8")).getDocumentElement();
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Can't parse the xml file!");
        }
    }

    /**
     * 获取子结点。只取ELEMENT类型的子结点。 取不到时抛出运行时异常
     * 
     * @param father
     *            父节点
     * @param childName
     *            子节点名
     * @return Node
     */
    public static Node getChildNode(Node father, String childName)
    {
        for (int i = 0; i < father.getChildNodes().getLength(); i++)
        {
            if (Node.ELEMENT_NODE != father.getChildNodes().item(i).getNodeType())
            {
                continue;
            }
            if (childName.equalsIgnoreCase(father.getChildNodes().item(i).getNodeName()))
            {
                return father.getChildNodes().item(i);
            }

        }
        throw new IllegalArgumentException("Can't fian " + father.getNodeName() + "'s child node '"
                + childName + "'!");
    }

    /**
     * 获取结点值
     * 
     * @param node
     *            Node
     * @return String
     */
    public static String getNodeValue(Node node)
    {
        if (Node.ELEMENT_NODE != node.getNodeType())
        {
            throw new IllegalArgumentException("Node type error!");
        }

        if (node.hasChildNodes() && 1 == node.getChildNodes().getLength())
        {
            return node.getChildNodes().item(0).getNodeValue().trim();
        }
        else
        {
            throw new IllegalArgumentException("Can't get node value!" + node.getNodeName());
        }
    }

    /**
     * 获取结点值
     * 
     * @param node
     *            Node
     * @return String
     */
    public static String getNodeValueCanEmpty(Node node)
    {
        if (Node.ELEMENT_NODE != node.getNodeType())
        {
            throw new IllegalArgumentException("Node type error!");
        }

        if (node.hasChildNodes() && 1 == node.getChildNodes().getLength())
        {
            return node.getChildNodes().item(0).getNodeValue().trim();
        }
        else
        {
            return null;
        }
    }

    /**
     * 获取节点的值
     * 
     * @param node
     *            节点
     * @return List
     */
    public static List getNodesValueCanEmpty(Node node)
    {
        if (Node.ELEMENT_NODE != node.getNodeType())
        {
            throw new IllegalArgumentException("Node type error!");
        }

        List<String> nodesValueList = new ArrayList<String>();

        if (node.hasChildNodes())
        {
            NodeList nodeList = node.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++)
            {
                nodesValueList.add(nodeList.item(i).getNodeValue().trim());
            }
        }
        else
        {
            throw new IllegalArgumentException("Can't get node value!" + node.getNodeName());
        }
        return nodesValueList;
    }

    /**
     * 获取节点的值并转换成int
     * 
     * @param node
     *            节点对象
     * @return 节点值
     */
    public static int getIntNodeValue(Node node)
    {
        String value = getNodeValue(node);
        if (null == value || 0 == value.length())
        {
            throw new IllegalArgumentException("Node '" + node.getNodeName() + "' is null!");
        }
        if (value.startsWith("0x") || value.startsWith("0X"))
        {
            return Integer.parseInt(value.substring(POFIX_LENGTH), DECIMAL_HEX);
        }
        return Integer.parseInt(value);
    }

    /**
     * 获取子结点列表。适用于一个父结点下有N个同名子结点的情况 只取ELEMENT类型的子结点。 取不到时抛出运行时异常
     * 
     * @param father
     *            父节点
     * @param childName
     *            子节点名字
     * @return List&lt;Node&gt; 子节点集合
     */
    public static List<Node> getChildNodes(Node father, String childName)
    {
        List<Node> list = new ArrayList<Node>();

        for (int i = 0; i < father.getChildNodes().getLength(); i++)
        {
            if (Node.ELEMENT_NODE != father.getChildNodes().item(i).getNodeType())
            {
                continue;
            }
            if (childName.equalsIgnoreCase(father.getChildNodes().item(i).getNodeName()))
            {
                list.add(father.getChildNodes().item(i));
            }

        }
        return list;
    }

    /**
     * 获取子结点列表
     * 
     * @param father
     *            父节点
     * @return List&lt;Node&gt; 子节点集合
     */
    public static List<Node> getChildNodes(Node father)
    {
        List<Node> list = new ArrayList<Node>();

        for (int i = 0; i < father.getChildNodes().getLength(); i++)
        {
            if (Node.ELEMENT_NODE != father.getChildNodes().item(i).getNodeType())
            {
                continue;
            }

            list.add(father.getChildNodes().item(i));

        }
        return list;
    }

    /**
     * 获取节点属性
     * 
     * @param node
     *            节点对象
     * @return 返回节点属性集合<br>
     *         key属性名字 value属性值
     */
    public static Map<String, String> getAttributes(Node node)
    {
        if (null == node.getAttributes())
        {
            throw new IllegalArgumentException("Node '" + node.getNodeName()
                    + "' not have any attribute!");
        }
        Map<String, String> attMap = new HashMap<String, String>();
        NamedNodeMap nodeMap = node.getAttributes();
        for (int i = 0; i < nodeMap.getLength(); i++)
        {
            Node tmpNode = nodeMap.item(i);
            // 如果没有此属性或属性值为空,则返回的属性集合中不包含此属性
            String value = tmpNode.getNodeValue();
            if (null == value || "".equals(value.trim()))
            {
                continue;
            }
            attMap.put(tmpNode.getNodeName(), value.trim());
        }
        return attMap;
    }

    /**
     * 获取某个XML结点的属性值。只返回布尔类型 在此属性不存在或验证失败时抛出异常。
     * 
     * @param node
     *            Node 结点
     * @param attName
     *            String 属性名称
     * @return 节点值(布尔类型)
     */
    public static boolean getBLAttribute(Node node, String attName)
    {
        return Boolean.valueOf(getAttribute(node, attName)).booleanValue();
    }

    /**
     * 获取某个XML结点的属性值。只返回String类型 在此属性不存在或验证失败时抛出异常。
     * 
     * @param node
     *            Node 结点
     * @param attName
     *            String 属性名称
     * @return 节点值
     */
    public static String getAttribute(Node node, String attName)
    {
        if (null == node.getAttributes())
        {
            throw new IllegalArgumentException("Node '" + node.getNodeName()
                    + "' not have any attribute!");
        }
        Node attNode = node.getAttributes().getNamedItem(attName);
        if (null == attNode)
        {
            // 如果没有找到，抛出异常
            throw new IllegalArgumentException("Can't find attribute '" + attName + "' in Node'"
                    + node.getNodeName() + "'!");
        }
        String value = attNode.getNodeValue();
        if (null == value)
        {
            return null;
        }
        else
        {
            value = value.trim();
        }
        return value;
    }

    /**
     * 获取某个XML结点的属性值。只返回String类型 在此属性不存在或验证失败时返回Null。
     * 
     * @param node
     *            Node 结点
     * @param attName
     *            String 属性名称
     * @return 返回节点值
     */
    public static String getAttributeNotThrowException(Node node, String attName)
    {
        if (null == node.getAttributes())
        {
            return null;
        }
        Node attNode = node.getAttributes().getNamedItem(attName);
        if (null == attNode)
        {
            return null;
        }
        String value = attNode.getNodeValue();
        if (null == value)
        {
            return null;
        }
        else
        {
            value = value.trim();
        }
        return value;
    }

    /**
     * 获取节点属性,并将值转换成int
     * 
     * @param node
     *            节点
     * @param attName
     *            属性名
     * @return 返回节点值
     */
    public static int getIntAttribute(Node node, String attName)
    {
        String value = getAttribute(node, attName);
        if (null == value || 0 == value.length())
        {
            throw new IllegalArgumentException("Attribute '" + attName + "' is null in Node '"
                    + node.getNodeName() + "'!");
        }
        if (value.startsWith("0x") || value.startsWith("0X"))
        {
            return Integer.parseInt(value.substring(POFIX_LENGTH), DECIMAL_HEX);
        }
        return Integer.parseInt(value);
    }

    public static void main(String[] args)
    {
        String input = "<?xml version='1.0' encoding='UTF-8' ?><MESSAGE Version='1.0'><SUBJECT_INFO_LIST><SUBJECT_INFO SubjectId='025340000004656' ParentId='025320000000503' GroupType='DEVICE_GROUP' SubjectName='南通'></SUBJECT_INFO></SUBJECT_INFO_LIST></MESSAGE>";
        try
        {
            Element element = createRootElement(IOUtils.toInputStream(input, "UTF-8"));
            System.out.println(element.getAttribute("Version"));
            Node node2=getChildNode(element, "SUBJECT_INFO_LIST");
            System.out.println(node2.getFirstChild().getNodeName());
            Node node = element.getElementsByTagName("SUBJECT_INFO_LIST").item(0);
            System.out.println(node.getFirstChild().getAttributes().getNamedItem("SubjectId")
                    .getNodeValue());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
