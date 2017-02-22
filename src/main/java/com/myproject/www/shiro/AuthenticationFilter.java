package com.myproject.www.shiro;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;

//import com.iclnetwork.web.AuthenticationToken;
//import com.iclnetwork.web.service.RSAService;

/**
 * Filter - 权限认证
 * 
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月9日 下午5:41:03
 */
public class AuthenticationFilter extends FormAuthenticationFilter {

    /** 登录成功URL */
    public static final String SUCCESS_URL = "successUrl";

    /** 默认"用户名"参数名称 */
    public static final String DEFAULT_USERNAME_PARAM = "username";

    /** 默认"密码"参数名称 */
    private static final String DEFAULT_PASSWORD_PARAM = "password";

    /** 默认"验证码"参数名称 */
    private static final String DEFAULT_CAPTCHA_PARAM = "captcha";

    /** 默认"记住我"参数名称 */
    public static final String DEFAULT_REMEMBER_ME_PARAM = "rememberMe";

    /** "用户名"参数名称 */
    private String usernameParam = DEFAULT_USERNAME_PARAM;

    /** "密码"参数名称 */
    private String passwordParam = DEFAULT_PASSWORD_PARAM;

    /** "验证码"参数名称 */
    private String captchaParam = DEFAULT_CAPTCHA_PARAM;

    /** "记住我"参数名称 */
    private String rememberMeParam = DEFAULT_REMEMBER_ME_PARAM;

//    @Resource(name = "rsaServiceImpl")
//    private RSAService rsaService;

    @Override
    protected org.apache.shiro.authc.AuthenticationToken createToken(ServletRequest servletRequest,
            ServletResponse servletResponse) {
//        String username = getUsername(servletRequest);
//        String password = getPassword(servletRequest);
//        String captcha = getCaptcha(servletRequest);
//        boolean rememberMe = isRememberMe(servletRequest);
//        String host = getHost(servletRequest);
//        HttpSession session = getSession(servletRequest);
//        return new AuthenticationToken(username, password, captcha, rememberMe, host, session);
    	return null;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        String requestType = request.getHeader("X-Requested-With");
//
//        // 判断是否为登录请求
//        if (isLoginRequest(request, response)) {
//            // 判断是否包含登录参数
//            if (isLoginSubmission(request, response)) {
//                // 判断是否为AJAX请求（请求方式：AJAX异步请求）
//                if (StringUtils.equalsIgnoreCase(requestType, "XMLHttpRequest")) {
//                    return executeLogin(request, response);
//                }
//                // 限制访问
//                response.addHeader("loginStatus", "Access Denied");
//                response.sendError(HttpServletResponse.SC_FORBIDDEN);
//                return false;
//            }
//            return true;
//        }
//        // 保存请求、重定向到登录
//        saveRequestAndRedirectToLogin(request, response);
//        return false;
    	
    	return false;
    }

    @Override
    protected boolean onLoginSuccess(org.apache.shiro.authc.AuthenticationToken token, Subject subject,
            ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {

//        // 防止Session Fixation攻击
//        Session session = subject.getSession();
//        // 销毁Session
//        Map<Object, Object> attributes = new HashMap<Object, Object>();
//        Collection<Object> keys = session.getAttributeKeys();
//        for (Object key : keys) {
//            attributes.put(key, session.getAttribute(key));
//        }
//        session.stop();
//        // 重构Session
//        session = subject.getSession();
//        for (Entry<Object, Object> entry : attributes.entrySet()) {
//            session.setAttribute(entry.getKey(), entry.getValue());
//        }
//
//        // 设置登录成功跳转URL
//        SavedRequest savedRequest = WebUtils.getAndClearSavedRequest(servletRequest);
//        if (savedRequest != null && StringUtils.equalsIgnoreCase(savedRequest.getMethod(), AccessControlFilter.GET_METHOD)) {
//            servletRequest.setAttribute(SUCCESS_URL, savedRequest.getRequestUrl());
//        } else {
//            servletRequest.setAttribute(SUCCESS_URL, getSuccessUrl());
//        }

        return true;
    }

    /**
     * 获取密码
     * 
     * @param servletRequest
     *            应用请求
     * @return 密码
     */
    @Override
    protected String getPassword(ServletRequest servletRequest) {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        String password = rsaService.decryptParameter(passwordParam, request);
//        rsaService.removePrivateKey(request);
//        return password;
    	
    	return null;
    }

    /**
     * 获取验证码
     * 
     * @param servletRequest
     *            应用请求
     * @return 验证码
     */
    protected String getCaptcha(ServletRequest servletRequest) {
        return WebUtils.getCleanParam(servletRequest, captchaParam);
    }

    /**
     * 获取会话
     * 
     * @param servletRequest
     *            应用请求
     * @return 会话
     */
    protected HttpSession getSession(ServletRequest servletRequest) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        return request.getSession();
    }

    public String getUsernameParam() {
        return usernameParam;
    }

    public void setUsernameParam(String usernameParam) {
        this.usernameParam = usernameParam;
    }

    public String getPasswordParam() {
        return passwordParam;
    }

    public void setPasswordParam(String passwordParam) {
        this.passwordParam = passwordParam;
    }

    public String getRememberMeParam() {
        return rememberMeParam;
    }

    public void setRememberMeParam(String rememberMeParam) {
        this.rememberMeParam = rememberMeParam;
    }

    public String getCaptchaParam() {
        return captchaParam;
    }

    public void setCaptchaParam(String captchaParam) {
        this.captchaParam = captchaParam;
    }

}