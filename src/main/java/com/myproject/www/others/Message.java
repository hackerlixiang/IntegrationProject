package com.myproject.www.others;

import java.util.Arrays;

import com.myproject.www.enums.MessageTypeEnum;
import com.myproject.www.exception.MessageTypeException;
import com.myproject.www.utils.SpringUtils;
import com.myproject.www.utils.StringUtils;

/**
 * 消息
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月9日 下午5:41:03
 */
public final class Message {
	
	/** 消息类型 */
	private MessageTypeEnum type;
	
	/** 消息内容 */
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
	 * @param code 消息code（国际化文件 如MENU_PARAM_ERROR）
	 * @return 消息对象
	 */
	public static String getMessage(String code){
		if(StringUtils.isBlank(code)){
			code = MessageAlias.MESSAGE_UNDEFINED;
		}
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
			throw new MessageTypeException();
		}
		if(StringUtils.isBlank(code)){
			code = MessageAlias.MESSAGE_UNDEFINED;
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
		MessageTypeEnum[] typs = MessageTypeEnum.values();
		if(!Arrays.asList(typs).contains(type)){
			throw new MessageTypeException();
		}
		return new Message(type,content);
	}
	
	/**
	 * 获取成功消息
	 * @param code 消息CODE
	 * @return 消息对象
	 */
	public static Message getSuccessMessage(String code){
		if(StringUtils.isBlank(code)){
			code = MessageAlias.MESSAGE_UNDEFINED;
		}
		return getMessage(MessageTypeEnum.success, code);
	}
	
	/**
	 * 获取失败消息
	 * @param code 消息CODE
	 * @return 消息对象
	 */
	public static Message getFailureMessage(String code){
		if(StringUtils.isBlank(code)){
			code = MessageAlias.MESSAGE_UNDEFINED;
		}
		return getMessage(MessageTypeEnum.failure, code);
	}
	
	/**
	 * 获取警告消息
	 * @param code 消息CODE
	 * @return 消息对象
	 */
	public static Message getWarningMessage(String code){
		if(StringUtils.isBlank(code)){
			code = MessageAlias.MESSAGE_UNDEFINED;
		}
		return getMessage(MessageTypeEnum.warning, code);
	}
}
