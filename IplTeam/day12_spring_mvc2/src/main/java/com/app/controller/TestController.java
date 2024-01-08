package com.app.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")//optional but recommended  for the reusable base pattern 
public class TestController {
	 
	public TestController() {
		System.out.println("in ctr"+getClass());
	}
	
	@GetMapping("/test1")//requset mapping (method =get)
	public ModelAndView testModelAndView() {
		System.out.println("in test model and view");
		// o.s.w.s Model and view (String LVN .String modelAttributeName,Object ModelAttrVlue)
		return new ModelAndView("/test/test1", "server_ts", LocalDateTime.now());
	}

}

/*
 * handle rets  mnv --- Ds
 * DS ---->LVM -->V.R-->AvN  : /WEB-INF/views/test/test1.jsp
 * Ds ---> add model attribute (result) under the request scope 
 * forward the client to the jsp based on  view layer
 *    
 * 
 */
