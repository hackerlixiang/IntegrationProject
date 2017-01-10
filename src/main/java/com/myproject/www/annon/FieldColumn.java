package com.myproject.www.annon;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 类字段-表列名 对应 注解
 * @author lixiang
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FieldColumn{
	
    /**
     * 数据库表列名称注解，默认值为类字段名称
     * @return
     */
    public String column() default "";
    
}