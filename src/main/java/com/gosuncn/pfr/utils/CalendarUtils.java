package com.gosuncn.pfr.utils;

import java.util.Calendar;

/**
 * @Auther: HuWeiJian
 * @Date: 2018/11/30 17:27
 * @Description:
 */
public class CalendarUtils {
    /**
     * 获得当前年份
     * @return
     */
    public static int getCurrentYear(){
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    /**
     * 获得当前月份
     * @return
     */
    public static int getCurrentMonth(){
       return  Calendar.getInstance().get(Calendar.MONTH)+1;
    }
}
