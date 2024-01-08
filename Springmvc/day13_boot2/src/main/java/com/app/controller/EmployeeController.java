package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.service.EmployeeService;

@Controller
@RequestMapping("/emps")
public class EmployeeController {
	//dep : emp service i/f
	@Autowired
	private EmployeeService empService;
	
	public EmployeeController() {
		System.out.println("in def ctor "+getClass());
	}
	/*
	 * http://localhost:8080/day13_boot/emps/list
  		payload : deptId=1 , method=POST
	 */
	@PostMapping("/list")//@PostMapping=@RequestMpping(method=POST)
	public String listEmpsByDept(Model map,
			@RequestParam Long deptId)
	//Long deptId=Long.parseLong(request.getParameter("deptId")
	//MUST match : req param name to method arg name
	{
		System.out.println("in list emps "+deptId);
		//invoke service method
		map.addAttribute("emp_list", empService.getAllEmpsByDeptId(deptId));
		return "/emps/list";// AVN : /WEB-INF/views/emps/list.jsp
	}
}
