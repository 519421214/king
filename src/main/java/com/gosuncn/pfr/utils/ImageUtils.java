package com.gosuncn.pfr.utils;


import org.springframework.util.Base64Utils;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * 该工具类只适用于上海旅店项目
 */
public class ImageUtils {

    //二进制转base64
    public static String binaryToBase64(byte[] data){
        String imageMd5 = "";
        try{
            String md5 = "";
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(data);
            md5 = new BigInteger(1, md.digest()).toString(16);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 30; i=i+2) {
                String str = md5.substring(i, i + 2);
                sb.append(convertHexToString(str));
            }
            String base64 = new String(Base64Utils.encode(sb.toString().getBytes("ISO-8859-1")));
            imageMd5 = base64.replace("+", "-").replace("/", "_");
        }catch(Exception e){
            e.printStackTrace();
        }
       return imageMd5;
    }
    //base64转base64
    public static String imageMd5(String data){
        byte[] dataBytes = Base64Utils.decodeFromString(data);
        String imageMd5 = "";
        try{
            String md5 = "";
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(dataBytes);
            md5 = new BigInteger(1, md.digest()).toString(16);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 32; i=i+2) {
                String str = md5.substring(i, i + 2);
                sb.append(convertHexToString(str));
            }
            String base64 = new String(Base64Utils.encode(sb.toString().getBytes("ISO-8859-1")));
            imageMd5 = base64.replace("+", "-").replace("/", "_");
        }catch(Exception e){
            e.printStackTrace();
        }
       return imageMd5;
    }
    //base64转base64
    public static String imageMd5(byte[] dataBytes){
        String imageMd5 = "";
        try{
            String md5 = "";
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(dataBytes);
            md5 = new BigInteger(1, md.digest()).toString(16);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 32; i=i+2) {
                String str = md5.substring(i, i + 2);
                sb.append(convertHexToString(str));
            }
            String base64 = new String(Base64Utils.encode(sb.toString().getBytes("ISO-8859-1")));
            imageMd5 = base64.replace("+", "-").replace("/", "_");
        }catch(Exception e){
            e.printStackTrace();
        }
       return imageMd5;
    }

    private static String convertHexToString(String hex) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hex.length()-1; i+=2) {
            String output = hex.substring(i, (i + 2));
            int decimal = Integer.parseInt(output, 16);
            sb.append((char)decimal);
        }
        return sb.toString();
    }
}

