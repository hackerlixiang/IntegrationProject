package com.myproject.www.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utils - DefaultValue
 * 
 * @author lixiang
 * @version 1.0
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils{
	
	public static final String yMdHms1 = "yyyy-MM-dd HH:mm:ss";
	public static final String yMd1 = "yyyyMMdd";
	
	/**
     * 不可实例化
     */
    private DateUtils() {
    }
    
    /**
     * 格式化时间对象为字符串（默认采用yyyy-MM-dd HH:mm:ss格式）
     * @param date 时间对象
     * @return 格式化后时间对象字符串
     */
    public static String formateDate(Date date){
    	return formateDate(date,yMdHms1);
    }
    
    /**
     * 格式化时间对象为字符串
     * @param date 时间对象
     * @param pattern 格式化规则
     * @return 格式化后时间对象字符串
     */
    public static String formateDate(Date date,String pattern){
    	if(date == null||StringUtils.isBlank(pattern)){
    		return StringUtils.EMPTY;
    	}else{
    		SimpleDateFormat format = new SimpleDateFormat(pattern);
    		return format.format(date);
    	}
    }
}
