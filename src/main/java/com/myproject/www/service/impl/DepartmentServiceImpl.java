package com.myproject.www.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.www.dao.IDepartmentDao;
import com.myproject.www.entity.Department;
import com.myproject.www.service.IDepartmentService;

/**
 * 
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月10日 下午2:27:41
 */
@Service
@Transactional
public class DepartmentServiceImpl implements IDepartmentService {
	@Autowired
	IDepartmentDao departmentDao;
	
	@Override
	public void add(Department Department) throws Exception {
		departmentDao.add(Department);
	}

	@Override
	public void delete(Long id) throws Exception {
		departmentDao.delete(id);
	}

	@Override
	public void update(Department newDepartment) throws Exception {
		departmentDao.update(newDepartment);
	}

	@Override
	public Department get(Long id) throws Exception {
		return departmentDao.get(id);
	}

	@Override
	public List<Department> getAll() throws Exception {
		return departmentDao.getAll();
	}

}
