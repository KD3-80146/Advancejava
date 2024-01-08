package com.app.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
	public HomePageController() {
		System.out.println("in def ctor of "+getClass());
	}
	@GetMapping("/")
	public String showIndexPage(Model map)
	{
		System.out.println("in show index pg");
		map.addAttribute("server_ts", LocalDateTime.now());
		return "/index";//AVN : /WEB-INF/views/index.jsp
	}

}
