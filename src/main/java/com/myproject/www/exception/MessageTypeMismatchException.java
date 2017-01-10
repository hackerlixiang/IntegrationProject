package com.myproject.www.exception;

/**
 * 消息类型不匹配异常
 * @author lixiang
 * @version 1.0
 */
public class MessageTypeMismatchException extends BusinessException{

	/** serialVersionUID */
	private static final long serialVersionUID = -5323301098020916728L;

	/**
	 * 无参构造函数
	 */
	public MessageTypeMismatchException() {
		super("消息类型不存在");
    }

	/**
	 * 带消息内容的构造函数
	 * @param message 消息内容
	 */
	public MessageTypeMismatchException(String message) {
        super(message);
    }
	
}
