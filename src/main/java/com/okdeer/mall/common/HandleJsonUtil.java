package com.okdeer.mall.common;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 获取app请求的json参数
 * @project okdeer-psms
 * @author zuowm
 * @date 2016年1月27日 下午7:33:05
 */
public class HandleJsonUtil {
	/**
	 * logger
	 */
	private static Logger logger = LoggerFactory.getLogger(HandleJsonUtil.class);
	
	/**
	 * 获取json字符串参数
	 * @param request request
	 * @return json字符串
	 */
	public static String getRequestContent(HttpServletRequest request) {
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			request.setCharacterEncoding("UTF-8");
			StringBuffer sb = new StringBuffer();
			is = request.getInputStream();
			isr = new InputStreamReader(is, "UTF-8");
			br = new BufferedReader(isr);
			String s = "";
			while ((s = br.readLine()) != null) {
				sb.append(s);
			}
			return sb.toString();
		} catch (Exception e) {
			logger.error("exception:{}", e);
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (isr != null) {
					isr.close();
				}
				if (is != null) {
					is.close();
				}
			} catch (Exception e2) {
				logger.error("close exception:{}", e2);
			}
		}
		return null;
	}
}
