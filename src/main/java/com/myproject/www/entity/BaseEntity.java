package com.myproject.www.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.myproject.www.annon.FieldColumn;
import com.myproject.www.utils.StringUtils;

public class BaseEntity implements Serializable{
	
	/** serialVersionUID */
	private static final long serialVersionUID = 8426543817978408229L;
	
	/** 主键id */
	private Long id;

	/** 创建时间 */
	@FieldColumn(column="create_date")
	private Date createDate;
	
	/** 修改时间 */
	@FieldColumn(column="update_date")
	private Date updateDate;

	public BaseEntity() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	//================================================JSON====================================================
	@JsonProperty("id")
	public String getIdToJson() {
		return StringUtils.getStringByObject(getId());
	}
	
	@JsonProperty("createDate")
	public String getCreateDateToJson() {
		return StringUtils.getStringByObject(getCreateDate());
	}
	
	@JsonProperty("updateDate")
	public String getUpdateDateToJson() {
		return StringUtils.getStringByObject(getUpdateDate());
	}
	
	@Override
	public String toString() {
		return "BaseEntity [id=" + id + ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}
	
}
