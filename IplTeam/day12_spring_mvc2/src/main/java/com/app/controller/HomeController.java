package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	   
	  public HomeController() {
		  System.out.println("in def cunstr of "+getClass());
	  }
	

	@RequestMapping("/")
	public  String homePage() {
		System.out.println("Home page started");
		return "/index";
	}
  
}
