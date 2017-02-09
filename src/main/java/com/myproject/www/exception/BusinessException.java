package com.myproject.www.exception;

/**
 * 业务异常Exception
 * 
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月9日 下午5:41:03
 */
public class BusinessException extends RuntimeException{

	/** serialVersionUID */
	private static final long serialVersionUID = 462854201344303141L;

	public BusinessException(){
		
	}
	
	public BusinessException(String exceptionContent){
		super(exceptionContent);
	}
}
