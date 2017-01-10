package com.myproject.www.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.www.bean.UserBean;
import com.myproject.www.dao.IUserDao;
import com.myproject.www.entity.UserEntity;
import com.myproject.www.enums.MessageTypeEnum;
import com.myproject.www.others.Message;
import com.myproject.www.others.MessageAlias;
import com.myproject.www.pageQuery.UserQuery;
import com.myproject.www.service.IUserService;
import com.myproject.www.utils.BeanUtils;
import com.myproject.www.utils.IdCardUtils;
import com.myproject.www.utils.StringUtils;

@Service("userServiceImpl")
public class UserServiceImpl extends BaseServiceImpl<UserEntity, UserQuery, Long> implements IUserService {
	
	@Autowired
	private IUserDao userDao;

	@Override
	public UserBean perBeforeHandleUser(UserBean userBean, HttpServletRequest request) {
		if(userBean==null||StringUtils.isBlank(userBean.getIdCard())){
			return userBean;
		}
		if(userBean.getAge()==null){
			userBean.setAge(IdCardUtils.getAgeByIdCard(userBean.getIdCard()));
		}
		if(StringUtils.isBlank(userBean.getSex())){
			userBean.setSex(IdCardUtils.getGenderByIdCard(userBean.getIdCard()));
		}
		if(StringUtils.isBlank(userBean.getBirthday())){
			userBean.setBirthday(IdCardUtils.getBirthByIdCard(userBean.getIdCard()));
		}
		return userBean;
	}
	
	@Override
	public Message save(UserBean userBean) throws Exception {
		UserEntity user = new UserEntity();
		BeanUtils.copyProperties(userBean, user);
		Long affectedConut = userDao.add(user);
		if(affectedConut==1L){
			return Message.getMessage(MessageTypeEnum.success,MessageAlias.USER_ADD);
		}else{
			return Message.getMessage(MessageTypeEnum.failure,MessageAlias.USER_ADD);
		}
	}
	
}
