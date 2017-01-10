package com.myproject.www.pageQuery;

import com.myproject.www.entity.UserEntity;

public class UserQuery extends BaseQuery<UserEntity>{
	
	public UserQuery() {}
	
	/** 菜单名 */
	private String username;
	
	/** 菜单名过滤 */
	private String usernameFilter;
	
	/** ID排序 */
	private String idOrder;
	
	/** 菜单名排序 */
	private String crateDateOrder;
	
	/** 等级排序 */
	private String updateDatelOrder;
	
	/** 序列排序 */
	private String usernameOrder;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsernameFilter() {
		return usernameFilter;
	}

	public void setUsernameFilter(String usernameFilter) {
		this.usernameFilter = usernameFilter;
	}

	public String getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(String idOrder) {
		this.idOrder = idOrder;
	}

	public String getCrateDateOrder() {
		return crateDateOrder;
	}

	public void setCrateDateOrder(String crateDateOrder) {
		this.crateDateOrder = crateDateOrder;
	}

	public String getUpdateDatelOrder() {
		return updateDatelOrder;
	}

	public void setUpdateDatelOrder(String updateDatelOrder) {
		this.updateDatelOrder = updateDatelOrder;
	}

	public String getUsernameOrder() {
		return usernameOrder;
	}

	public void setUsernameOrder(String usernameOrder) {
		this.usernameOrder = usernameOrder;
	}
	
}
