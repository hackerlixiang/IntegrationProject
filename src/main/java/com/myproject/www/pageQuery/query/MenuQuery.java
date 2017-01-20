package com.myproject.www.pageQuery.query;

import com.myproject.www.entity.MenuEntity;

public class MenuQuery extends BaseQuery<MenuEntity>{

	public MenuQuery() {}
	
	/** 父菜单名 */
	private String pname;
	
	/** 父菜单名过滤 */
	private String pnameFilter;
	
	/** 父类名排序 */
	private String parentName;

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPnameFilter() {
		return pnameFilter;
	}

	public void setPnameFilter(String pnameFilter) {
		this.pnameFilter = pnameFilter;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

}
