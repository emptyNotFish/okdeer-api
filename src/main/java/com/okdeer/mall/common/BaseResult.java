package com.okdeer.mall.common;

import java.io.Serializable;
/**
 * api服务返回结果封装类
 * @author Administrator
 *
 */
public class BaseResult implements Serializable {

	/**
	 * @Fields serialVersionUID : 
	 */
	private static final long serialVersionUID = 4700064136250947898L;

	/** 处理状态 0:成功  1:失败*/
	private String status;

	/** 提示信息 */
	private String msg;

	public BaseResult() {
		this.status = "0";
	}

	public BaseResult(String msg) {
		this.status = "1";
		this.msg = msg;
	}

	public BaseResult(String status, String msg) {
		this.status = status;
		this.msg = msg;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "BaseResult [status=" + status + ", msg=" + msg + "]";
	}

}
