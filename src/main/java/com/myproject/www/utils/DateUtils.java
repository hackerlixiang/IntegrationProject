package com.myproject.www.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
	
	public static final BigDecimal ONE_THOUSAND = new BigDecimal(1000);
	public static final BigDecimal SIXTY = new BigDecimal(60);
	public static final BigDecimal TWENTY_FOUR = new BigDecimal(24);
	public static final BigDecimal YEAR = new BigDecimal(365);
	
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
    
    /**
     * 获取两个时间相差的毫秒数
     * @param date1 日期对象
     * @param date2 日期对象
     * @return 相差毫秒数
     */
    public static BigDecimal getMillisecondForSubtract(Date date1,Date date2){
    	if(date1==null){
    		date1 = new Date();
    	}
    	if(date2==null){
    		date2 = new Date();	
    	}
    	long time1 = date1.getTime();
    	long time2 = date2.getTime();
    	long time0 = time1 - time2;
    	return BigDecimal.valueOf(time0);
    }
    
    /**
     * 获取两个时间相差的秒数
     * @param date1 日期对象
     * @param date2 日期对象
     * @return 相差秒数
     */
    public static BigDecimal getSecondForSubtract(Date date1,Date date2){
    	BigDecimal time = getMillisecondForSubtract(date1, date2);
    	return time.divide(ONE_THOUSAND,2,RoundingMode.DOWN);
    }
    
    /**
     * 获取两个时间相差的分钟数
     * @param date1 日期对象
     * @param date2 日期对象
     * @return 相差分钟数
     */
    public static BigDecimal getMinutesForSubtract(Date date1,Date date2){
    	BigDecimal time = getSecondForSubtract(date1, date2);
    	return time.divide(SIXTY,2,RoundingMode.DOWN);
    }
    
    /**
     * 获取两个时间相差的小时数
     * @param date1 日期对象
     * @param date2 日期对象
     * @return 相差小时数
     */
    public static BigDecimal getHourForSubtract(Date date1,Date date2){
    	BigDecimal time = getMinutesForSubtract(date1, date2);
    	return time.divide(SIXTY,2,RoundingMode.DOWN);
    }
    
    /**
     * 获取两个时间相差的天数
     * @param date1 日期对象
     * @param date2 日期对象
     * @return 相差天数
     */
    public static BigDecimal getDayForSubtract(Date date1,Date date2){
    	BigDecimal time = getHourForSubtract(date1, date2);
    	return time.divide(TWENTY_FOUR,2,RoundingMode.DOWN);
    }
    
    /**
     * 获取两个时间相差的年数
     * @param date1 日期对象
     * @param date2 日期对象
     * @return 相差年数
     */
    public static BigDecimal getYearForSubtract(Date date1,Date date2){
    	BigDecimal time = getDayForSubtract(date1, date2);
    	return time.divide(YEAR,2,RoundingMode.DOWN);
    }
    
    /**
     * 比较两个时间的先后顺序。 如果时间d1在d2之前，返回1，如果时间d1在d2之后，返回-1，如果二者相等，返回0
     * 
     * @param d1
     *            日期对象
     * @param d2
     *            日期对象
     * @return 如果时间d1在d2之前，返回1，如果时间d1在d2之后，返回-1，如果二者相等，返回0
     */
    public static int compareTwoDate(Date d1, Date d2) {
        if (d1 == null || d2 == null) {
            throw new IllegalArgumentException("参数d1或d2不能是null对象！");
        }

        long dI1 = d1.getTime();
        long dI2 = d2.getTime();

        if (dI1 > dI2) {
            return -1;
        } else if (dI1 < dI2) {
            return 1;
        } else {
            return 0;
        }

    }
}
