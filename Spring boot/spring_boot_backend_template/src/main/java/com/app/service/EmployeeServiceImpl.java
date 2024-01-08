package com.app.service;

import java.util.List;

import com.app.dao.EmployeeDao;





@Service

public class EmployeeServiceImpl  implements EmployeeService{

   private EmployeeDao dao;

@Override
public List<Employee> getAllEmps() {
	// TODO Auto-generated method stub
	 return dao.findAll();
}
   


}
