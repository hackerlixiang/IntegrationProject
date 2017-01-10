package com.myproject.www.others;

import java.util.Arrays;

import com.myproject.www.enums.MessageTypeEnum;
import com.myproject.www.exception.MessageTypeMismatchException;
import com.myproject.www.utils.SpringUtils;

public final class Message {
	
	private MessageTypeEnum type;
	
	private String content;

	private Message(){
	
	}

	private Message(MessageTypeEnum type, String content) {
		this.type = type;
		this.content = content;
	}

	public MessageTypeEnum getType() {
		return type;
	}

	public void setType(MessageTypeEnum type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * 获取消息
	 * @param code 消息code（国际化文件 如MenuAdd.success）
	 * @return 消息对象
	 */
	public static String getMessage(String code){
		return SpringUtils.getMessage(code);
	} 
	
	/**
	 * 获取消息
	 * @param type 消息类型
	 * @param code 消息CODE，（国际化文件 如MENU_PARAM_ERROR）
	 * @return 消息对象
	 */
	public static Message getMessage(MessageTypeEnum type, String code){
		MessageTypeEnum[] typs = MessageTypeEnum.values();
		if(!Arrays.asList(typs).contains(type)){
			throw new MessageTypeMismatchException();
		}
		return new Message(type,getMessage(code));
	}
	
	/**
	 * 添加消息
	 * @param type 消息类型
	 * @param content 消息内容
	 * @return 消息对象
	 */
	public static Message addMessage(MessageTypeEnum type, String content){
		return new Message(type,content);
	}
	
}
