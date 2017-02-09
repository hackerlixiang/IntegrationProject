package com.myproject.www.bean;

import com.myproject.www.utils.validate.annon.Validate;

/**
 * 菜单Bean
 * 
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月9日 下午5:41:03
 */
public class MenuBean extends BaseBean{
	
	/** 主键id */
	private Long id;
	
	/** 菜单名 */
	@Validate
	private String name;
	
	/** 菜单指向路径 */
	@Validate
	private String path;
	
	/** 菜单图标 */
	@Validate
	private String icon;
	
	/** 父级菜单ID */
	private Long parentId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	@Override
	public String toString() {
		return "MenuBean [id=" + id + ", name=" + name + ", path=" + path + ", icon=" + icon + ", parentId=" + parentId
				+ "]";
	}
	
}
