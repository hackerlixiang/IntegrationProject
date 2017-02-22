package com.myproject.www.exception;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.www.enums.MessageTypeEnum;
import com.myproject.www.others.Message;
import com.myproject.www.others.MessageAlias;
import com.myproject.www.utils.JsonUtils;

/**
 * 系统异常解析处理
 * 
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月9日 下午5:41:03
 */
public class SystemSimpleMappingExceptionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request,HttpServletResponse response, Object handler, Exception exception) {
		// 判断是否ajax请求
        if (!(request.getHeader("accept").indexOf("application/json") > -1|| (request.getHeader("X-Requested-With") != null 
        		&& request.getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1))) {
            // 如果不是ajax
            // 为安全起见，只有业务异常我们对前端可见，否则否则统一归为系统异常
        	Message message = null;
            if (exception instanceof BusinessException) {
                message = Message.addMessage(MessageTypeEnum.failure, exception.getMessage());
            } else {
            	message = Message.getFailureMessage(MessageAlias.SYSTEM_EXCEPTION);
            }
            //这里需要手动将异常打印出来，由于没有配置log，实际生产环境应该打印到log里面
            exception.printStackTrace();
            System.out.println(exception.getMessage());
            
            //对于非ajax请求，我们都统一跳转到500页面
            return new ModelAndView("/system/error/500").addObject("message", message);
        } else {
            // 如果是ajax请求，JSON格式返回
            try {
                response.setContentType("application/json;charset=UTF-8");
                PrintWriter writer = response.getWriter();
                Message message = null;
                if (exception instanceof BusinessException) {
                    message = Message.addMessage(MessageTypeEnum.failure, exception.getMessage());
                } else {
                	message = Message.getFailureMessage(MessageAlias.SYSTEM_EXCEPTION);
                }
                writer.write(JsonUtils.toJson(message));
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
	}

}
