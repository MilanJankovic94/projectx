package com.software.engineering.spring.tripexspenses.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

	@RequestMapping("/")
	public String showHome() {
		return "home";
	}
//	@RequestMapping(value="/login")
//	public String showLogin( ) {
//		return "login";
//	}
//	@RequestMapping("/loggedout")
//	public String showLoggedOut() {
//	
//		return "loggedout";
//	}
}