package com.okdeer.mall.common;

import java.text.DecimalFormat;
/**
 * 随机数生成工具类
 * @author Administrator
 *
 */
public class RandomUtils {

	/**
	 * 最小数
	 */
	private static final int MIN_NUM = 1;
	
	/**
	 * 五位数的最大值
	 */
	private static final int MAX_FIVE_NUM = 99999;
	
	/**
	 * 五位数值的格式化
	 */
	private static final DecimalFormat FIVEFORMAT = new DecimalFormat("00000");
	
	
	/**
	 * @Description: 生成5位随机数，随机数从1~99999。不足5位，左侧补0
	 * @return   
	 * @author maojj
	 * @date 2016年8月12日
	 */
	public static String randomFive() {
		int randomNum = random(MIN_NUM , MAX_FIVE_NUM);
		return FIVEFORMAT.format(randomNum);
	}
	
	/**
	 * @Description: 随机生成最小数到最大数之间的数值
	 * @param min
	 * @param max
	 * @return   
	 * @author maojj
	 * @date 2016年8月12日
	 */
	public static int random(int min,int max) {
		int num = min + (int)(Math.random()*(max - min + 1));
		if(num == 0) {
			num = random(min,max);
		}
		return num; 
	}
	
	public static void main(String[] args) {
		for(int i=0;i<10000;i++) {
			System.out.println(randomFive());
		}
	}
}
