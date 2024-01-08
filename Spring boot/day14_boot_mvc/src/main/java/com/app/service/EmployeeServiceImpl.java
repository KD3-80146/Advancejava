package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dao.DepartmentDao;
import com.app.dao.EmployeeDao;
import com.app.pojos.Department;
import com.app.pojos.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	// depcy :
	@Autowired
	private EmployeeDao empDao;

	// dependency
	@Autowired
	private DepartmentDao deptDao;

	@Override
	public List<Employee> getAllEmpsByDeptId(Long deptId) {
		// TODO Auto-generated method stub
		return empDao.findByDeptId(deptId);
	}

	@Override
	public String deleteEmpDetails(Long empId) {
		if (empDao.existsById(empId)) {
			empDao.deleteById(empId);
			return "Emp details deleted.....";
		}
		return "Deletion of emp details failed!!!!!";
	}

	@Override
	public String updateSalary(Long empId, double salary) {
		// get emp details by id
		Employee emp = empDao.findById(empId).orElseThrow();
		// emp : persistent
		emp.setSalary(salary);
		return "emp salary updated ....";
	}

	@Override
	public String addNewEmp(Long deptId, Employee emp) {
		Department dept = deptDao.findById(deptId)
				.orElseThrow
				(() -> new ResourceNotFoundException("Invalid Dept ID!!!"));
		//establish bi dir association
		dept.addEmployee(emp);
		return "Added emp to the dept "+dept.getName();
	}
	/* 
	 *  Spring supplied Tx mgr --will chk for run time exc
	 *  in case of no exc -- tx.commit() --> session.flush--> dirty chking
	 *  --> cacade --> new emp entity in L1 cache --> DML : insert
	 *  --> session.close --> L1 cache is destroyed , db cn rets to the pool
	*/

}
