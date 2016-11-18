package com.allcam.utils;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class RandomUtil
{
    /**
     * 产生随机字符串
     */
    private static Random randGen = null;
    
    private static char[] numbersAndLetters = null;
    
    public static int randomInt()
    {
        java.util.Random r = new java.util.Random(10);
        return r.nextInt();
    }
    
    // 调用此方法randomString(int),int是字符串的长度，即可产生指定长度的随机字符串。
    public static final String randomStringA(int length)
    {
        if (length < 1)
        {
            return null;
        }
        if (randGen == null)
        {
            randGen = new Random();
            numbersAndLetters =
                ("0123456789abcdefghijklmnopqrstuvwxyz" + "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
            // numbersAndLetters = ("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
        }
        char[] randBuffer = new char[length];
        for (int i = 0; i < randBuffer.length; i++)
        {
            randBuffer[i] = numbersAndLetters[randGen.nextInt(71)];
            // randBuffer[i] = numbersAndLetters[randGen.nextInt(35)];
        }
        return new String(randBuffer);
    }
    
    // 调用此方法randomString(int),int是字符串的长度，即可产生指定长度的随机字符串。
    public static final String randomStringa(int length)
    {
        if (length < 1)
        {
            return null;
        }
        if (randGen == null)
        {
            randGen = new Random();
            numbersAndLetters =
                ("0123456789abcdefghijklmnopqrstuvwxyz" + "0123456789abcdefghijklmnopqrstuvwxyz").toCharArray();
            // numbersAndLetters = ("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
        }
        char[] randBuffer = new char[length];
        for (int i = 0; i < randBuffer.length; i++)
        {
            randBuffer[i] = numbersAndLetters[randGen.nextInt(71)];
            // randBuffer[i] = numbersAndLetters[randGen.nextInt(35)];
        }
        return new String(randBuffer);
    }
    
    public static void main(String[] args)
    {
        // java.util.Random r = new java.util.Random(10);
        // for (int i = 0; i < 10; i++)
        // {
        // System.out.println(r.nextInt());
        // }
        
        String randDomStr = RandomUtil.randomStringa(34);
        System.out.println(randDomStr);
        
        System.out.println(UUID.randomUUID());
        
        // for (int i = 0; i < 100; i++)
        // {
        // System.out.println(java.util.concurrent.ThreadLocalRandom.current().nextInt(10));
        // }
        //
    }
}
