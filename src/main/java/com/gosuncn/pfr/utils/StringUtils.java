package com.gosuncn.pfr.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: HuWeiJian
 * @Date: 2018/11/27 17:53
 * @Description:
 */
public class StringUtils {
    private final static Logger logger = LoggerFactory.getLogger(StringUtils.class);

    /**
     * 解析出url参数中的键值对
     * 如 "index.jsp?Action=del&id=123"，解析出Action:del,id:123存入map中
     *
     * @param URL url地址
     * @return url请求参数部分
     */
    public static Map<String, String> urlSplit(String URL) {
        Map<String, String> mapRequest = new HashMap<String, String>();
        String[] arrSplit = null;
        String strUrlParam = truncateUrlPage(URL);
        if (strUrlParam == null) {
            return mapRequest;
        }
        arrSplit = strUrlParam.split("[&]");
        for (String strSplit : arrSplit) {
            String[] arrSplitEqual = null;
            arrSplitEqual = strSplit.split("[=]");
            //解析出键值
            if (arrSplitEqual.length > 1) {
                //正确解析
                mapRequest.put(arrSplitEqual[0], arrSplitEqual[1]);
            } else {
                if (arrSplitEqual[0] != "") {
                    //只有参数没有值，不加入
                    mapRequest.put(arrSplitEqual[0], "");
                }
            }
        }
        return mapRequest;
    }

    /**
     * 去掉url中的路径，留下请求参数部分
     *
     * @param strURL url地址
     * @return url请求参数部分
     * @author lzf
     */
    public static String truncateUrlPage(String strURL) {
        String strAllParam = null;
        String[] arrSplit = null;
        strURL = strURL.trim();
        arrSplit = strURL.split("[?]");
        if (strURL.length() > 1) {
            if (arrSplit.length > 1) {
                for (int i = 1; i < arrSplit.length; i++) {
                    strAllParam = arrSplit[i];
                }
            }
        }
        return strAllParam;
    }

    /**
     * 截取相对路径,如果不以http开头则原样返回
     * 如 http(s)://127.0.0.1:81020/aaa/bbb/ccc 截取后为 /aaa/bbb/ccc
     *
     * @param url 以http开头的完整路径
     * @return
     */
    public static String truncateUrl(String url) {
       /* try {
            if (!url.startsWith("http")) {
                return url;
            }
            String[] arr = url.split("://")[1].split("/");
            String newUrl = "";
            for (int i = 1; i < arr.length; i++) {
                newUrl += ("/" + arr[i]);
            }
            Log.info("newUrl=" + newUrl);
            return newUrl;
        } catch (Exception e) {
            e.printStackTrace();
            Log.error("url=" + url + " 不符合要求，无法截取！！！");
            return url;
        }*/

        String regex = "^http(s)?\\://(\\d{1,3}\\.){3}\\d{1,3}(\\:\\d{1,5})?";
        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(url);

        //   System.out.println(matcher.find());
        System.out.println("groupCount is -->" + matcher.groupCount());
        while (matcher.find()) {
            String baseUrl = matcher.group(0);
            String[] rootUrl = url.split(baseUrl);
            return rootUrl[1];
        }
        return url;
    }

    /**
     * 是否为空串
     *
     * @param value
     * @return
     */
    public static boolean isBlank(String value) {
        if (value == null || value.trim().length() == 0) {
            return true;
        }
        return false;
    }

    /**
     * 是否为非空串
     * @author Linnan
     * @version 创建时间：2018年6月25日下午5:14:07
     * @param @param value
     * @param @return
     */
    public static boolean isNotBlank(String value) {
        return !isBlank(value);
    }

    /**
     * 检验是否符合yyyy-MM-dd HH:mm:ss
     *
     * @param dateStr
     * @return
     */
    public static boolean validDate(String dateStr) {
        boolean convertSuccess = true;
        // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            format.setLenient(false);
            format.parse(dateStr);
        } catch (Exception e) {
            convertSuccess = false;
        }
        return convertSuccess;
    }

    /**
     * 检验是否符合yyyy-MM-dd
     *
     * @param dateStr
     * @return
     */
    public static boolean validDateOnly(String dateStr) {
        boolean convertSuccess = true;
        // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            format.setLenient(false);
            format.parse(dateStr);
        } catch (Exception e) {
            convertSuccess = false;
        }
        return convertSuccess;
    }


}
