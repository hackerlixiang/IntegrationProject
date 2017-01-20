package com.myproject.www.pageQuery;

import java.util.ArrayList;
import java.util.List;

import com.myproject.www.pageQuery.query.BaseQuery;

/**
 * 分页类
 * @author lixiang
 *
 * @param <T> 数据类型
 */
public class Pagination<T> {
	
	/** 页面数据 */
	private List<T> data = new ArrayList<T>();

	/** 查询到的记录数 */
	private Long recordsFiltered;
	
	/** 总记录数 */
	private Long recordsTotal;
	
	/** 每页显示条数 */
	private Long length;
	
	/** 请求次数 */
	private Long draw;
	
	/** 开始条数 */
	private Long start;
	
	public Pagination() {
		
	}
	
	public Pagination(BaseQuery<?> query) {
		this.length = query.getLength();
		this.draw = query.getDraw();
		this.start = query.getStart();
	}

	public Long getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(Long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public Long getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(Long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
	
	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
	}
	
	public Long getDraw() {
		return draw;
	}

	public void setDraw(Long draw) {
		this.draw = draw;
	}

	public Long getStart() {
		return start;
	}

	public void setStart(Long start) {
		this.start = start;
	}

	public List<T> getData() {
		return data;
	}
	
	public void setData(List<T> data) {
		this.data = data;
	}

	
}
