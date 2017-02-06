package com.myproject.www.service.impl;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.www.bean.AdminBean;
import com.myproject.www.dao.IAdminDao;
import com.myproject.www.entity.AdminEntity;
import com.myproject.www.others.Message;
import com.myproject.www.others.MessageAlias;
import com.myproject.www.pageQuery.query.AdminQuery;
import com.myproject.www.service.IAdminService;
import com.myproject.www.utils.BeanUtils;
import com.myproject.www.utils.DateUtils;
import com.myproject.www.utils.IdCardUtils;
import com.myproject.www.utils.StringUtils;
import com.myproject.www.utils.WebUtils;
import com.myproject.www.utils.encryption.Base64Utils;

@Service("adminServiceImpl")
public class AdminServiceImpl extends BaseServiceImpl<AdminEntity, AdminQuery, Long> implements IAdminService {
	
	@Autowired
	private IAdminDao adminDao;

	@Override
	public AdminBean perBeforeHandleAdmin(AdminBean adminBean, HttpServletRequest request) throws Exception {
		if(adminBean==null){
			return adminBean;
		}
		// 根据生日获取年龄
		Date birthday = adminBean.getBirthday();
		if(birthday!=null){
			adminBean.setAge(DateUtils.getYearForSubtract(new Date(), birthday).intValue());
		}
		//根据省份证获取生日、年龄、性别
		if(StringUtils.isNotBlank(adminBean.getIdCard())){
			if(adminBean.getBirthday()==null){
				adminBean.setBirthday(IdCardUtils.getBirthByIdCard(adminBean.getIdCard()));
			}
			if(adminBean.getAge()==null){
				adminBean.setAge(IdCardUtils.getAgeByIdCard(adminBean.getIdCard()));
			}
			if(StringUtils.isBlank(adminBean.getSex())){
				adminBean.setSex(IdCardUtils.getGenderByIdCard(adminBean.getIdCard()));
			}
		}
		//获取注册IP
		if(request!=null){
			adminBean.setRegistIp(WebUtils.getRemoteIp(request));
		}
		
		////解码base64码
		String password = adminBean.getPassword();
		password = new String(Base64Utils.decode(password));
		adminBean.setPassword(password);
		
		return adminBean;
	}
	
	@Override
	@Transactional
	public Message save(AdminBean adminBean) throws Exception {
		
		AdminEntity admin = new AdminEntity();//创建Admin对象
		BeanUtils.copyProperties(adminBean, admin);//把AdminBean对象的属性copy到Admin对象中
		
		// 处理用户密码
		String password = adminBean.getPassword();
		password = DigestUtils.md5Hex(admin.getPassword());//对Admin对象密码进行MD5加密
		admin.setPassword(password);//将加密后的密码赋值回去
		
		Long affectedConut = adminDao.add(admin);//调用持久化方法
		
		//持久化后消息处理
		if(affectedConut==1L){
			return Message.getSuccessMessage(MessageAlias.ADMIN_ADD_SUCCESS);
		}else{
			return Message.getFailureMessage(MessageAlias.ADMIN_ADD_FAILURE);
		}
		
	}

	@Override
	public Boolean validateRepeatUsername(String username, Long id) throws Exception {
		AdminEntity pAdmin = adminDao.findAdminByUsername(username);
		if(pAdmin==null){
			return true;
		}else if(pAdmin.getId()!=null&&id==null){
			return false;
		}else if(pAdmin.getId()!=null&&id!=null){
			return pAdmin.getId()==id;
		}else{
			return false;
		}
	}

	@Override
	public Boolean validateRepeatIdCard(String idCard, Long id) throws Exception {
		AdminEntity pAdmin = adminDao.findAdminByIdCard(idCard);
		if(pAdmin==null){
			return true;
		}else if(pAdmin.getId()!=null&&id==null){
			return false;
		}else if(pAdmin.getId()!=null&&id!=null){
			return pAdmin.getId()==id;
		}else{
			return false;
		}
	}

	@Override
	public Boolean validateRepeatEmail(String email, Long id) throws Exception {
		AdminEntity pAdmin = adminDao.findAdminByEmail(email);
		if(pAdmin==null){
			return true;
		}else if(pAdmin.getId()!=null&&id==null){
			return false;
		}else if(pAdmin.getId()!=null&&id!=null){
			return pAdmin.getId()==id;
		}else{
			return false;
		}
	}

	@Override
	public Boolean validateRepeatMobile(String mobile, Long id) throws Exception {
		AdminEntity pAdmin = adminDao.findAdminByMobile(mobile);
		if(pAdmin==null){
			return true;
		}else if(pAdmin.getId()!=null&&id==null){
			return false;
		}else if(pAdmin.getId()!=null&&id!=null){
			return pAdmin.getId()==id;
		}else{
			return false;
		}
	}
	
	
	
}
