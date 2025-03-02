package com.security.homepage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {

	@GetMapping("/login")
	public String login() {
		return "custom_login";
	}
	@GetMapping("/admin")
	public String adminHome() {
		return "admin_home";
	}
	@GetMapping("/user")
	public String userHome() {
		return "user_home";
	}
}
