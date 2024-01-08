package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.DepartmentDao;
import com.app.pojos.Department;

@Service // mandatory cls level anno to tell SC ,
//following is a spring bean containing : Business logic (B.L)
@Transactional // mandatory annotation to tell SC
//--to manage db txs auto.
public class DepartmentServiceImpl implements DepartmentService {
//depcy : dao layer i/f
	@Autowired
	private DepartmentDao deptDao;

	@Override
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		return deptDao.findAll();
	}

}
