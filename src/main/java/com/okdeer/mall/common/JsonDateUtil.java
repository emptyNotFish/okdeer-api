package com.okdeer.mall.common;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.TimeZone;

import org.apache.commons.lang3.StringUtils;

/**
 * 时间格式转换
 * 将double bigdemical装换成字符串
 * jar包 有 但是不能引入
 * @author Administrator
 *
 */
public class JsonDateUtil {
	
	/**
	 * 保留小数位数
	 */
	public static final Integer BIGDECIMAL_SCALE_NUM = 2;
	
	/**
	 * 四舍五入保留类型 1直接删除多余的小数位
	 */
	public static final Integer BIGDECIMAL_SCALE_TYPE_ONE = 1;
	
	/**
	 * 四舍五入保留类型 2进位处理
	 */
	public static final Integer BIGDECIMAL_SCALE_TYPE_TWO = 2;
	
	/**
	 * 四舍五入保留类型 3四舍五入
	 */
	public static final Integer BIGDECIMAL_SCALE_TYPE_THREE = 3;

	/**
	 * 获取主机所处时区的对象
	 */
	private static final String TZID = TimeZone.getDefault().getID();

	/**
	 * 时间函数所使用的默认时区
	 */
	private static final TimeZone TZ = TimeZone.getTimeZone(TZID);

	/**
	 * 
	 * @Description: 时间格式转换
	 * @param strTime String 搜索引擎时间数据  yyyy-MM-dd'T'HH:mm:sssxxx
	 * @param formatter SimpleDateFormat 格式化正确的时间格式 new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
	 * @param sdf SimpleDateFormat 要转换的时间格式
	 * @return String 转换后的时间格式  yyyy-MM-dd HH:mm:ss  
	 * @throws ParseException  转换异常 
	 * @author wangf01
	 * @date 2016年8月5日
	 */
	public static String dateConvert(String strTime, SimpleDateFormat formatter, SimpleDateFormat sdf)
			throws ParseException {
		// Begin add by zengj
		// 如果时间为空，默认为当前时间展示
		if (StringUtils.isBlank(strTime)) {
			strTime = sdf.format(DateUtils.getSysDate());
		}
		// End add by zengj
		formatter.setTimeZone(TZ);
		Date convertTime = formatter.parse(strTime);
		return sdf.format(convertTime);
	}

	/**
	 * 
	 * @Description: 价格字段的BigDecimal转换
	 * @param obj Object 需要转换的值
	 * @param num Integer 保存的小数位数
	 * @param type Integer 保存小数的类型 1：直接删除多余的小数位 2：进位处理 3：四舍五入
	 * @return priceDb  BigDecimal
	 * @author wangf01
	 * @date 2016年8月12日
	 */
	public static BigDecimal priceConvertToBigDecimal(Object obj, Integer num, Integer type) {
		return bigDecimalConvert(obj, num, type);
	}

	/**
	 * 
	 * @Description: 价格字段的String转换
	 * @param obj Object 需要转换的值
	 * @param num Integer 保存的小数位数
	 * @param type Integer 保存小数的类型 1：直接删除多余的小数位 2：进位处理 3：四舍五入
	 * @return resultPrice  String
	 * @author wangf01
	 * @date 2016年8月12日
	 */
	public static String priceConvertToString(Object obj, Integer num, Integer type) {
		BigDecimal resultPrice = bigDecimalConvert(obj, num, type);
		if (resultPrice != null) {
			return resultPrice.toString();
		}
		return "";
	}

	/**
	 * 
	 * @Description: 价格字段的转换
	 * @param obj Object 需要转换的值
	 * @param num Integer 保存的小数位数
	 * @param type Integer 保存小数的类型 1：直接删除多余的小数位 2：进位处理 3：四舍五入
	 * @return priceDb  BigDecimal
	 * @author wangf01
	 * @date 2016年8月16日
	 */
	private static BigDecimal bigDecimalConvert(Object obj, Integer num, Integer type) {
		// setScale(1,BigDecimal.ROUND_DOWN)直接删除多余的小数位
		// setScale(1,BigDecimal.ROUND_UP)进位处理
		// setScale(1,BigDecimal.ROUND_HALF_UP)四舍五入
		// Begin add by zengj
		// 如果金额为空，默认为0展示
		String price = String.valueOf(obj);
		if (StringUtils.isBlank(price)) {
			price = BigDecimal.ZERO.toString();
		}
		// End add by zengj
		BigDecimal priceDb = null;
		switch (type) {
			case 1:
				priceDb = new BigDecimal(price).setScale(num, BigDecimal.ROUND_DOWN);
				break;
			case 2:
				priceDb = new BigDecimal(price).setScale(num, BigDecimal.ROUND_UP);
				break;
			case 3:
				priceDb = new BigDecimal(price).setScale(num, BigDecimal.ROUND_HALF_UP);
				break;
			default:
				priceDb = new BigDecimal(price).setScale(num, BigDecimal.ROUND_DOWN);
				break;
		}
		return priceDb;
	}
	
	/**
	 * @Description: 将json结果集中的浮点型 数据转为字符串
	 * @param obj 结果集
	 * @param nameStr 要转换的字符名  
	 * @author tuzhd
	 * @date 2016年11月28日
	 */
	public static void priceConvertToString(JSONObject obj,String nameStr) {
		//根据字符串进行转换
		Object str = obj.get(nameStr);
		//价格字段的String转换
		String value = priceConvertToString(str, 2, 3);
		obj.put(nameStr, value);
		
	}
	
	/**
	 * @Description: 将结果集中所有的BigDecimal 字段转为string
	 * @param obj    结果集
	 * @author tuzhd
	 * @date 2016年11月28日
	 */
	public static void priceBigDecimalToString(JSONObject obj){
		Set<Object> keys = obj.keySet();
		for(Object key : keys){
			if ((key instanceof String)) {
				Object value = obj.get(key);
				if(value instanceof BigDecimal){
					priceConvertToString(obj, (String)key);
				
				//如果被转成JSONNull改为null
				}else if(value instanceof JSONNull){
					obj.put((String)key, null);
				}
				
		   }
		}
		
	}

}
