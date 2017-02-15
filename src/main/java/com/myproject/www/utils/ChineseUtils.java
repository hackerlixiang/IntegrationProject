package com.myproject.www.utils;


/**
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月15日 下午6:24:30
 */
public class ChineseUtils {
	
	private ChineseUtils(){}
	
	/**
	 * 判断字符是否是中文
	 * @param character 需要判断的字符
	 * @return true:是中文，false:不是中文
	 */
	public static Boolean isChinese(Character character){
		return character >= 0x4E00 &&  character <= 0x9FA5;// 根据字节码判断
	}
	
	/**
	 * 获取字符串中的中文
	 * @param str
	 * @return
	 */
	public static String getChineseByStr(String str){
		if(StringUtils.isBlank(str)){
			return null;
		}else{
			StringBuilder chinese = new StringBuilder();
			for (int i=0;i<str.length();i++) {
				char c = str.charAt(i);
				if(isChinese(c)){
					chinese.append(c);
				}
			}
			return chinese.toString();
		}
	}
}
