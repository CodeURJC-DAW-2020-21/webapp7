package com.webapp7.webapp7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import java.net.URI;
//import java.util.Collection;

@Controller
public class KiddysController {


	@GetMapping("/email")
	public String email() {

		return "email";
	}

	@GetMapping("/instructor")
	public String instructor() {

		return "instructor";
	}

	@GetMapping("/contact")
	public String contact() {

		return "contact";
	}

	@GetMapping("/blog-single2")
	public String blogsingle2() {

		return "blog-single2";
	}
	@GetMapping("/blog-single3")
	public String blogsingle3() {

		return "blog-single3";
	}

	@GetMapping("/login")
	public String login(){
		return "login";
	}

	@GetMapping("/error_404")
	public String error_404(){
		return "error_404";
	}

	@GetMapping("/error")
	public String error(){
		return "error";
	}

	@GetMapping("/login_error")
	public String login_error(){
		return "login_error";
	}
}