package com.myproject.www.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 拦截器
 * 
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月9日 下午5:41:03
 */
public class MyInterceptor implements HandlerInterceptor{
	//该方法也是需要preHandle方法的返回值为true时才会执行,在整个请求结束之后
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object object, Exception e)
			throws Exception {
		
	}
	
	//preHandle方法的返回值为true 时才能被调用
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,Object object, ModelAndView modelAndView) throws Exception {
		
	}
	
	//该方法将在请求处理之前进行调用
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object object) throws Exception {
//		HandlerMethod handlerMethod = (HandlerMethod)object;//获取发送请求的对象
//		String className = handlerMethod.getBeanType().getName();//获得请求对象的类型名
//		String methodName = handlerMethod.getMethod().getName();//获得请求对象的方法名
//		System.out.println(className);
//		System.out.println(methodName);
		return true;//返回true表示放行
	}

}
