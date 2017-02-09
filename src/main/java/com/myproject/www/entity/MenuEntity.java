package com.myproject.www.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.myproject.www.utils.StringUtils;

/**
 * 菜单Entity
 * 
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月9日 下午5:41:03
 */
public class MenuEntity extends BaseEntity{
	
	/** serialVersionUID */
	private static final long serialVersionUID = -5048219058250811346L;

	/** 菜单名 */
	private String name;
	
	/** 菜单指向路径 */
	private String path;
	
	/** 菜单图标*/
	private String icon;
	
	/** 菜单等级 */
	private Integer level;
	
	/** 排序 */
	private Integer sort;
	
	/** 父级菜单ID */
	private Long parentId;
	
	/** 父级菜单 */
	private MenuEntity parent;
	
	/** 子菜单 */
	private List<MenuEntity> childrens = new ArrayList<MenuEntity>();
	
	public MenuEntity() {
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

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public MenuEntity getParent() {
		return parent;
	}

	public void setParent(MenuEntity parent) {
		this.parent = parent;
	}

	public List<MenuEntity> getChildrens() {
		return childrens;
	}

	public void setChildrens(List<MenuEntity> childrens) {
		this.childrens = childrens;
	}

	//================================================JSON====================================================
	@JsonProperty("name")
	public String getNameToJson() {
		return StringUtils.getStringByObject(getName());
	}

	@JsonProperty("path")
	public String getPathToJson() {
		return StringUtils.getStringByObject(getPath());
	}

	@JsonProperty("icon")
	public String getIconToJson() {
		return StringUtils.getStringByObject(getIcon());
	}

	@JsonProperty("level")
	public String getLevelToJson() {
		return StringUtils.getStringByObject(getLevel());
	}

	@JsonProperty("sort")
	public String getSortToJson() {
		return StringUtils.getStringByObject(getSort());
	}
	
	@JsonProperty("parentName")
	public String getParentNameToJson() {
		return getParent()!=null?StringUtils.getStringByObject(getParent().getName()):"-";
	}
	
	@Override
	public String toString() {
		String superToString = super.toString();
		String thisToString = "MenuEntity [name=" + name + ", path=" + path + ", icon=" + icon + ", level=" + level + ", sort=" + sort
		+ ", parentId=" + parentId + ", parent=" + parent + ", childrens=" + childrens + "]";
		return superToString+"|"+thisToString;
	}

}
