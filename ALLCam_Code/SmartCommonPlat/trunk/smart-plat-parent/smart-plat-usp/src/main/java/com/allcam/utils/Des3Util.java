package com.allcam.utils;

import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 
 * 字符串 DESede(3DES) 加密
 * 
 */
public class Des3Util
{
    // 加密算法的参数接口，IvParameterSpec是它的一个实现
    static AlgorithmParameterSpec iv = null;
    
    private static Key key = null;
    
    /**
     * DES加密的私钥，必须是8位长的字符串
     */
    public Des3Util(String snewkey)
        throws Exception
    {
        byte[] DESkey = snewkey.getBytes("UTF-8");
        
        byte[] DESIV = snewkey.substring(0, 8).getBytes("UTF-8");// 设置向量
        DESKeySpec keySpec = new DESKeySpec(DESkey);// 设置密钥参数
        iv = new IvParameterSpec(DESIV);// 设置向量
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");// 获得密钥工厂
        key = keyFactory.generateSecret(keySpec);// 得到密钥对象
        
    }
    
    /**
     * 加密
     * @param data 需要加密的字符串
     * 
     * @return String 加密后的字符串
     */
    public String encode(String data)
        throws Exception
    {
        Cipher enCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");// 得到加密对象Cipher
        enCipher.init(Cipher.ENCRYPT_MODE, key, iv);// 设置工作模式为加密模式，给出密钥和向量
        byte[] pasByte = enCipher.doFinal(data.getBytes("utf-8"));
        BASE64Encoder base64Encoder = new BASE64Encoder();
        return base64Encoder.encode(pasByte);
    }
    
    /**
     * 解密
     * @param data 需要解密的字符串
     * 
     * @return String 解密后的字符串
     */
    public String decode(String data)
        throws Exception
    {
        Cipher deCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        deCipher.init(Cipher.DECRYPT_MODE, key, iv);
        BASE64Decoder base64Decoder = new BASE64Decoder();
        byte[] pasByte = deCipher.doFinal(base64Decoder.decodeBuffer(data));
        return new String(pasByte, "UTF-8");
    }
    
    public static void main(String[] args)
    {
        try
        {
            Des3Util des3 = new Des3Util("AUC@2015");
            String userName = des3.encode("000000");
            System.out.println(userName);
            String userPassWord = des3.encode("123456");
            System.out.println(userPassWord);
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
