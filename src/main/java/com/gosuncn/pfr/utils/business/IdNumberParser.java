package com.gosuncn.pfr.utils.business;

import java.util.*;

/**
 * 身份证号结构统计分析器
 * @Auther: HuWeiJian
 * @Date: 2018/11/29 19:23
 * @Description:
 */
public class IdNumberParser {
    //一级行政区代码
    public static Map<String, String> provinceCodes = new HashMap<String, String>();

    public static final String AGE_STRUCE_TEENAGER="少年";
    public static final String AGE_STRUCE_YOUNG="青年";
    public static final String AGE_STRUCE_STRONG="壮年";
    public static final String AGE_STRUCE_MIDDLE="中年";
    public static final String AGE_STRUCE_OLD="老年";
    public static final String AGE_STRUCE_UNKNOW="未知";
    static {
        provinceCodes.put("11", "北京");
        provinceCodes.put("12", "天津");
        provinceCodes.put("13", "河北");
        provinceCodes.put("14", "山西");
        provinceCodes.put("15", "内蒙古");
        provinceCodes.put("21", "辽宁");
        provinceCodes.put("22", "吉林");
        provinceCodes.put("23", "黑龙江");
        provinceCodes.put("31", "上海");
        provinceCodes.put("32", "江苏");
        provinceCodes.put("33", "浙江");
        provinceCodes.put("34", "安徽");
        provinceCodes.put("35", "福建");
        provinceCodes.put("36", "江西");
        provinceCodes.put("37", "山东");
        provinceCodes.put("41", "河南");
        provinceCodes.put("42", "湖北");
        provinceCodes.put("43", "湖南");
        provinceCodes.put("44", "广东");
        provinceCodes.put("45", "广西");
        provinceCodes.put("46", "海南");
        provinceCodes.put("50", "重庆");
        provinceCodes.put("51", "四川");
        provinceCodes.put("52", "贵州");
        provinceCodes.put("53", "云南");
        provinceCodes.put("54", "西藏");
        provinceCodes.put("61", "陕西");
        provinceCodes.put("62", "甘肃");
        provinceCodes.put("63", "青海");
        provinceCodes.put("64", "宁夏");
        provinceCodes.put("65", "新疆");
        provinceCodes.put("71", "台湾");
        provinceCodes.put("81", "香港");
        provinceCodes.put("82", "澳门");
        provinceCodes.put("91", "国外");
    }


    /**
     * 统计身份证号的一级行政区以及年龄结构分布数量
     *
     * @param idNumber    身份证号
     * @param provinceMap map需要外部传入，统计完后结果放在map中
     * @param ageMap      map需要外部传入，统计完后结果放在map中
     */
    public static boolean statistic(String idNumber, Map<String, Integer> provinceMap, Map<String, Integer> ageMap) {
        if (provinceMap == null || ageMap == null) {
            return false;
        }
        if (idNumber == null || idNumber.isEmpty()) {
            return false;
        }
        statisticProvince(idNumber, provinceMap);
        statisticAge(idNumber, ageMap);
        return true;
    }

    /**
     * 初始化年龄结构map
     * @param ageMap
     */
    public static void initAgeMap(Map<String, Integer> ageMap){
        if (ageMap == null) {
            return;
        }
        ageMap.put(AGE_STRUCE_TEENAGER,0);
        ageMap.put(AGE_STRUCE_YOUNG,0);
        ageMap.put(AGE_STRUCE_STRONG,0);
        ageMap.put(AGE_STRUCE_MIDDLE,0);
        ageMap.put(AGE_STRUCE_OLD,0);
    }
    /**
     * 统计身份证号的一级行政区分布数量
     *
     * @param idNumber    身份证号
     * @param provinceMap map需要外部传入，统计完后结果放在map中
     */
    public static void statisticProvince(String idNumber, Map<String, Integer> provinceMap) {
        if (provinceMap == null) {
            return;
        }
        if (idNumber == null || idNumber.isEmpty()) {
            return;
        }
        String provinceName = getProvinceByIdNumber(idNumber);
        Integer i = provinceMap.get(provinceName);
        if (i != null) {
            i++;
        } else {
            i = 1;
        }
        provinceMap.put(provinceName, i);
    }
    /**
     * 统计身份证号的年龄结构分布数量
     *
     * @param idNumber    身份证号
     * @param ageMap      map需要外部传入，统计完后结果放在map中
     */
    public static void statisticAge(String idNumber, Map<String, Integer> ageMap) {
        if (ageMap == null) {
            return;
        }
        if (idNumber == null || idNumber.isEmpty()) {
            return;
        }

        String ageName = getAgeStructByIdNumber(idNumber);
        Integer i = ageMap.get(ageName);
        if (i != null) {
            i++;
        } else {
            i = 1;
        }
        ageMap.put(ageName, i);
    }


    public static String getProvinceByIdNumber(String idNumber) {
        if (idNumber == null || idNumber.isEmpty()) {
            return AGE_STRUCE_UNKNOW;
        }
        idNumber = idNumber.trim();
        String code = idNumber.substring(0, 2);
        String name = provinceCodes.getOrDefault(code, "未知");
        return name;
    }

    /**
     * 获得年龄结构
     * 少年1-18 青年18-35 壮年35-45 中年45-60  老年60-
     *
     * @param idNumber
     * @return
     */
    public static String getAgeStructByIdNumber(String idNumber) {
        int age = getAgeByIdNumber(idNumber);
        if (age < 18) {
            return AGE_STRUCE_TEENAGER;
        } else if (age < 35) {
            return AGE_STRUCE_YOUNG;
        } else if (age < 45) {
            return AGE_STRUCE_STRONG;
        } else if (age < 60) {
            return AGE_STRUCE_MIDDLE;
        } else {
            return AGE_STRUCE_OLD;
        }
    }

    /**
     * 根据身份编号获取年龄
     *
     * @param idNumber 身份编号
     * @return 年龄
     */
    public static int getAgeByIdNumber(String idNumber) {
        if (idNumber == null || idNumber.isEmpty()) {
            return 0;
        }
        idNumber = idNumber.trim();
        int iAge = 0;
        String year = idNumber.substring(6, 10);
        Calendar cal = Calendar.getInstance();
        int iCurrYear = cal.get(Calendar.YEAR);
        iAge = iCurrYear - Integer.valueOf(year);
        return iAge;
    }

    /**
     * 根据身份编号获取出生年月
     *
     * @param idNumber 身份编号
     * @return
     */
    public static String getBirthByIdNumber(String idNumber) {
        if (idNumber == null || idNumber.isEmpty()) {
            return null;
        }
        idNumber = idNumber.trim();
        String yearMonth = idNumber.substring(6, 12);
        return yearMonth;
    }

}
