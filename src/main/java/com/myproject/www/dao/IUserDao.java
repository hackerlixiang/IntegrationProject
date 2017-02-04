package com.myproject.www.dao;

import com.myproject.www.entity.UserEntity;
import com.myproject.www.pageQuery.query.UserQuery;

public interface IUserDao extends IBaseDao<UserEntity, UserQuery, Long>{

	/**
	 * 根据用户名获取用户
	 * @param username
	 * @return 用户
	 * @throws Exception
	 */
	public UserEntity findUserByUsername(String username) throws Exception;

	/**
	 * 根据身份证号获取用户
	 * @param idCard
	 * @return 用户
	 * @throws Exception
	 */
	public UserEntity findUserByIdCard(String idCard);

	/**
	 * 根据邮箱获取用户
	 * @param email
	 * @return 用户
	 * @throws Exception
	 */
	public UserEntity findUserByEmail(String email);

	/**
	 * 根据手机号获取用户
	 * @param mobile
	 * @return 用户
	 * @throws Exception
	 */
	public UserEntity findUserByMobile(String mobile);
}
