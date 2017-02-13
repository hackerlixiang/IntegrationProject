package com.myproject.www.service;

import javax.servlet.http.HttpServletRequest;

import com.myproject.www.bean.AdminBean;
import com.myproject.www.entity.AdminEntity;
import com.myproject.www.others.Message;
import com.myproject.www.pageQuery.query.AdminQuery;

/**
 * 管理员Service
 * 
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月9日 下午5:41:03
 */
public interface IAdminService extends IBaseService<AdminEntity, AdminQuery, Long>{
	
	/**
	 * 持久化之前处理Bean对象属性
	 * @param adminBean 管理员Bean对象
	 * @param request request
	 * @return 管理员Bean对象
	 */
	public AdminBean perBeforeHandleAdmin(AdminBean adminBean,HttpServletRequest request) throws Exception;
	
	/**
	 * 保存管理员
	 * @param menu 管理员Bean对象
	 * @return 消息
	 */
	public Message save(AdminBean adminBean) throws Exception;
	
	/**
	 * 修改管理员
	 * @param adminBean 管理员Bean对象
	 * @return 消息
	 */
	public Message modify(AdminBean adminBean) throws Exception;
	
	/**
	 * 验证管理员名是否重复
	 * @param username 需要验证的管理员名
	 * @param id 需要验证的管理员ID
	 * 
	 * @return true（不重复）,false（重复）
	 */
	public Boolean validateRepeatUsername(String username,Long id) throws Exception;
	
	/**
	 * 验证管理员身份证是否重复
	 * @param idCard 需要验证的管理员身份证
	 * @param id 需要验证的管理员ID
	 * 
	 * @return true（不重复）,false（重复）
	 */
	public Boolean validateRepeatIdCard(String idCard,Long id) throws Exception;
	
	/**
	 * 验证管理员邮箱是否重复
	 * @param email 需要验证的管理员邮箱
	 * @param id 需要验证的管理员ID
	 * 
	 * @return true（不重复）,false（重复）
	 */
	public Boolean validateRepeatEmail(String email,Long id) throws Exception;
	
	/**
	 * 验证管理员手机号是否重复
	 * @param mobile 需要验证的管理员手机号
	 * @param id 需要验证的管理员ID
	 * 
	 * @return true（不重复）,false（重复）
	 */
	public Boolean validateRepeatMobile(String mobile,Long id) throws Exception;
	
	/**
	 * 验证管理员是否存在
	 * @param id 管理员ID
	 * @return true:管理员存在，false:管理员不存在
	 */
	public Boolean adminIsExist(Long id) throws Exception ;

}
