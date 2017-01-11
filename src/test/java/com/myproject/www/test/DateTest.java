package com.myproject.www.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.myproject.www.utils.DateUtils;

public class DateTest {
	public static void main(String[] args) throws ParseException {
		 /* 随便选两个时间 */
        String d1 = "2015-04-17";
        String d2 = "2016-06-17";
         
        /* 先转成毫秒并求差 */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse(d2);
        Date date2 = sdf.parse(d1);
        /* 根据你的需求进行单位转换 */
        System.out.println("相差毫秒数:"+ DateUtils.getMillisecondForSubtract(date1, date2));
        System.out.println("相差秒数:"+ DateUtils.getSecondForSubtract(date1, date2) );
        System.out.println("相差分钟数:"+ DateUtils.getMinutesForSubtract(date1, date2));
        System.out.println("相差小时数:"+ DateUtils.getHourForSubtract(date1, date2));
        System.out.println("相差天数:"+  DateUtils.getDayForSubtract(date1, date2));
        System.out.println("相差年数:"+  DateUtils.getYearForSubtract(date1, date2).intValue());
        
	}
}
