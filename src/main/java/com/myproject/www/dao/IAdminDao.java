package com.myproject.www.dao;

import com.myproject.www.entity.AdminEntity;
import com.myproject.www.pageQuery.query.AdminQuery;

/**
 * 管理员Dao
 * 
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月9日 下午5:41:03
 */
public interface IAdminDao extends IBaseDao<AdminEntity, AdminQuery, Long>{

	/**
	 * 根据管理员名获取管理员
	 * @param username
	 * @return 管理员
	 * @throws Exception
	 */
	public AdminEntity findAdminByUsername(String username) throws Exception;

	/**
	 * 根据身份证号获取管理员
	 * @param idCard
	 * @return 管理员
	 * @throws Exception
	 */
	public AdminEntity findAdminByIdCard(String idCard);

	/**
	 * 根据邮箱获取管理员
	 * @param email
	 * @return 管理员
	 * @throws Exception
	 */
	public AdminEntity findAdminByEmail(String email);

	/**
	 * 根据手机号获取管理员
	 * @param mobile
	 * @return 管理员
	 * @throws Exception
	 */
	public AdminEntity findAdminByMobile(String mobile);
}
