package com.okdeer.mall.exception;

import java.io.Serializable;

/**
 * 自定义消息
 * @author  on 2015-04-14
 *
 */
public class CustomMessage implements Serializable {

	/**
	 * serialVersionUID
	 */
	//有用到反射,所以这个字段就直接注释了
	private static final long serialVersionUID = -4956271505651777862L;


	/**
	 * 构造函数
	 */
	public CustomMessage(){
		
	}
	
	/**
	 * 构造函数
	 * @param result 消息代码
	 * @param msg 消息内容
	 */
	public CustomMessage(int result,String msg){
		this.result=result;
		this.msg=msg;
	}
	
	public CustomMessage(CustomMessageCode code,String msg){
		this.result=code.getIndex();
		this.msg=msg;
	}
	
	public CustomMessage(ErrorCodeEnum errorCodeEnum){
		this.result = errorCodeEnum.getErrorCode();
		this.msg = errorCodeEnum.getErrorMsg();
	}
	
	/**
	 * 构造函数
	 * @param result 消息代码
	 * @param msg 消息内容
	 * @param data 消息附加信息
	 */
	public CustomMessage(int result,String msg,Object data){
		this.result=result;
		this.msg=msg;
		this.data=data;
	}
	
	/**
	 * 消息代码
	 * 0表示成功，其他表示失败
	 */
	private int result;
	
	/**
	 * 消息内容
	 */
	private String msg;
	
	/**
	 * 消息附加数据
	 */
	private Object data;

	/**
	 * 获取消息代码
	 * @return 消息代码
	 */
	public int getResult() {
		return result;
	}

	/**
	 * 设置消息代码
	 * @param result 消息代码
	 */
	public void setResult(int result) {
		this.result = result;
	}
	

	/**
	 * 设置消息代码
	 * @param result 消息代码
	 */
	public void setResultCode(CustomMessageCode result) {
		this.result = result.getIndex();
	}
	

	/**
	 * 获取消息内容
	 * @return 消息内容
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * 设置消息内容
	 * @param msg 消息内容
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * 设置消息附加信息
	 * @return 消息附加信息
	 */
	public Object getData() {
		return data;
	}

	/**
	 * 设置消息附加信息
	 * @param data 附加信息
	 */
	public void setData(Object data) {
		this.data = data;
	}
}