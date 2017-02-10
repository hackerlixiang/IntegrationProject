package com.myproject.www.log;

import org.apache.log4j.Logger;

/**
 * 日志
 * 
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月9日 下午5:41:03
 */
public class Log extends Logger{
	
	protected Log(String name) {
		super(name);
	}
	
	public static void debug(String message){
		try {
			//获取出错方法的线程堆栈
			StackTraceElement stackTrace = Thread.currentThread().getStackTrace()[2];
			//获取出错方法类全名
			String className = stackTrace.getClassName();
			//获取出错方法方法名
			String methodName = stackTrace.getMethodName();
			//获取出错行数
			int lineNumber = stackTrace.getLineNumber();
			//获取log4j对象
			Logger logger =  Logger.getLogger(className);
			//调用日志方法
			logger.debug(className+"-"+methodName+"-"+lineNumber+":"+message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void info(String message){
		try {
			//获取出错方法的线程堆栈
			StackTraceElement stackTrace = Thread.currentThread().getStackTrace()[2];
			//获取出错方法类全名
			String className = stackTrace.getClassName();
			//获取出错方法方法名
			String methodName = stackTrace.getMethodName();
			//获取出错行数
			int lineNumber = stackTrace.getLineNumber();
			//获取log4j对象
			Logger logger =  Logger.getLogger(className);
			//调用日志方法
			logger.info(className+"-"+methodName+"-"+lineNumber+":"+message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void error(String message){
		try {
			//获取出错方法的线程堆栈
			StackTraceElement stackTrace = Thread.currentThread().getStackTrace()[2];
			//获取出错方法类全名
			String className = stackTrace.getClassName();
			//获取出错方法方法名
			String methodName = stackTrace.getMethodName();
			//获取出错行数
			int lineNumber = stackTrace.getLineNumber();
			//获取log4j对象
			Logger logger =  Logger.getLogger(className);
			//调用日志方法
			logger.error(className+"-"+methodName+"-"+lineNumber+":"+message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
