package com.myproject.www.exception;

public class BusinessException extends RuntimeException{

	/** serialVersionUID */
	private static final long serialVersionUID = 462854201344303141L;

	public BusinessException(){
		
	}
	
	public BusinessException(String exceptionContent){
		super(exceptionContent);
	}
}
