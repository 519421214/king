package com.gosuncn.pfr.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Copyright © 1997 - 2018 Gosuncn. All Rights Reserved.
 *
 * @author yijiawei
 * @description
 * @date 2018/11/1
 * @email 2751358839@qq.com
 */
public class RegexUtil {
    public RegexUtil() {
    }

    public static boolean isEmoji(String string) {
        Pattern p = Pattern.compile("[^\\u0000-\\uFFFF]");
        Matcher m = p.matcher(string);
        return m.find();
    }
}
