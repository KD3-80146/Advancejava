package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Employee;
import com.app.service.EmployeeService;

@RestController // =@Controller : class level +
//@ResponseBody : added implicitly on ret types of req handling methods
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {
//dependency : service layer i/f
	@Autowired
	private EmployeeService empService;
	
	public EmployeeController() {
		System.out.println("in ctor of "+getClass());
	}
	//URL : http://host:port/employees , method=GET
	@GetMapping
	public /* @ResponseBody */   List<Employee> listEmps() 
	{
		System.out.println("in list emps");
		return empService.getAllEmps();
	}
	//URL : http://host:port/employees , method=POST
	//payload : JSON representation of emp(transient)
	@PostMapping
	public Employee addEmpDetails(@RequestBody Employee emp)
	{
		System.out.println("in add emp "+emp);
		return empService.addEmpDetails(emp);
	}

}
