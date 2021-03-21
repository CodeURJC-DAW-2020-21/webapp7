package com.webapp7.webapp7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import java.net.URI;
//import java.util.Collection;

@Controller
public class KiddysController {
	@GetMapping("/login")
	public String login (){ return "login";}

	@GetMapping("/email")
	public String email() {

		return "email";
	}

	@GetMapping("/contact")
	public String contact() {

		return "contact";
	}


	@GetMapping("/error_404")
	public String error_404(){
		return "error_404";
	}

	@GetMapping("/login_error")
	public String login_error(){
		return "login_error";
	}
}