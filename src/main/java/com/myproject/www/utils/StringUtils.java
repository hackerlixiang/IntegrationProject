package com.myproject.www.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Date;

/**
 * Utils - DefaultValue
 * 
 * @author lixiang
 * @version 1.0
 */
public final class StringUtils extends org.apache.commons.lang3.StringUtils{
	
	private StringUtils(){
		
	}
	
	/**
	 * 获取对象的字符串对象
	 * @param obj
	 * @return
	 */
	public static String getStringByObject(Object obj){
		if(obj==null){
			return "-";
		}else if(obj instanceof String){
			return StringUtils.isNotBlank((String)obj)?(String)obj:"-";
		}else if(obj instanceof Date){
			return DateUtils.formateDate((Date)obj);
		}else{
			return obj.toString();
		}
	}
	
	/**
     * 将字符串有某种编码转变成另一种编码
     * @param string 编码的字符串
     * @param originCharset 原始编码格式
     * @param targetCharset 目标编码格式
     * @return String 编码后的字符串
     */
    public static String encodeString(String string,Charset originCharset,Charset targetCharset){
        return string=new String(string.getBytes(originCharset),targetCharset);
    }
     
    /**
     * URL编码
     * @param string 编码字符串
     * @param charset 编码格式
     * @return String
     */
    @SuppressWarnings("deprecation")
    public static String encodeUrl(String string,String charset){
        if(null!=charset&&!charset.isEmpty()){
            try {
                return URLEncoder.encode(string,charset);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return URLEncoder.encode(string);
    }
     
    /**
     * URL编码
     * @param string 解码字符串
     * @param charset 解码格式
     * @return String
     */
    @SuppressWarnings("deprecation")
    public static String decodeUrl(String string,String charset){
        if(null!=charset&&!charset.isEmpty()){
            try {
                return URLDecoder.decode(string,charset);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return null;
            }
        }
        return URLDecoder.decode(string);
    }
    /**
     * 判断字符串是否是空的
     * 方法摘自commons.lang
     * <pre>
     * StringUtils.isEmpty(null)      = true
     * StringUtils.isEmpty("")        = true
     * StringUtils.isEmpty(" ")       = false
     * StringUtils.isEmpty("bob")     = false
     * StringUtils.isEmpty("  bob  ") = false
     * </pre>
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }
     
     /**
     * <p>判断字符串是否是""," ",null,注意和isEmpty的区别</p>
     * 方法摘自commons.lang
     * <pre>
     * StringUtils.isBlank(null)      = true
     * StringUtils.isBlank("")        = true
     * StringUtils.isBlank(" ")       = true
     * StringUtils.isBlank("bob")     = false
     * StringUtils.isBlank("  bob  ") = false
     * </pre>
     */
    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }
    
	
}