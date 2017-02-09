package com.myproject.www.bean;

import com.myproject.www.utils.validate.annon.Validate;

/**
 * 字典项Bean 
 * 
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月9日 下午5:41:03
 */
public class DataDictionaryItemBean extends BaseBean {

	/** code */
	@Validate
	private String code;
	
	/** 字典名称 */
	@Validate
	private String name;
	
	/** 数据字典项对应数据字典CODE */
	@Validate
	private String dataDictionaryCode;
	
	/** 数据字典项对应数据字典ID */
	@Validate
	private Long dataDictionaryId;

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
	
	public String getDataDictionaryCode() {
		return dataDictionaryCode;
	}

	public void setDataDictionaryCode(String dataDictionaryCode) {
		this.dataDictionaryCode = dataDictionaryCode;
	}

	public Long getDataDictionaryId() {
		return dataDictionaryId;
	}

	public void setDataDictionaryId(Long dataDictionaryId) {
		this.dataDictionaryId = dataDictionaryId;
	}
	
}
