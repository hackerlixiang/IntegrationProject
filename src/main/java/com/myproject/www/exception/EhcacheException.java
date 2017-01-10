package com.myproject.www.exception;

public class EhcacheException extends RuntimeException{

	/** serialVersionUID */
	private static final long serialVersionUID = -3949939670412546560L;
	
	/**
	 * 无参构造函数
	 */
	public EhcacheException() {
		super("ehcache Element name is Blank");
    }
}
