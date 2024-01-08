package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.EmployeeDao;
import com.app.entities.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	// dependency : dao layer i/f
	@Autowired // =byType with field level D.I
	private EmployeeDao empDao;

	@Override
	public List<Employee> getAllEmps() {
		// TODO Auto-generated method stub
		return empDao.findAll();
	}

	@Override
	public Employee addEmpDetails(Employee emp) {
		// TODO Auto-generated method stub
		return empDao.save(emp);
	}//tx.commit
	

}
