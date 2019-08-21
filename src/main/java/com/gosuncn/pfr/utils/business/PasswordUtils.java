package com.gosuncn.pfr.utils.business;

import com.gosuncn.pfr.utils.MD5Utils;

import java.security.SecureRandom;
import java.util.Random;

/**
 * 此工具类与业务相关
 *
 * 注意：明文密码和盐区分大小写，MD5使用小写
 *
 * @Auther: HuWeiJian
 * @Date: 2018/12/14 14:27
 * @Description:
 */
public class PasswordUtils {
    /**
     * md5密码进行加盐处理
     * 加盐后的密码可以保存进数据库
     * @param passwordMD5 明文密码第一次md5加密后的字符串
     * @param salt
     * @return 小写密文
     */
    public static String generateCipher(String passwordMD5, String salt) {
        String newPassword = MD5Utils.encryptMD5ToString(passwordMD5.toLowerCase() + "+" + salt);
        return newPassword.toLowerCase();
    }

    /**
     * 验证密码是否匹配
     * @param passwordMD5 明文密码第一次md5加密后的字符串
     * @param salt
     * @param matchPassword 数据库中的密文
     * @return
     */
    public static boolean match(String passwordMD5, String salt,String matchPassword) {
        return generateCipher(passwordMD5,salt).equalsIgnoreCase(matchPassword);
    }

}
