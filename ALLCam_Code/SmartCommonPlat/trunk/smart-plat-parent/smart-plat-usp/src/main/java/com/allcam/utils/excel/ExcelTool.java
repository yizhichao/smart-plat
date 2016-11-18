package com.allcam.utils.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTool
{
    public static XSSFWorkbook getWorkBookInner(File file)
    {
        XSSFWorkbook wb = null;
        try
        {
            InputStream is = null;
            try
            {
                System.out.println(file.getAbsolutePath());
                is = new FileInputStream(file);
                wb = new XSSFWorkbook(is);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            finally
            {
                is.close();
            }
            
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        return wb;
    }
    
    public static String getStringCellValue(XSSFCell cell)
    {
        if (cell == null)
        {
            //System.out.println("cell is null!");
            return "";
        }
        
        String defaultValue = null;
        
        int cellType = cell.getCellType();
        switch (cellType)
        {
            case 0:
                if (HSSFDateUtil.isCellDateFormatted(cell))
                {
                    defaultValue = DateAS.getDateString(cell.getDateCellValue());
                }
                else
                {
                    double d = cell.getNumericCellValue();
                    NumberFormat numberFormat = new DecimalFormat("#.######");
                    defaultValue = numberFormat.format(d);
                }
                break;
            case 1:
            case 3:
                defaultValue = cell.getStringCellValue().trim();
                break;
            case 2:
                defaultValue = cell.getCellFormula();
                break;
            case 4:
                defaultValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case 5:
                defaultValue = Byte.toString(cell.getErrorCellValue());
        }
        
        return defaultValue;
    }
    
    public static void copyFile(String src, String dest) throws IOException
    {
        int c;
        FileInputStream in = new FileInputStream(src);
        File file = new File(dest);
        if (!(file.exists()))
        {
            file.createNewFile();
        }
        FileOutputStream out = new FileOutputStream(file);
        
        byte[] buffer = new byte[1024];
        while ((c = in.read(buffer)) != -1)
        {
            for (int i = 0; i < c; ++i)
                out.write(buffer[i]);
        }
        in.close();
        out.close();
    }
}