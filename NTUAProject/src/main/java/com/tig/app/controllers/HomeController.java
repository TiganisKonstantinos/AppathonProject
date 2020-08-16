package com.tig.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;


@Controller
public class HomeController {
	
	
	
	@RequestMapping(value="/")
	public String home() {
		return "home";
	} 
	
	
}
