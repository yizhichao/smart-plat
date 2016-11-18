package com.allcam.utils;

import java.io.UnsupportedEncodingException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class DASASEEncryptUtil
{
    private static final String ALGORITHM = "AES";
    
    private static final String TRANSFORMATION = "AES/ECB/NoPadding";
    
    public static final String SECRETKEY = "brCMzN&rU3#81@Sm12345678";
    
    private static final String CHARACTERENCODING = "ISO-8859-1";
    
    private static final String ASCII_STYLE = "hex";
    
    private static final int KEYLEN = 16;
    
    public static String encrypt(String decryptedText)
    {
        return encryptAES(decryptedText, "brCMzN&rU3#81@Sm12345678");
    }
    
    public static String encryptData(String decryptedText, String key)
    {
        StringBuffer keyBuffer = new StringBuffer();
        if (null != key)
        {
            if (key.length() < 16)
            {
                for (int i = 0; i < 16 - key.length(); i++)
                {
                    keyBuffer.append("0");
                }
                keyBuffer.append(key);
            }
            else if (key.length() > 16)
            {
                String newKey = key.substring(key.length() - 16, key.length());
                keyBuffer.append(newKey);
            }
            else
            {
                keyBuffer.append(key);
            }
            return encryptAES(decryptedText, keyBuffer.toString());
        }
        return "";
    }
    
    public static String decryptData(String encryptedText, String key)
    {
        StringBuffer keyBuffer = new StringBuffer();
        if (null != key)
        {
            if (key.length() < 16)
            {
                for (int i = 0; i < 16 - key.length(); i++)
                {
                    keyBuffer.append("0");
                }
                keyBuffer.append(key);
            }
            else if (key.length() > 16)
            {
                String newKey = key.substring(key.length() - 16, key.length());
                keyBuffer.append(newKey);
            }
            else
            {
                keyBuffer.append(key);
            }
            return decryptAES(encryptedText, keyBuffer.toString());
        }
        return "";
    }
    
    public static String decrypt(String encryptedText)
    {
        return decryptAES(encryptedText, "brCMzN&rU3#81@Sm12345678");
    }
    
    private static String encryptAES(String decryptedText, String secretKey)
    {
        String encryptedText = "";
        try
        {
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            
            byte[] secretKeyBytes = getKeyBytes(secretKey);
            
            byte[] decryptedBytes = decryptedText.getBytes("ISO-8859-1");
            
            byte[] plainBytes = oneZeroPadding(decryptedBytes);
            
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKeyBytes, "AES");
            cipher.init(1, secretKeySpec);
            byte[] encryptedBytes = cipher.doFinal(plainBytes);
            if ("base64".equalsIgnoreCase("hex"))
            {
                BASE64Encoder bASE64Encoder = new BASE64Encoder();
                encryptedText = bASE64Encoder.encode(encryptedBytes);
            }
            else if ("hex".equalsIgnoreCase("hex"))
            {
                encryptedText = bytes2HexString(encryptedBytes);
            }
        }
        catch (Exception e)
        {
            System.out.println("encryptAES:" + e.toString());
        }
        return encryptedText;
    }
    
    private static byte[] oneZeroPadding(byte[] srcBytes)
    {
        int iFinalLen = (srcBytes.length / 16 + 1) * 16;
        
        byte[] dstText = new byte[iFinalLen];
        for (int i = 0; i < srcBytes.length; i++)
        {
            dstText[i] = srcBytes[i];
        }
        dstText[srcBytes.length] = -128;
        for (int i = srcBytes.length + 1; i < iFinalLen; i++)
        {
            dstText[i] = 0;
        }
        return dstText;
    }
    
    private static String decryptAES(String encryptedText, String secretKey)
    {
        String decryptedText = "";
        try
        {
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            
            byte[] secretKeyBytes = getKeyBytes(secretKey);
            byte[] encryptedBytes = new byte[0];
            if ("base64".equalsIgnoreCase("hex"))
            {
                BASE64Decoder bASE64Decoder = new BASE64Decoder();
                encryptedBytes = bASE64Decoder.decodeBuffer(encryptedText);
            }
            else if ("hex".equalsIgnoreCase("hex"))
            {
                encryptedBytes = hexString2Bytes(encryptedText);
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKeyBytes, "AES");
            cipher.init(2, secretKeySpec);
            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
            
            byte[] finalBytes = oneZeroRTrim(decryptedBytes);
            if (finalBytes == null)
            {
                decryptedText = "";
            }
            else
            {
                decryptedText = new String(finalBytes, "ISO-8859-1");
            }
        }
        catch (Exception e)
        {
            System.out.println("decryptAES:" + e.toString());
        }
        return decryptedText;
    }
    
    private static byte[] oneZeroRTrim(byte[] srcBytes)
    {
        int i = srcBytes.length - 1;
        byte[] dstBytes = null;
        while ((i >= 0) && (srcBytes[i] == 0))
        {
            i--;
        }
        int iRemainBytes = srcBytes[i] == -128 ? i : srcBytes.length;
        if (iRemainBytes > 0)
        {
            dstBytes = new byte[iRemainBytes];
            for (int j = 0; j < iRemainBytes; j++)
            {
                dstBytes[j] = srcBytes[j];
            }
        }
        return dstBytes;
    }
    
    private static byte[] getKeyBytes(String secretKey)
        throws UnsupportedEncodingException
    {
        byte[] secretKeyBytes = new byte[16];
        
        byte[] textBytes = null;
        if (secretKey != null)
        {
            textBytes = secretKey.getBytes("ISO-8859-1");
        }
        for (int ki = 0; ki < secretKeyBytes.length; ki += 1)
        {
            if ((textBytes != null) && (textBytes.length > ki))
            {
                secretKeyBytes[ki] = textBytes[ki];
            }
            else
            {
                secretKeyBytes[ki] = 0;
            }
        }
        return secretKeyBytes;
    }
    
    private static String bytes2HexString(byte[] bytes)
    {
        String hexString = null;
        
        StringBuffer buffer = new StringBuffer("");
        if (bytes != null)
        {
            hexString = "";
            for (int bi = 0; bi < bytes.length; bi += 1)
            {
                buffer = buffer.append((char)((bytes[bi] & 0xF) + 65));
                buffer = buffer.append((char)((bytes[bi] >> 4 & 0xF) + 65));
            }
            hexString = buffer.toString();
        }
        return hexString;
    }
    
    private static byte[] hexString2Bytes(String hexString)
    {
        byte[] dstBytes = null;
        if (hexString != null)
        {
            String srcHex = hexString;
            if (hexString.length() % 2 != 0)
            {
                srcHex = "0" + hexString;
            }
            else
            {
                srcHex = hexString;
            }
            srcHex = StringUtil.toUpperCase(srcHex);
            
            int iDstBytes = srcHex.length() / 2;
            
            dstBytes = new byte[iDstBytes];
            
            int j = 0;
            for (int i = 0; i < iDstBytes; i++)
            {
                char hexChar = srcHex.charAt(j);
                dstBytes[i] = ((byte)(hexChar - 'A'));
                j++;
                hexChar = srcHex.charAt(j);
                int tmp102_100 = i;
                byte[] tmp102_99 = dstBytes;
                tmp102_99[tmp102_100] = ((byte)(tmp102_99[tmp102_100] + (byte)((byte)(hexChar - 'A') << 4)));
                j++;
            }
        }
        return dstBytes;
    }
    
    public static void main(String[] args)
    {
        //OALLHJHJJCALFNDFNCHAPEPOEMJCDOAP
        String secretKey = "z77iul58xmxhbac6jk3o2qypuoapgy3w";
        String pass = DASASEEncryptUtil.encryptData("762888", secretKey);
        System.out.println(pass);
        String d = DASASEEncryptUtil.decryptData("JJFGMMMGNKJHLBNGPAILBGNPAKJNCIIK", "P32MXD27lzcSJOxhL6dg4175M3hH2jn2");
        System.out.println(d);
    }
}
