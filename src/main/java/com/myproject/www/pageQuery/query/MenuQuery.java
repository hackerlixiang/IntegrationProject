package com.myproject.www.pageQuery.query;

import com.myproject.www.entity.MenuEntity;

/**
 * 菜单查询VO
 * 
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月9日 下午5:41:03
 */
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
