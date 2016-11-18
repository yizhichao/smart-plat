package com.allcam.utils.excel;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.allcam.utils.DateUtil;
import com.allcam.utils.StringUtil;

/**
 * 利用开源组件POI3.0.2动态导出EXCEL文档 转载时请保留以下信息，注明出处！
 * 
 * @author leno
 * @version v1.0
 * @param <T> 应用泛型，代表任意一个符合javabean风格的类 注意这里为了简单起见，boolean型的属性xxx的get器方式为getXxx(),而不是isXxx() byte[]表jpg格式的图片数据
 */
public class ExportExcelUtil<T>
{
    
    public void exportExcel(Collection<T> dataset, OutputStream out, File saveFile)
    {
        if (saveFile.getName().indexOf(".xlsx") != -1)
        {
            exportExcel2007("POI导出EXCEL文档", null, dataset, out, "yyyy-MM-dd", null, null);
        }
        else
        {
            exportExcel2003("POI导出EXCEL文档", null, dataset, out, "yyyy-MM-dd", null, null);
        }
    }
    
    public void exportExcel(Map<String, Object> headerMap, Collection<T> dataset, OutputStream out, File saveFile,
        String[] precautions)
    {
        if (saveFile.getName().indexOf(".xlsx") != -1)
        {
            String sheetName = (String)headerMap.get("sheetName");
            
            if (StringUtils.isBlank(sheetName))
            {
                sheetName = "Sheet1";
            }
            
            exportExcel2007(sheetName, headerMap, dataset, out, "yyyy-MM-dd", null, null);
            
            if (null != precautions && precautions.length > 0)
            {
                excel2007AddPrecautions(precautions, saveFile);
            }
        }
        else
        {
            exportExcel2003("Sheet1", headerMap, dataset, out, "yyyy-MM-dd", null, null);
        }
    }
    
    public void exportExcel(Map<String, Object> headerMap, Collection<T> dataset, OutputStream out, String pattern,
        File saveFile)
    {
        if (saveFile.getName().indexOf(".xlsx") != -1)
        {
            exportExcel2007("POI导出EXCEL文档", headerMap, dataset, out, pattern, null, null);
        }
        else
        {
            exportExcel2003("POI导出EXCEL文档", headerMap, dataset, out, pattern, null, null);
        }
    }
    
