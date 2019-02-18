package com.yskj.util;


import java.math.BigInteger;
import java.security.MessageDigest;


/**
 * Created by wf on 2017/5/10.
 */
public class Md5 {
    public static final String KEY_MD5 = "MD5";


    public static  String  getResult(String inputStr)
    {
        System.out.println(inputStr);
        BigInteger bigInteger=null;
        try {
            MessageDigest md = MessageDigest.getInstance(KEY_MD5);
            byte[] inputData = inputStr.getBytes();
            md.update(inputData);
            bigInteger = new BigInteger(md.digest());
        } catch (Exception e) {e.printStackTrace();}
        System.out.println(bigInteger.toString(16));
        return bigInteger.toString(16);
    }

    public static void main(String args[])
    {
        try {
            String inputStr = "123456";
            getResult(inputStr);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }



    }

