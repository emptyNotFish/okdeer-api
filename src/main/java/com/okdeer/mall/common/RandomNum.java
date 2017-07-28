package com.okdeer.mall.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
/**
 * @pr yscm
 * @desc 获取随机数
 * @author zuowm
 * @date 2015年8月27日 下午9:00:53
 * @copyright ©2005-2020 okdeer.com Inc. All rights reserved
 */
public class RandomNum {

	/**
	 * @desc 获取随机数
	 * @param length 随机数位数
	 * @return 返回符合条件的随机数
	 */
	public static String getRandomNum(int length) {
		Random random = new Random();
		String result = "";
		for (int i = 0; i < length; i++) {
			result += random.nextInt(10);
		}
		return result;
	}

	public static String generateCodeByTime(){
  		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
  		 return dateFormat.format(new Date());
   }
	
	public static void main(String[] args) {
		System.out.println(generateCodeByTime());
	}
}
