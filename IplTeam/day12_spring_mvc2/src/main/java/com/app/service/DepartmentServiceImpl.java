package com.app.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.DepartmentDao;
import com.app.pojos.Department;


@Service//mendatory class level annotation to tell the spring container 
//following is a spring bean containing :business logic
@Transactional
//mandatory annotation to tell spring container to manage database transaction automatically

public class DepartmentServiceImpl  implements DepartmentService{

	 @Autowired
	 private DepartmentDao deptDao;
	@Override
	public List<Department> getAllDepartment() {
		return deptDao.listAllDepartment();
	}

}
