package com.myproject.www.utils.validate;

/**
 * 常用的数据类型枚举
 * 
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月9日 下午5:41:03
 */
public enum RegexType {
     
	/** 无验证规则 */
    NONE,
    
    /** 验证特殊字符  */
    SPECIALCHAR,
    
    /** 验证中文  */
    CHINESE,
    
    /** 验证email  */
    EMAIL,
    
    /** 验证IP  */
    IP, 
    
    /** 验证数字  */
    NUMBER,
    
    /** 验证手机号码 */
    MOBILE,

    /** 验证身份证 */
    ID_CARD;
     
}