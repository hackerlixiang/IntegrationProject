package com.myproject.www.bean;

import com.myproject.www.utils.validate.annon.Validate;

public class DataDictionaryBean extends BaseBean {

	/** code */
	@Validate
	private String code;
	
	/** 字典名称 */
	@Validate
	private String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
