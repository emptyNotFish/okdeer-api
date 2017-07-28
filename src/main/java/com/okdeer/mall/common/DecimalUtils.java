package com.okdeer.mall.common;

import java.math.BigDecimal;
/**
 * 货币类型转换为其他类型工具类
 * double int
 * @author Administrator
 *
 */
public class DecimalUtils {

	/**
	 * 
	 * @Description: BigDecimal转Double
	 * @param decimal BigDecimal值
	 * @param defultValue 默认值
	 * @return Double 转换后的值  
	 * @author zengj
	 * @date 2016年9月8日
	 */
	public static Double parseDouble(BigDecimal decimal, Double defultValue) {
		return decimal == null ? defultValue : decimal.doubleValue();
	}

	/**
	 * 
	 * @Description: BigDecimal转Double, 为空则返回0
	 * @param decimal BigDecimal值
	 * @return Double 转换后的值  
	 * @author zengj
	 * @date 2016年9月8日
	 */
	public static Double parseDouble(BigDecimal decimal) {
		return parseDouble(decimal, BigDecimal.ZERO.doubleValue());
	}

	/**
	 * 
	 * @Description: BigDecimal转Int
	 * @param decimal BigDecimal值
	 * @param defultValue 默认值
	 * @return Integer 转换后的值  
	 * @author zengj
	 * @date 2016年9月8日
	 */
	public static Integer parseInt(BigDecimal decimal, Integer defultValue) {
		return decimal == null ? defultValue : decimal.intValue();
	}

	/**
	 * 
	 * @Description: BigDecimal转Int, 为空则返回0
	 * @param decimal BigDecimal值
	 * @return Integer 转换后的值  
	 * @author zengj
	 * @date 2016年9月8日
	 */
	public static Integer parseInt(BigDecimal decimal) {
		return parseInt(decimal, BigDecimal.ZERO.intValue());
	}
}