    /**
     * 这是一个导出2003文件通用的方法，利用了JAVA的反射机制，可以将放置在JAVA集合中并且符号一定条件的数据以EXCEL 的形式输出到指定IO设备上
     * 
     * @param title 表格标题名
     * @param headers 表格属性列名数组
     * @param dataset 需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象。此方法支持的 javabean属性的数据类型有基本数据类型及String,Date,byte[](图片数据)
     * @param out 与输出设备关联的流对象，可以将EXCEL文档导出到本地文件或者网络中
     * @param pattern 如果有时间数据，设定输出格式。默认为"yyy-MM-dd"
     */
    @SuppressWarnings("unchecked")
    public void exportExcel2003(String title, Map<String, Object> headerMap, Collection<T> dataset, OutputStream out,
        String pattern, int[] lastCell, String[] lastCellValues)
    {
        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet(title);
        // 设置表格默认列宽度为30个字节
        sheet.setDefaultColumnWidth((short)30);
        // 生成一个样式
        HSSFCellStyle style = workbook.createCellStyle();
        // 设置这些样式
        style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 生成一个字体
        HSSFFont font = workbook.createFont();
        font.setColor(HSSFColor.VIOLET.index);
        font.setFontHeightInPoints((short)12);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 把字体应用到当前的样式
        style.setFont(font);
        // 生成并设置另一个样式
        HSSFCellStyle style2 = workbook.createCellStyle();
        style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
        style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        // 生成另一个字体
        HSSFFont font2 = workbook.createFont();
        font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        // 把字体应用到当前的样式
        style2.setFont(font2);
        
        // 声明一个画图的顶级管理器
        HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
        
        // 产生表格标题行
        HSSFRow row = sheet.createRow(0);
        
        String[] headers = (String[])headerMap.get("headerTitle");
        String[] headersComment = (String[])headerMap.get("headerComment");
        
        HSSFComment comment = null;
        
        for (short i = 0; i < headers.length; i++)
        {
            HSSFCell cell = row.createCell(i);
            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
            
            if (null != headersComment && StringUtils.isNotBlank(headersComment[i]))
            {
                // 定义注释的大小和位置,详见文档
                comment = patriarch.createComment(new HSSFClientAnchor(0, 0, 0, 0, (short)3, 3, (short)5, 6));
                // 设置注释内容
                comment.setString(new HSSFRichTextString(headersComment[i]));
                // 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
                comment.setAuthor("bdgw");
                cell.setCellComment(comment);
            }
        }
        
        // 遍历集合数据，产生数据行
        Iterator<T> it = dataset.iterator();
        int index = 0;
        while (it.hasNext())
        {
            ++index;
            row = sheet.createRow(index);
            T t = (T)it.next();
            // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
            Field[] fields = t.getClass().getDeclaredFields();
            for (short i = 0; i < fields.length; i++)
            {
                Field field = fields[i];
                String fieldName = field.getName();
                
                // 如果类反射的属性是static或final的话，则不处理
                if ((field.getModifiers() & Modifier.STATIC) == Modifier.STATIC
                    || (field.getModifiers() & Modifier.FINAL) == Modifier.FINAL)
                {
                    continue;
                }
                
                HSSFCell cell = row.createCell(i);
                cell.setCellStyle(style2);
                
                String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                try
                {
                    Class tCls = t.getClass();
                    Method getMethod = tCls.getMethod(getMethodName, new Class[] {});
                    Object value = getMethod.invoke(t, new Object[] {});
                    // 判断值的类型后进行强制类型转换
                    String textValue = null;
                    // if (value instanceof Integer)
                    // {
                    // int intValue = (Integer) value;
                    // cell.setCellValue(intValue);
                    // }
                    // else
                    if (value instanceof Float)
                    {
                        float fValue = (Float)value;
                        textValue = new HSSFRichTextString(String.valueOf(fValue)).getString();
                        cell.setCellValue(textValue);
                    }
                    else if (value instanceof Double)
                    {
                        double dValue = (Double)value;
                        textValue = new HSSFRichTextString(String.valueOf(dValue)).getString();
                        cell.setCellValue(textValue);
                    }
                    else if (value instanceof Long)
                    {
                        long longValue = (Long)value;
                        cell.setCellValue(longValue);
                    }
                    if (value instanceof Boolean)
                    {
                        boolean bValue = (Boolean)value;
                        textValue = "男";
                        if (!bValue)
                        {
                            textValue = "女";
                        }
                    }
                    else if (value instanceof Date)
                    {
                        Date date = (Date)value;
                        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                        textValue = sdf.format(date);
                    }
                    else if (value instanceof byte[])
                    {
                        // 有图片时，设置行高为60px;
                        row.setHeightInPoints(60);
                        // 设置图片所在列宽度为80px,注意这里单位的一个换算
                        sheet.setColumnWidth(i, (short)(35.7 * 80));
                        // sheet.autoSizeColumn(i);
                        byte[] bsValue = (byte[])value;
                        HSSFClientAnchor anchor =
                            new HSSFClientAnchor(0, 0, 1023, 255, (short)6, index, (short)6, index);
                        anchor.setAnchorType(2);
                        patriarch.createPicture(anchor, workbook.addPicture(bsValue, HSSFWorkbook.PICTURE_TYPE_JPEG));
                    }
                    else
                    {
                        // 其它数据类型都当作字符串简单处理
                        textValue = String.valueOf(value);
                    }
                    // 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
                    if (textValue != null)
                    {
                        Pattern p = Pattern.compile("^//d+(//.//d+)?$");
                        Matcher matcher = p.matcher(textValue);
                        if (matcher.matches())
                        {
                            // 是数字当作double处理
                            cell.setCellValue(Double.parseDouble(textValue));
                        }
                        else
                        {
                            HSSFRichTextString richString = new HSSFRichTextString(textValue);
                            HSSFFont font3 = workbook.createFont();
                            font3.setColor(HSSFColor.BLUE.index);
                            richString.applyFont(font3);
                            cell.setCellValue(richString);
                        }
                    }
                    cell.setCellValue("null".equals(textValue) ? "" : textValue);
                }
                catch (SecurityException e)
                {
                    e.printStackTrace();
                }
                catch (NoSuchMethodException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                catch (IllegalArgumentException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                catch (IllegalAccessException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                catch (InvocationTargetException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                finally
                {
                    // 清理资源
                }
            }
            
        }
        if (lastCell != null && lastCellValues != null)
        {
            row = sheet.createRow(index + 1);
            for (int i = 0; i < lastCell.length; i++)
            {
                HSSFCell cell = row.createCell(lastCell[i]);
                cell.setCellStyle(style2);
                cell.setCellValue(lastCellValues[i]);
            }
        }
        try
        {
            workbook.write(out);
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    /**
     * 增加一个标签页
     * 
     * @param precautions 注意事项说明
     * @param out 输出流
     * 
     */
    public void excel2007AddPrecautions(String[] precautions, File saveFile)
    {
        try
        {
            // 读取已经存在的Excel文件，并开始往里面追加内容
            FileInputStream fs = new FileInputStream(saveFile);
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new BufferedInputStream(fs));
            
            // 生成一个表格
            XSSFSheet sheet = xssfWorkbook.createSheet("注意事项");
            // 设置表格默认列宽度为100个字节
            sheet.setDefaultColumnWidth((short)100);
            // 将注意事项这个Sheet显示在前面
            xssfWorkbook.setSheetOrder("注意事项", 0);
            FileOutputStream out = new FileOutputStream(saveFile);
            for (short i = 0; i < precautions.length; i++)
            {
                XSSFRow row = sheet.createRow(i);
                XSSFCell cell = row.createCell(0);
                cell.setCellValue(precautions[i]);
            }
            
            out.flush();
            xssfWorkbook.write(out);
            out.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * 这是一个导出2007文件通用的方法，利用了JAVA的反射机制，可以将放置在JAVA集合中并且符号一定条件的数据以EXCEL 的形式输出到指定IO设备上
     * 
     * @param title 表格标题名
     * @param headers 表格属性列名数组
     * @param dataset 需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象。此方法支持的 javabean属性的数据类型有基本数据类型及String,Date,byte[](图片数据)
     * @param out 与输出设备关联的流对象，可以将EXCEL文档导出到本地文件或者网络中
     * @param pattern 如果有时间数据，设定输出格式。默认为"yyy-MM-dd"
     */
    @SuppressWarnings("unchecked")
    public void exportExcel2007(String title, Map<String, Object> headerMap, Collection<T> dataset, OutputStream out,
        String pattern, int[] lastCell, String[] lastCellValues)
    {
        // 声明一个工作薄
        XSSFWorkbook workbook = new XSSFWorkbook();
        // 生成一个表格
        XSSFSheet sheet = workbook.createSheet(title);
        // 设置表格默认列宽度为30个字节
        sheet.setDefaultColumnWidth((short)30);
        // 生成一个样式
        XSSFCellStyle style = workbook.createCellStyle();
        // 设置这些样式
        style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
        style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
        style.setBorderRight(XSSFCellStyle.BORDER_THIN);
        style.setBorderTop(XSSFCellStyle.BORDER_THIN);
        style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        // 生成一个字体
        XSSFFont font = workbook.createFont();
        font.setColor(HSSFColor.VIOLET.index);
        font.setFontHeightInPoints((short)12);
        font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
        // 把字体应用到当前的样式
        style.setFont(font);
        // 生成并设置另一个样式
        XSSFCellStyle style2 = workbook.createCellStyle();
        style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
        style2.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        style2.setBorderBottom(XSSFCellStyle.BORDER_THIN);
        style2.setBorderLeft(XSSFCellStyle.BORDER_THIN);
        style2.setBorderRight(XSSFCellStyle.BORDER_THIN);
        style2.setBorderTop(XSSFCellStyle.BORDER_THIN);
        style2.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        style2.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        // 生成另一个字体
        XSSFFont font2 = workbook.createFont();
        font2.setBoldweight(XSSFFont.BOLDWEIGHT_NORMAL);
        // 把字体应用到当前的样式
        style2.setFont(font2);
        
        // 声明一个画图的顶级管理器
        XSSFDrawing patriarch = sheet.createDrawingPatriarch();
        
        // 产生表格标题行
        XSSFRow row = sheet.createRow(0);
        
        String[] headers = (String[])headerMap.get("headerTitle");
        String[] headersComment = (String[])headerMap.get("headerComment");
        
        XSSFComment comment = null;
        
        for (short i = 0; i < headers.length; i++)
        {
            XSSFCell cell = row.createCell(i);
            style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            cell.setCellStyle(style);
            
            XSSFRichTextString text = new XSSFRichTextString(headers[i]);
            cell.setCellValue(text);
            
            if (null != headersComment && StringUtil.isNull(headersComment[i]))
            {
                // 定义注释的大小和位置,详见文档
                comment = patriarch.createCellComment(new XSSFClientAnchor(0, 0, 0, 0, (short)3, 3, (short)5, 6));
                // 设置注释内容
                comment.setString(new XSSFRichTextString(headersComment[i]));
                // 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
                comment.setAuthor("bdgw");
                cell.setCellComment(comment);
            }
        }
        
        // 遍历集合数据，产生数据行
        Iterator<T> it = dataset.iterator();
        int index = 0;
        while (it.hasNext())
        {
            ++index;
            row = sheet.createRow(index);
            T t = (T)it.next();
            // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
            Field[] fields = t.getClass().getDeclaredFields();
            
            int cellNum = 0;
            for (short i = 0; i < fields.length; i++)
            {
                Field field = fields[i];
                String fieldName = field.getName();
                // 如果类反射的属性是static或final的话，则不处理
                if ((field.getModifiers() & Modifier.STATIC) == Modifier.STATIC
                    || (field.getModifiers() & Modifier.FINAL) == Modifier.FINAL)
                {
                    continue;
                }
                
                if ("failMsg".equals(fieldName) && !"失败信息".equals(headers[headers.length - 1]))
                {
                    continue;
                }
                
                XSSFCell cell = row.createCell(cellNum);
                cell.setCellStyle(style2);
                
                String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                try
                {
                    Class tCls = t.getClass();
                    Method getMethod = tCls.getMethod(getMethodName, new Class[] {});
                    Object value = getMethod.invoke(t, new Object[] {});
                    // 判断值的类型后进行强制类型转换
                    String textValue = null;
                    // if (value instanceof Integer)
                    // {
                    // int intValue = (Integer) value;
                    // cell.setCellValue(intValue);
                    // }
                    // else
                    if (value instanceof Float)
                    {
                        float fValue = (Float)value;
                        textValue = new XSSFRichTextString(String.valueOf(fValue)).getString();
                        cell.setCellValue(textValue);
                    }
                    else if (value instanceof Double)
                    {
                        double dValue = (Double)value;
                        textValue = new XSSFRichTextString(String.valueOf(dValue)).getString();
                        cell.setCellValue(textValue);
                    }
                    else if (value instanceof Long)
                    {
                        long longValue = (Long)value;
                        cell.setCellValue(longValue);
                    }
                    if (value instanceof Boolean)
                    {
                        boolean bValue = (Boolean)value;
                        textValue = "男";
                        if (!bValue)
                        {
                            textValue = "女";
                        }
                    }
                    else if (value instanceof Date)
                    {
                        Date date = (Date)value;
                        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                        textValue = sdf.format(date);
                    }
                    else if (value instanceof byte[])
                    {
                        // 有图片时，设置行高为60px;
                        row.setHeightInPoints(60);
                        // 设置图片所在列宽度为80px,注意这里单位的一个换算
                        sheet.setColumnWidth(i, (short)(35.7 * 80));
                        // sheet.autoSizeColumn(i);
                        byte[] bsValue = (byte[])value;
                        XSSFClientAnchor anchor =
                            new XSSFClientAnchor(0, 0, 1023, 255, (short)6, index, (short)6, index);
                        anchor.setAnchorType(2);
                        patriarch.createPicture(anchor, workbook.addPicture(bsValue, XSSFWorkbook.PICTURE_TYPE_JPEG));
                    }
                    else
                    {
                        // 其它数据类型都当作字符串简单处理
                        textValue = String.valueOf(value);
                    }
                    // 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
                    if (textValue != null)
                    {
                        Pattern p = Pattern.compile("^//d+(//.//d+)?$");
                        Matcher matcher = p.matcher(textValue);
                        if (matcher.matches())
                        {
                            // 是数字当作double处理
                            cell.setCellValue(Double.parseDouble(textValue));
                        }
                        else
                        {
                            XSSFRichTextString richString = new XSSFRichTextString(textValue);
                            XSSFFont font3 = workbook.createFont();
                            font3.setColor(HSSFColor.BLUE.index);
                            richString.applyFont(font3);
                            cell.setCellValue(richString);
                        }
                    }
                    
                    XSSFDataFormat format = workbook.createDataFormat();
                    
                    style2.setDataFormat(format.getFormat("@"));
                    
                    if ("failMsg".equals(fieldName))
                    {
                        // 设置换行显示
                        style2.setWrapText(true);
                    }
                    
                    cell.setCellStyle(style2);
                    cell.setCellValue("null".equals(textValue) ? "" : textValue);
                    cell.setCellType(XSSFCell.CELL_TYPE_STRING);
                }
                catch (SecurityException e)
                {
                    e.printStackTrace();
                }
                catch (NoSuchMethodException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                catch (IllegalArgumentException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                catch (IllegalAccessException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                catch (InvocationTargetException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                finally
                {
                    // 清理资源
                    cellNum++;
                }
            }
            
        }
        if (lastCell != null && lastCellValues != null)
        {
            row = sheet.createRow(index + 1);
            for (int i = 0; i < lastCell.length; i++)
            {
                XSSFCell cell = row.createCell(lastCell[i]);
                cell.setCellStyle(style2);
                cell.setCellValue(lastCellValues[i]);
            }
        }
        try
        {
            workbook.write(out);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public void exportExcel2007AddSheet(Map<String, Object> headerMap, Collection<T> dataset, String pattern,
        int[] lastCell, String[] lastCellValues, File saveFile)
    {
        try
        {
            // 读取已经存在的Excel文件，并开始往里面追加内容
            FileInputStream fs = new FileInputStream(saveFile);
            XSSFWorkbook workbook = new XSSFWorkbook(new BufferedInputStream(fs));
            String title = (String)headerMap.get("sheetName");
            // 生成一个表格
            XSSFSheet sheet = workbook.createSheet(title);
            // 设置表格默认列宽度为30个字节
            sheet.setDefaultColumnWidth((short)30);
            
            // 将注意事项这个Sheet显示在前面
            workbook.setSheetOrder(title, 0);
            // 生成一个样式
            XSSFCellStyle style = workbook.createCellStyle();
            // 设置这些样式
            style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
            style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
            style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
            style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
            style.setBorderRight(XSSFCellStyle.BORDER_THIN);
            style.setBorderTop(XSSFCellStyle.BORDER_THIN);
            style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
            // 生成一个字体
            XSSFFont font = workbook.createFont();
            font.setColor(HSSFColor.VIOLET.index);
            font.setFontHeightInPoints((short)12);
            font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
            // 把字体应用到当前的样式
            style.setFont(font);
            // 生成并设置另一个样式
            XSSFCellStyle style2 = workbook.createCellStyle();
            style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
            style2.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
            style2.setBorderBottom(XSSFCellStyle.BORDER_THIN);
            style2.setBorderLeft(XSSFCellStyle.BORDER_THIN);
            style2.setBorderRight(XSSFCellStyle.BORDER_THIN);
            style2.setBorderTop(XSSFCellStyle.BORDER_THIN);
            style2.setAlignment(XSSFCellStyle.ALIGN_CENTER);
            style2.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
            // 生成另一个字体
            XSSFFont font2 = workbook.createFont();
            font2.setBoldweight(XSSFFont.BOLDWEIGHT_NORMAL);
            // 把字体应用到当前的样式
            style2.setFont(font2);
            
            // 声明一个画图的顶级管理器
            XSSFDrawing patriarch = sheet.createDrawingPatriarch();
            
            // 产生表格标题行
            XSSFRow row = sheet.createRow(0);
            
            String[] headers = (String[])headerMap.get("headerTitle");
            String[] headersComment = (String[])headerMap.get("headerComment");
            
            XSSFComment comment = null;
            
            for (short i = 0; i < headers.length; i++)
            {
                XSSFCell cell = row.createCell(i);
                style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
                cell.setCellStyle(style);
                
                XSSFRichTextString text = new XSSFRichTextString(headers[i]);
                cell.setCellValue(text);
                
                if (null != headersComment && StringUtil.isNull(headersComment[i]))
                {
                    // 定义注释的大小和位置,详见文档
                    comment = patriarch.createCellComment(new XSSFClientAnchor(0, 0, 0, 0, (short)3, 3, (short)5, 6));
                    // 设置注释内容
                    comment.setString(new XSSFRichTextString(headersComment[i]));
                    // 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
                    comment.setAuthor("bdgw");
                    cell.setCellComment(comment);
                }
            }
            
            // 遍历集合数据，产生数据行
            Iterator<T> it = dataset.iterator();
            int index = 0;
            while (it.hasNext())
            {
                ++index;
                row = sheet.createRow(index);
                T t = (T)it.next();
                // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
                Field[] fields = t.getClass().getDeclaredFields();
                
                int cellNum = 0;
                for (short i = 0; i < fields.length; i++)
                {
                    Field field = fields[i];
                    String fieldName = field.getName();
                    // 如果类反射的属性是static或final的话，则不处理
                    if ((field.getModifiers() & Modifier.STATIC) == Modifier.STATIC
                        || (field.getModifiers() & Modifier.FINAL) == Modifier.FINAL)
                    {
                        continue;
                    }
                    
                    if ("failMsg".equals(fieldName) && !"失败信息".equals(headers[headers.length - 1]))
                    {
                        continue;
                    }
                    
                    String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                    try
                    {
                        Class tCls = t.getClass();
                        Method getMethod = tCls.getMethod(getMethodName, new Class[] {});
                        Object value = getMethod.invoke(t, new Object[] {});
                        // 判断值的类型后进行强制类型转换
                        String textValue = null;
                        
                        XSSFCell cell = row.createCell(cellNum);
                        cell.setCellStyle(style2);
                        if ("attendCounts".equals(fieldName))
                        {
                            String[] textValues = String.valueOf(value).split(",");
                            for (String val : textValues)
                            {
                                String attendCount = val.substring(0, val.indexOf("_"));
                                String date = val.substring(val.indexOf("_") + 1);
                                try
                                {
                                    date =
                                        DateUtil.formatTime(DateUtil.timeStr2Date(date, DateUtil.DATE_8),
                                            DateUtil.DATE_10);
                                }
                                catch (Exception e)
                                {
                                    e.printStackTrace();
                                }
                                Iterator ite = sheet.getRow(0).cellIterator();
                                while (ite.hasNext())
                                {
                                    XSSFDataFormat format = workbook.createDataFormat();
                                    
                                    style2.setDataFormat(format.getFormat("@"));
                                    
                                    if ("failMsg".equals(fieldName))
                                    {
                                        // 设置换行显示
                                        style2.setWrapText(true);
                                    }
                                    
                                    XSSFCell titleCell = (XSSFCell)ite.next();
                                    String titleVal = titleCell.getStringCellValue();
                                    if (titleVal.equals(date))
                                    {
                                        int idx = titleCell.getColumnIndex();
                                        XSSFCell xssfCell = row.createCell(idx);
                                        xssfCell.setCellStyle(style2);
                                        xssfCell.setCellValue(attendCount);
                                        xssfCell.setCellType(XSSFCell.CELL_TYPE_STRING);
                                        break;
                                    }
                                }
                            }
                        }
                        else
                        {
                            // if (value instanceof Integer)
                            // {
                            // int intValue = (Integer) value;
                            // cell.setCellValue(intValue);
                            // }
                            // else
                            if (value instanceof Float)
                            {
                                float fValue = (Float)value;
                                textValue = new XSSFRichTextString(String.valueOf(fValue)).getString();
                                cell.setCellValue(textValue);
                            }
                            else if (value instanceof Double)
                            {
                                double dValue = (Double)value;
                                textValue = new XSSFRichTextString(String.valueOf(dValue)).getString();
                                cell.setCellValue(textValue);
                            }
                            else if (value instanceof Long)
                            {
                                long longValue = (Long)value;
                                cell.setCellValue(longValue);
                            }
                            if (value instanceof Boolean)
                            {
                                boolean bValue = (Boolean)value;
                                textValue = "男";
                                if (!bValue)
                                {
                                    textValue = "女";
                                }
                            }
                            else if (value instanceof Date)
                            {
                                Date date = (Date)value;
                                SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                                textValue = sdf.format(date);
                            }
                            else if (value instanceof byte[])
                            {
                                // 有图片时，设置行高为60px;
                                row.setHeightInPoints(60);
                                // 设置图片所在列宽度为80px,注意这里单位的一个换算
                                sheet.setColumnWidth(i, (short)(35.7 * 80));
                                // sheet.autoSizeColumn(i);
                                byte[] bsValue = (byte[])value;
                                XSSFClientAnchor anchor =
                                    new XSSFClientAnchor(0, 0, 1023, 255, (short)6, index, (short)6, index);
                                anchor.setAnchorType(2);
                                patriarch.createPicture(anchor,
                                    workbook.addPicture(bsValue, XSSFWorkbook.PICTURE_TYPE_JPEG));
                            }
                            else
                            {
                                // 其它数据类型都当作字符串简单处理
                                textValue = String.valueOf(value);
                            }
                            
                            // 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
                            if (textValue != null)
                            {
                                Pattern p = Pattern.compile("^//d+(//.//d+)?$");
                                Matcher matcher = p.matcher(textValue);
                                if (matcher.matches())
                                {
                                    // 是数字当作double处理
                                    cell.setCellValue(Double.parseDouble(textValue));
                                }
                                else
                                {
                                    XSSFRichTextString richString = new XSSFRichTextString(textValue);
                                    XSSFFont font3 = workbook.createFont();
                                    font3.setColor(HSSFColor.BLUE.index);
                                    richString.applyFont(font3);
                                    cell.setCellValue(richString);
                                }
                            }
                            
                            XSSFDataFormat format = workbook.createDataFormat();
                            
                            style2.setDataFormat(format.getFormat("@"));
                            
                            if ("failMsg".equals(fieldName))
                            {
                                // 设置换行显示
                                style2.setWrapText(true);
                            }
                            
                            cell.setCellStyle(style2);
                            cell.setCellValue("null".equals(textValue) ? "" : textValue);
                            cell.setCellType(XSSFCell.CELL_TYPE_STRING);
                        }
                    }
                    catch (SecurityException e)
                    {
                        e.printStackTrace();
                    }
                    catch (NoSuchMethodException e)
                    {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    catch (IllegalArgumentException e)
                    {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    catch (IllegalAccessException e)
                    {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    catch (InvocationTargetException e)
                    {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    finally
                    {
                        // 清理资源
                        cellNum++;
                    }
                }
                
            }
            if (lastCell != null && lastCellValues != null)
            {
                row = sheet.createRow(index + 1);
                for (int i = 0; i < lastCell.length; i++)
                {
                    XSSFCell cell = row.createCell(lastCell[i]);
                    cell.setCellStyle(style2);
                    cell.setCellValue(lastCellValues[i]);
                }
            }
            FileOutputStream out = new FileOutputStream(saveFile);
            out.flush();
            workbook.write(out);
            out.close();
        }
        catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (SecurityException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    public static void main(String[] args)
    {
        // 测试学生
        // ExportExcel<Student> ex = new ExportExcel<Student>();
        // String[] headers = { "学号", "姓名", "年龄", "性别", "出生日期" };
        // List<Student> dataset = new ArrayList<Student>();
        // dataset.add(new Student(10000001, "张三", 20, true, new Date()));
        // dataset.add(new Student(20000002, "李四", 24, false, new Date()));
        // dataset.add(new Student(30000003, "王五", 22, true, new Date()));
        // // 测试图书
        // ExportExcel<Book> ex2 = new ExportExcel<Book>();
        // String[] headers2 = { "图书编号", "图书名称", "图书作者", "图书价格", "图书ISBN",
        // "图书出版社", "封面图片" };
        // List<Book> dataset2 = new ArrayList<Book>();
        // try {
        // BufferedInputStream bis = new BufferedInputStream(
        // new FileInputStream("book.jpg"));
        // byte[] buf = new byte[bis.available()];
        // while ((bis.read(buf)) != -1) {
        // //
        // }
        // dataset2.add(new Book(1, "jsp", "leno", 300.33f, "1234567",
        // "清华出版社", buf));
        // dataset2.add(new Book(2, "java编程思想", "brucl", 300.33f, "1234567",
        // "阳光出版社", buf));
        // dataset2.add(new Book(3, "DOM艺术", "lenotang", 300.33f, "1234567",
        // "清华出版社", buf));
        // dataset2.add(new Book(4, "c++经典", "leno", 400.33f, "1234567",
        // "清华出版社", buf));
        // dataset2.add(new Book(5, "c#入门", "leno", 300.33f, "1234567",
        // "汤春秀出版社", buf));
        //
        // OutputStream out = new FileOutputStream("E://a.xls");
        // OutputStream out2 = new FileOutputStream("E://b.xls");
        // ex.exportExcel(headers, dataset, out);
        // ex2.exportExcel(headers2, dataset2, out2);
        // out.close();
        // JOptionPane.showMessageDialog(null, "导出成功!");
        // System.out.println("excel导出成功！");
        // } catch (FileNotFoundException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // } catch (IOException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
    }
}
