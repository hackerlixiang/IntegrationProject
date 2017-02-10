package com.myproject.www.utils;

import java.util.Collection;
import java.util.Map;

/**
 * Utils - 公共工具类
 * 
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月9日 下午5:41:03
 */
public final class CommonUtils{
	
	private CommonUtils(){
		
	}
	
	public static boolean isNotNullOrEmpty(Object obj){
		return !isNullOrEmpty(obj);
	}
	
	public static boolean isNullOrEmpty(Object obj){
        if (obj == null){
        	return true;  
        }  
        if (obj instanceof CharSequence){
        	return ((CharSequence) obj).length() == 0;  
        }  
        if (obj instanceof Collection<?>){
        	return ((Collection<?>) obj).isEmpty();  
        }  
        if (obj instanceof Map<?,?>){
        	return ((Map<?,?>) obj).isEmpty();  
        }  
        if (obj instanceof Object[]){  
            Object[] object = (Object[]) obj;  
            if (object.length == 0) {  
                return true;  
            }  
            boolean empty = true;  
            for (int i = 0; i < object.length; i++) {  
                if (!isNullOrEmpty(object[i])) {  
                    empty = false;  
                    break;  
                }  
            }  
            return empty;  
        }  
        return false;  
    }
	
}