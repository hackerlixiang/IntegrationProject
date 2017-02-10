package com.myproject.www.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Utils - 字符串缩略工具类
 * 
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月9日 下午5:41:03
 */
public final class AbbreviateUtils{
	
	private static final String REPLACE_SYMBOL = "*";
	
	enum Position{
		/** 左边 */
		LEFT,
		/** 中间 */
		CENTER,
		/** 右边 */
		RIGHT;
	
	}
	
	private AbbreviateUtils(){
		
	}
	
	public static Position left(){
		return Position.LEFT;
	}
	
	public static Position center(){
		return Position.CENTER;
	}
	
	public static Position right(){
		return Position.RIGHT;
	}
	
	/**
	 * 字符串缩略
	 * @param string 需要缩略的字符串
	 * @param position 被缩略的位置 Position.LEFT,Position.CENTER,Position.RIGHT
	 * @param replaceSymbol 缩略替换符
	 * @param retainLength 字符串保留长度
	 * @param replaceSymbolLength 替换符长度
	 * @param rounding 偏移（缩略中间的时候，前后保留不对称时偏移）
	 * @return 缩略后的字符串
	 */
	public static String abbreviate(String string,Position position,String replaceSymbol,int retainLength,int replaceSymbolLength,RoundingMode ...rounding){
		if(StringUtils.isBlank(string)){
			throw new RuntimeException("字符串为空");
		}
		if(position==null){
			throw new RuntimeException("省略位置为空");
		}
		if(retainLength>=string.length()){
			throw new RuntimeException("保留长度大于字符串长度");
		}
		
		switch (position) {
			case LEFT:{
				String str = StringUtils.right(string,retainLength);
				str = StringUtils.leftPad(str, str.length()+replaceSymbolLength, replaceSymbol);
				return str;
			}
			case CENTER:{
				RoundingMode round = CommonUtils.isNullOrEmpty(rounding)?RoundingMode.UP:RoundingMode.DOWN;
				StringBuilder sb = new StringBuilder();
				int half1 = BigDecimal.valueOf(retainLength).divide(BigDecimal.valueOf(2),round).intValue();
				int half2 = retainLength - half1;
				String str1 = StringUtils.left(string,half1);
				String str2 = StringUtils.right(string,half2);
				str1 = StringUtils.rightPad(str1, str1.length()+replaceSymbolLength, replaceSymbol);
				
				return sb.append(str1).append(str2).toString();
			}
			case RIGHT:{
				String str = StringUtils.left(string,retainLength);
				str = StringUtils.rightPad(str, str.length()+replaceSymbolLength, replaceSymbol);
				return str;
			}
			default:{
				return null;
			}
		}
	}
	
	/**
	 * 缩略姓名
	 * @param name
	 * @return
	 */
	public static String abbrName(String name){
		if(StringUtils.isBlank(name)){
			throw new RuntimeException("姓名为空");
		}
		if(name.length()>1){
			return abbreviate(name, Position.RIGHT, REPLACE_SYMBOL, 1, 2);
		}else{
			return null;
		}
	}
	
	/**
	 * 缩略用户名
	 * @param username
	 * @return
	 */
	public static String abbrUsername(String username){
		if(StringUtils.isBlank(username)){
			throw new RuntimeException("用户名为空");
		}
		if(username.length()>3){
			return abbreviate(username, Position.CENTER, REPLACE_SYMBOL, 3, 4);
		}else{
			return null;
		}
	}

	/**
	 * 缩略手机号
	 * @param mobile
	 * @return
	 */
	public static String abbrMobile(String mobile){
		if(StringUtils.isBlank(mobile)){
			throw new RuntimeException("手机号为空");
		}
		if(mobile.length()>7){
			return abbreviate(mobile, Position.CENTER, REPLACE_SYMBOL, 7, 4,RoundingMode.DOWN);
		}else{
			return null;
		}
	}

	/**
	 * 缩略身份证号
	 * @param idCard
	 * @return
	 */
	public static String abbrIdCard(String idCard){
		if(StringUtils.isBlank(idCard)){
			throw new RuntimeException("身份证号为空");
		}
		if(idCard.length()>14){
			return abbreviate(idCard, Position.CENTER, REPLACE_SYMBOL, 11, 7,RoundingMode.DOWN);
		}else{
			return null;
		}
	}
	
}