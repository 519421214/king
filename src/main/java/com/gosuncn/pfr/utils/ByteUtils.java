package com.gosuncn.pfr.utils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class ByteUtils {

    public static void main(String[] args) {
        System.out.println(ByteUtils.genOpenDoorHexString(0xaabb, (byte) 0x01));

        System.out.println(Arrays.toString(intToBytes(0x01020304, 8)));//[0, 0, 0, 0, 1, 2, 3, 4]
        System.out.println(Arrays.toString(intToBytes(0x01020304, 8, ByteOrder.LITTLE_ENDIAN)));//[4, 3, 2, 1, 0, 0, 0, 0]
        System.out.println(Arrays.toString(longToBytes(0x01020304, 10, ByteOrder.BIG_ENDIAN)));//[0, 0, 0, 0, 0, 0, 1, 2, 3, 4]
        System.out.println(Arrays.toString(longToBytes(0x01020304, 10, ByteOrder.LITTLE_ENDIAN)));//[4, 3, 2, 1, 0, 0, 0, 0, 0, 0]
        System.out.println(align("12", 4, true, '0'));//1200
        System.out.println(align("12", 6, false, 'x'));//xxxx12

        int a = 0x01020304;
        System.out.println((a >> 24 & 0xFF));//输出1

        // 创建4个字节的字节缓冲区
        ByteBuffer bb = ByteBuffer.wrap(new byte[4]);
        bb.asIntBuffer().put(0x01020304);
        System.out.println(Arrays.toString(bb.array()));//[1, 2, 3, 4]
        bb.rewind();
        bb.order(ByteOrder.LITTLE_ENDIAN);
        bb.asIntBuffer().put(0x01020304);
        System.out.println(Arrays.toString(bb.array()));//[4, 3, 2, 1]


    }

    public static String genOpenDoorHexString(int userId, byte type) {
        return "000000" + byteToHexString(type) + bytesToHexString(intToBytes(userId));
    }

    /**
     * 将数字转成字节数组
     *
     * @param num 要转为字节的数字
     * @return
     */
    public static byte[] intToBytes(int num) {
        return intToBytes(num, Integer.BYTES, ByteOrder.BIG_ENDIAN);
    }

    /**
     * 将数字转成字节数组
     *
     * @param num   要转为字节的数字
     * @param bytes 要输出的字节数,必须大于等于4
     * @return
     */
    public static byte[] intToBytes(int num, int bytes) {
        return intToBytes(num, bytes, ByteOrder.BIG_ENDIAN);
    }

    /**
     * 将数字转成字节数组，比如输入（0x010203,4,ByteOrder.LITTLE_ENDIAN）,则得到[0x03,0x02,0x01,0x00]
     *
     * @param num   要转为字节的数字
     * @param bytes 要输出的字节数,必须大于等于4
     * @param order 要输出的字节的排序（ByteOrder.LITTLE_ENDIAN or ByteOrder.BIG_ENDIAN）
     * @return
     */
    public static byte[] intToBytes(int num, int bytes, ByteOrder order) {
        if (bytes < Integer.BYTES) {
            return null;
        }
        ByteBuffer bb = ByteBuffer.allocate(bytes);
        bb.order(order);
        bb.position(order == ByteOrder.LITTLE_ENDIAN ? 0 : bytes - Integer.BYTES);
        bb.asIntBuffer().put(num);
        //System.out.println(Arrays.toString(bb.array()));


        return bb.array();
    }

    /**
     * 将数字转成字节数组
     *
     * @param num 要转为字节的数字
     * @return
     */
    public static byte[] longToBytes(int num) {
        return longToBytes(num, Long.BYTES, ByteOrder.BIG_ENDIAN);
    }

    /**
     * 将数字转成字节数组
     *
     * @param num   要转为字节的数字
     * @param bytes 要输出的字节数,必须大于等于8
     * @return
     */
    public static byte[] longToBytes(int num, int bytes) {
        return longToBytes(num, bytes, ByteOrder.BIG_ENDIAN);
    }

    /**
     * 将数字转成字节数组，比如输入（0x010203,8,ByteOrder.LITTLE_ENDIAN）,则得到[0x03,0x02,0x01,0x00,0x00,0x00,0x00,0x00]
     *
     * @param num   要转为字节的数字
     * @param bytes 要输出的字节数,必须大于等于8
     * @param order 要输出的字节的排序（ByteOrder.LITTLE_ENDIAN or ByteOrder.BIG_ENDIAN）
     * @return
     */
    public static byte[] longToBytes(long num, int bytes, ByteOrder order) {
        if (bytes < Long.BYTES) {
            return null;
        }
        ByteBuffer bb = ByteBuffer.allocate(bytes);
        bb.order(order);
        bb.position(order == ByteOrder.LITTLE_ENDIAN ? 0 : bytes - Long.BYTES);
        bb.asLongBuffer().put(num);
        //System.out.println(Arrays.toString(bb.array()));

        return bb.array();
    }

    /* Convert byte[] to hex string.这里我们可以将byte转换成int，然后利用Integer.toHexString(int)来转换成16进制字符串。
     * @param src byte[] data
     * @return hex string
     */
    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    /**
     * 将一个字节转为16进制字符串
     *
     * @param src
     * @return
     */
    public static String byteToHexString(byte src) {
        int v = src & 0xFF;
        String hv = Integer.toHexString(v);
        return hv.length() < 2 ? ("0" + hv) : hv;
    }

    /**
     * Convert hex string to byte[]
     *
     * @param hexString the hex string
     * @return byte[]
     */
    public static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return d;
    }

    /**
     * Convert char to byte
     *
     * @param c char
     * @return byte
     */
    public static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    /**
     * 按照指定长度对齐
     * 比如（"12",4,true,'0'）则得到 1200
     * 比如（"12",6,false,'x'）则得到 xxxx12
     *
     * @param str         要对齐的字符串
     * @param length      指定长度
     * @param isLeftAlign 是否左对齐
     * @param c           对齐后补的字符
     * @return
     */
    public static String align(String str, int length, boolean isLeftAlign, char c) {
        return String.format("%" + (isLeftAlign ? "-" : "") + length + "s", str).replace(" ", c + "");
    }

}
