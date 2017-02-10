package com.myproject.www.exception;

/**
 * 消息类型异常
 * 
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月9日 下午5:41:03
 */
public class MessageTypeException extends BusinessException{

	/** serialVersionUID */
	private static final long serialVersionUID = -5323301098020916728L;

	/**
	 * 无参构造函数
	 */
	public MessageTypeException() {
		super("消息类型不存在");
    }

	/**
	 * 带消息内容的构造函数
	 * @param message 消息内容
	 */
	public MessageTypeException(String message) {
        super(message);
    }
	
}
