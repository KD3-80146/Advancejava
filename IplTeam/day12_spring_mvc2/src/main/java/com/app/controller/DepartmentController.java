package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.service.DepartmentService;

@Controller
@RequestMapping("/departments")
public class DepartmentController {
	@Autowired
	private DepartmentService deptService;
	
	public DepartmentController() {
		System.out.println("in ctr of dept"+getClass());
	}
	
	//url=https://localhost:port/ctr_path/department/list
	//method :GET
	@GetMapping("/list")
	public ModelAndView lsitAllDepartment() {
		return new ModelAndView("/departments/list", "deptServlet", deptService.getAllDepartment());
	}
}

//handler --> mnv -->D>S 
//D.s-->  LVn --> V.R -->>
//D.S store model attrs under :request scope
//forward the request to the jsp based 