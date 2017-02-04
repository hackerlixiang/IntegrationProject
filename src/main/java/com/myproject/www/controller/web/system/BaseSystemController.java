package com.myproject.www.controller.web.system;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;



//import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
//import javax.validation.ConstraintViolation;
//import javax.validation.Validator;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;



import com.myproject.www.utils.StringUtils;
import com.myproject.www.utils.validate.ValidateUtils;

public class BaseSystemController {

	public static final String redirectUrl = "redirect:/system/index/index";

	@Autowired
	private RequestMappingHandlerMapping requestMappingHandlerMapping;

//	@Resource(name = "validator")
//	private Validator validator;

	/**
	 * 打印所有的请求参数
	 * 
	 * @param request
	 */
	public void printParams(HttpServletRequest request) throws Exception{
		Map<String, String[]> map = request.getParameterMap();
		for (Entry<String, String[]> set : map.entrySet()) {
			System.out.print(set.getKey() + "=");
			for (String str : set.getValue()) {
				System.out.print(str + ",");
			}
			System.out.println();
		}
	}

	/**
	 * 默认地址
	 * 
	 * @param request
	 * @return 视图模型对象
	 */
	public String index() throws Exception{
		return redirectUrl;
	}

	/**
	 * 封装modelAndView 返回传入的页面地址
	 * 
	 * @param request
	 * @return ModelAndView对象
	 */
	public ModelAndView getModelAndView(String pagePath) throws Exception {
		if (StringUtils.isNotBlank(pagePath)) {
			ModelAndView modelAndView = new ModelAndView(pagePath);
			return modelAndView;
		} else {
			return null;
		}
	}

	/**
	 * 封装modelAndView 根据请求地址封装返回地址
	 * 
	 * @param request
	 * @return ModelAndView对象
	 */
	public ModelAndView getModelAndView(HttpServletRequest request) throws Exception {
		String requertUrl = extractPathFromPattern(request);
		if (StringUtils.isNotBlank(requertUrl)) {
			ModelAndView modelAndView = new ModelAndView(requertUrl);
			return modelAndView;
		} else {
			return null;
		}
	}

	/**
	 * 数据验证
	 * 
	 * @param object
	 *            验证对象
	 * @return 验证结果
	 */
	protected boolean valid(Object object) throws Exception {
		try {
			return ValidateUtils.valid(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	 /**
     * 数据绑定
     * 
     * @param binder
     *            WebDataBinder
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));  
    }

//	/**
//	 * 数据验证
//	 * 
//	 * @param target
//	 *            验证对象
//	 * @param groups
//	 *            验证组
//	 * @return 验证结果
//	 */
//	protected boolean verify(Object target, Class<?>... groups) {
//		return validator.validate(target, groups).isEmpty();
//	}

//	/**
//	 * 数据验证
//	 * 
//	 * @param redirectAttributes
//	 *            重定向参数
//	 * @param target
//	 *            验证对象
//	 * @param groups
//	 *            验证组
//	 * @return 验证结果
//	 */
//	protected boolean verify(RedirectAttributes redirectAttributes,
//			Object target, Class<?>... groups) {
//		Set<ConstraintViolation<Object>> constraintViolations = validator
//				.validate(target, groups);
//		if (constraintViolations.isEmpty()) {
//			return true;
//		} else {
//			StringBuffer message = new StringBuffer("");
//			for (Iterator<ConstraintViolation<Object>> iterator = constraintViolations
//					.iterator(); iterator.hasNext();) {
//				ConstraintViolation<Object> constraintViolation = (ConstraintViolation<Object>) iterator
//						.next();
//				message.append("<p>");
//				message.append(constraintViolation.getMessage());
//				message.append("</p>");
//			}
//			// 添加瞬时消息
//			// addFlashMessage(redirectAttributes,
//			// Message.error(message.toString()));
//			return false;
//		}
//	}

//	/**
//	 * 数据验证
//	 * 
//	 * @param type
//	 *            类型
//	 * @param property
//	 *            属性
//	 * @param value
//	 *            值
//	 * @param groups
//	 *            验证组
//	 * @return 验证结果
//	 */
//	protected boolean verify(Class<?> type, String property, Object value,
//			Class<?>... groups) {
//		return validator.validateValue(type, property, value, groups).isEmpty();
//	}

//	/**
//	 * 数据验证
//	 * 
//	 * @param redirectAttributes
//	 *            重定向参数
//	 * @param type
//	 *            类型
//	 * @param property
//	 *            属性
//	 * @param value
//	 *            值
//	 * @param groups
//	 *            验证组
//	 * @return 验证结果
//	 */
//	protected boolean verify(RedirectAttributes redirectAttributes,
//			Class<?> type, String property, Object value, Class<?>... groups) {
//		Set<?> constraintViolations = validator.validateValue(type, property,
//				value, groups);
//		if (constraintViolations.isEmpty()) {
//			return true;
//		} else {
//			StringBuffer message = new StringBuffer("");
//			for (Iterator<?> iterator = constraintViolations.iterator(); iterator
//					.hasNext();) {
//				ConstraintViolation<?> constraintViolation = (ConstraintViolation<?>) iterator
//						.next();
//				message.append("<p>");
//				message.append(constraintViolation.getMessage());
//				message.append("</p>");
//			}
//			// 添加瞬时消息
//			// addFlashMessage(redirectAttributes,
//			// Message.error(message.toString()));
//			return false;
//		}
//	}

	private String extractPathFromPattern(final HttpServletRequest request) throws Exception {
//		String path = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		String bestMatchPattern = (String) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
		String[] urlValues = bestMatchPattern.split("/");
		StringBuilder sb = new StringBuilder();
		for (String urlValue : urlValues) {
			if(StringUtils.isNotBlank(urlValue)&&!StringUtils.contains(urlValue, "{")){
				sb.append("/"+urlValue);
			}
		}
		
		return sb.toString();
	}
	
}
