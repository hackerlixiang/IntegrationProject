package com.myproject.www.exception;

/**
 * 缓存异常Exception
 * 
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月9日 下午5:41:03
 */
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
