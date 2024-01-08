package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//mandatory class level annotation to tell Sc
//following is a spring bean having request handling method
//Singleton n eager
public class HelloController {
	public HelloController() {
		System.out.println("in ctor of "+getClass());
	}
	//add a request handling method to display a welcome mesg
	@RequestMapping("/hello")//mandatory method level annotation 
	//to intercept Any HTTP request (get|post|put...)
	public String sayHello() {
		//return LVM(Local View Name) TO D.S(Dispatcher Servlet)--> To resolve By V.R(VIEWR ESOLVER )
		//--> TO BE RESOLVED BY V.R(VIEW RESOLVER)
		
		System.out.println("in say hello");
		return "/welcome";
	}

}
