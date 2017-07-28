package com.okdeer.mall.common;

/**
 * @author Laven
 * @pr yscm
 * @desc 数据验证异常
 * @date 2015/7/31 13:59
 * @copyright ©2005-2020 okdeer.com Inc. All rights reserved
 */
public class ValidateException extends Exception {

    /**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = -3998561720997734149L;

	public ValidateException(){
        super();
    }

    public ValidateException(String message){
        super(message);
    }

    public ValidateException(String message, Throwable cause){
        super(message, cause);
    }

    public ValidateException(Throwable cause){
        super(cause);
    }

    public ValidateException(String message, Throwable cause,
                             boolean enableSuppression,
                             boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
