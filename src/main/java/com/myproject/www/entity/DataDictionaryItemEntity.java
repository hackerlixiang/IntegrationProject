package com.myproject.www.entity;

/**
 * 数据字典项Entity
 * 
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月9日 下午5:41:03
 */
public class DataDictionaryItemEntity extends BaseEntity{

	/** serialVersionUID */
	private static final long serialVersionUID = 8885938619700030932L;

	/** 数据字典项CODE */
	private String code;
	
	/** 数据字典项名称 */
	private String name;
	
	/** 数据字典项对应数据字典CODE */
	private String dataDictionaryCode;
	 
	/** 数据字典项对应数据字典ID */
	private Long dataDictionaryId;
	
	/** 数据字典项对应的数据字典 */
	private DataDictionaryEntity dataDictionary;
	
	public DataDictionaryItemEntity() {
		
	}

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

	public DataDictionaryEntity getDataDictionary() {
		return dataDictionary;
	}

	public void setDataDictionary(DataDictionaryEntity dataDictionary) {
		this.dataDictionary = dataDictionary;
	}

}
