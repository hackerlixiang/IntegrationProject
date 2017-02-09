package com.myproject.www.service;

import java.util.List;

import com.myproject.www.entity.Department;

/**
 * 部门Service
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月9日 下午5:41:03
 */
public interface IDepartmentService {
	public void add(Department department) throws Exception;
	
	public void delete(Long id) throws Exception;
	
	public void update(Department newDepartment) throws Exception;
	
	public Department get(Long id) throws Exception;
	
	public List<Department> getAll() throws Exception;
}
