package com.myproject.www.utils.validate;

import java.lang.reflect.Field;

import com.myproject.www.log.Log;
import com.myproject.www.utils.CommonUtils;
import com.myproject.www.utils.StringUtils;
import com.myproject.www.utils.validate.annon.Validate;

/**
 * 注解解析
 * 
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月9日 下午5:41:03
 */
public class ValidateUtils {
	
    private static Validate validate;
     
    private ValidateUtils() {
        super();
    }
     
    //解析的入口
    public static boolean valid(Object object) throws Exception{
    	boolean isPass = false;
        //获取object的类型
        Class<? extends Object> clazz=object.getClass();
        //获取该类型声明的成员	
        Field[] fields=clazz.getDeclaredFields();
        //遍历属性
        for(Field field:fields){
            //对于private私有化的成员变量，通过setAccessible来修改器访问权限
            field.setAccessible(true);
            isPass = validate(field,object);
            //重新设置会私有权限
            field.setAccessible(false);
            if(!isPass){
            	break;
            }
        }
        return isPass;
    }
     
    
    /**
     * 验证
     * @param field 被验证的字段
     * @param object 被验证的对象
     * @return 是否验证通过
     * @throws Exception
     */
    private static Boolean validate(Field field,Object object) throws Exception{
        String description =  StringUtils.EMPTY;
        Object value = null;
 
        //获取对象的成员的注解信息
        validate=field.getAnnotation(Validate.class);
        value=field.get(object);
        if(validate==null){
        	return true;
        }
         
        description=validate.description().equals("")?field.getName():validate.description();
         
        /*************注解解析工作开始******************/
        if(!validate.nullable()){
            if(CommonUtils.isNullOrEmpty(value)){
            	Log.error(description+"不能为空");
//            	logger.error(description+"不能为空");
            	return false;
            }
        }
        
        // 字段可以为空且值为空的情况下不再继续验证
        if(CommonUtils.isNullOrEmpty(value)){
        	return true;
        }
        
        if(value.toString().length()>validate.maxLength()&&validate.maxLength()!=0){
        	Log.error(description+"长度不能超过"+validate.maxLength());
        	return false;
        }
         
        if(value.toString().length()<validate.minLength()&&validate.minLength()!=0){
        	Log.error(description+"长度不能小于"+validate.minLength());
        	return false;
        }
         
        if(validate.regexType()!=RegexType.NONE){
            switch (validate.regexType()) {
                case NONE:
                    break;
                case SPECIALCHAR:
                    if(RegexUtils.hasSpecialChar(value.toString())){
                    	Log.error(description+"不能含有特殊字符");
                    	return false;
                    }
                    break;
                case CHINESE:
                    if(!RegexUtils.isChinese2(value.toString())){
                    	Log.error(description+"必须为中文字符");
                    	return false;
                    }
                    break;
                case EMAIL:
                    if(!RegexUtils.isEmail(value.toString())){
                    	Log.error(description+"Email地址格式不正确");
                    	return false;
                    }
                    break;
                case IP:
                    if(!RegexUtils.isIp(value.toString())){
                    	Log.error(description+"IP地址格式不正确");
                    	return false;
                    }
                    break;
                case NUMBER:
                    if(!RegexUtils.isNumber(value.toString())){
                    	Log.error(description+"不是数字");
                    	return false;
                    }
                    break;
                case MOBILE:
                    if(!RegexUtils.isPhoneNumber(value.toString())){
                    	Log.error(description+"手机格式不正确");
                    	return false;
                    }
                    break;
                case ID_CARD:{
                	 if(!RegexUtils.isIdCard(value.toString())){
                     	Log.error(description+"身份证格式不正确");
                     	return false;
                     }
                     break;
                }
                default:
                    break;
            }
        }
         
        if(StringUtils.isNoneBlank(validate.regexExpression())){
            if(!value.toString().matches(validate.regexExpression())){
            	Log.error(description+"格式不正确");
            	return false;
            }
        }
        
        return true;
        /*************注解解析工作结束******************/
    }
}