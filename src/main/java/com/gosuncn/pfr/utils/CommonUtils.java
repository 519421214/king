package com.gosuncn.pfr.utils;

import java.util.List;

/**
 * 一个公共工具类
 * @author xiepeiqi @date 2019年7月23日
 */
public class CommonUtils {

	/**
	 * 统计集合中的整数之和
	 * @param list
	 * @return
	 * @author xiepeiqi @date 2019年7月23日
	 */
	public static int countList(List<Integer>list) {
		Integer a=0;
		for (Integer integer : list) {
			a+=integer;
		}
		return a;
	}
}
