package com.myproject.www.pageQuery;

import com.myproject.www.entity.DataDictionaryItemEntity;

public class DataDictionaryItemQuery extends BaseQuery<DataDictionaryItemEntity>{
	
	public DataDictionaryItemQuery() {}
	
	/** 菜单名 */
	private String name;
	
	/** ID排序 */
	private String idOrder;
	
	/** 菜单名排序 */
	private String crateDateOrder;
	
	/** 等级排序 */
	private String updateDatelOrder;
	
	/** 序列排序 */
	private String usernameOrder;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
