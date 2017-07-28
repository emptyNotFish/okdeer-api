package com.okdeer.mall.exception;

/**
 * 自定义异常
 * @author  on 2015-04-14
 *
 */
public class CustomException extends Exception {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4927450410600145763L;
	
	/**
	 * 自定义消息
	 */
	private CustomMessage customMessage;

	/**
	 * 构造函数
	 * @param customMessage 自定义消息
	 */
	public CustomException(CustomMessage customMessage){
		this.customMessage=customMessage;
	}
	
	/**
	 * 获取自定义消息
	 * @return 自定义消息
	 */
	public CustomMessage getCustomMessage(){
		return customMessage;
	}
}
