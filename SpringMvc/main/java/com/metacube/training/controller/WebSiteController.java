package com.metacube.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebSiteController {

	
	/*
	 * First request for first page will come here when tomcate will start
	 * @return welcome, which will call welcome,jsp page 
	 * after returning welcome string here spring-servlet.xml file will append .jsp here
	 * */
	  @RequestMapping(value = "/", method = RequestMethod.GET)
	    public String home() {
	        
	        return "welcome";
	    
	    }
	    
}
