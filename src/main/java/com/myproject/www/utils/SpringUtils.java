package com.myproject.www.utils;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.servlet.LocaleResolver;

/**
 * Spring工具类
 * 
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月9日 下午5:41:03
 */
@Component("springUtils")
@Lazy(false)
public final class SpringUtils extends PropertyPlaceholderConfigurer implements ApplicationContextAware, DisposableBean {

    /** applicationContext */
    private static ApplicationContext applicationContext;
    
    /** properties变量容器 */
    private static Map<String,String> propertyMap;

    /**
     * 不可实例化
     */
    private SpringUtils() {
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        SpringUtils.applicationContext = applicationContext;
    }

    public void destroy() throws Exception {
        applicationContext = null;
    }

    /**
     * 获取Spring上下文（应用上下文）
     * 
     * @return Spring上下文（应用上下文）
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 获取实例
     * 
     * @param name
     *            Bean名称
     * @return 实例
     */
    public static Object getBean(String name) {
        Assert.hasText(name);
        return applicationContext.getBean(name);
    }

    /**
     * 获取实例
     * 
     * @param name
     *            Bean名称
     * @param type
     *            Bean类型
     * @return 实例
     */
    public static <T> T getBean(String name, Class<T> type) {
        Assert.hasText(name);
        Assert.notNull(type);
        return applicationContext.getBean(name, type);
    }

    /**
     * 获取国际化消息
     * 
     * @param code
     *            代码
     * @param args
     *            参数
     * @return 国际化消息
     */
    public static String getMessage(String code, Object... args) {
        LocaleResolver localeResolver = getBean("localeResolver", LocaleResolver.class);
        Locale locale = localeResolver.resolveLocale(null);
        String message = SpringUtils.applicationContext.getMessage(code, args, locale);
        return  StringUtils.isBlank(message)?"-":message;
    }
    
    /**
     * 获取properties变量
     * @param name 参数名
     * @return
     */
    public static Object getProperty(String name) {
        return propertyMap.get(name);
    }
    
    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
        super.processProperties(beanFactoryToProcess, props);
        propertyMap = new HashMap<String, String>();
        for (Object key : props.keySet()) {
            String keyStr = key.toString();
            String value = props.getProperty(keyStr);
            propertyMap.put(keyStr, value);
        }
    }

}