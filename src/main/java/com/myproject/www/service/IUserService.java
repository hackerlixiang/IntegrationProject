package com.myproject.www.service;

import javax.servlet.http.HttpServletRequest;

import com.myproject.www.bean.UserBean;
import com.myproject.www.entity.UserEntity;
import com.myproject.www.others.Message;
import com.myproject.www.pageQuery.UserQuery;
/**
 * 用户Service
 * @author lixiang
 *
 */
public interface IUserService extends IBaseService<UserEntity, UserQuery, Long>{
	
	/**
	 * 持久化之前处理Bean对象属性
	 * @param userBean 用户Bean对象
	 * @param request request
	 * @return 用户Bean对象
	 */
	public UserBean perBeforeHandleUser(UserBean userBean,HttpServletRequest request);
	
	/**
	 * 保存用户
	 * @param menu 用户Bean对象
	 * @return 消息
	 */
	public Message save(UserBean userBean) throws Exception;
}
