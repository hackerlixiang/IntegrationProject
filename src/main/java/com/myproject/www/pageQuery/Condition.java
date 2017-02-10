package com.myproject.www.pageQuery;

/**
 * 查询条件
 * 
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月9日 下午5:41:03
 */
public class Condition {
	
	/** 属性名 */
	private String attributeNamne;
	
	/** 属性值 */
	private Object attributeVlaue;

	public String getAttributeNamne() {
		return attributeNamne;
	}

	public void setAttributeNamne(String attributeNamne) {
		this.attributeNamne = attributeNamne;
	}

	public Object getAttributeVlaue() {
		return attributeVlaue;
	}

	public void setAttributeVlaue(Object attributeVlaue) {
		this.attributeVlaue = attributeVlaue;
	}
	
}
