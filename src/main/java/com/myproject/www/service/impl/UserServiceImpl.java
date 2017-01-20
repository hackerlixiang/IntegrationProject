package com.myproject.www.service.impl;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.www.bean.UserBean;
import com.myproject.www.dao.IUserDao;
import com.myproject.www.entity.UserEntity;
import com.myproject.www.others.Message;
import com.myproject.www.others.MessageAlias;
import com.myproject.www.pageQuery.query.UserQuery;
import com.myproject.www.service.IUserService;
import com.myproject.www.utils.BeanUtils;
import com.myproject.www.utils.DateUtils;
import com.myproject.www.utils.IdCardUtils;
import com.myproject.www.utils.StringUtils;
import com.myproject.www.utils.WebUtils;

@Service("userServiceImpl")
public class UserServiceImpl extends BaseServiceImpl<UserEntity, UserQuery, Long> implements IUserService {
	
	@Autowired
	private IUserDao userDao;

	@Override
	public UserBean perBeforeHandleUser(UserBean userBean, HttpServletRequest request) {
		if(userBean==null){
			return userBean;
		}
		Date birthday = userBean.getBirthday();
		if(birthday!=null){
			userBean.setAge(DateUtils.getYearForSubtract(new Date(), birthday).intValue());
		}
		if(StringUtils.isNotBlank(userBean.getIdCard())){
			if(userBean.getAge()==null){
				userBean.setAge(IdCardUtils.getAgeByIdCard(userBean.getIdCard()));
			}
			if(StringUtils.isBlank(userBean.getSex())){
				userBean.setSex(IdCardUtils.getGenderByIdCard(userBean.getIdCard()));
			}
			if(userBean.getBirthday()==null){
				userBean.setBirthday(IdCardUtils.getBirthByIdCard(userBean.getIdCard()));
			}
		}
		if(request!=null){
			userBean.setRegistIp(WebUtils.getRemoteIp(request));
		}
		return userBean;
	}
	
	@Override
	@Transactional
	public Message save(UserBean userBean) throws Exception {
		UserEntity user = new UserEntity();//创建User对象
		BeanUtils.copyProperties(userBean, user);//把UserBean对象的属性copy到User对象中
		user.setPassword(DigestUtils.md5Hex(user.getPassword()));//对User对象密码进行MD5加密
		Long affectedConut = userDao.add(user);//调用持久化方法
		//持久化后消息处理
		if(affectedConut==1L){
			return Message.getSuccessMessage(MessageAlias.USER_ADD_SUCCESS);
		}else{
			return Message.getFailureMessage(MessageAlias.USER_ADD_FAILURE);
		}
	}
	
}
