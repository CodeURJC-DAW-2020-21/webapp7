package com.webapp7.webapp7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import java.net.URI;
//import java.util.Collection;

@Controller
public class KiddysController {

	@GetMapping("/student")
	public String user_student() {

		return "user_student";
	}
	@GetMapping("/index")
	public String login() {
		return "index";
	}
	@GetMapping("/email")
	public String email() {

		return "email";
	}

	@GetMapping("/user_instructor")
	public String user_instructor() {

		return "user_instructor";
	}
	@GetMapping("/instructor")
	public String instructor() {

		return "instructor";
	}
	@GetMapping("/admin")
	public String user_admin() {

		return "user_admin";
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
	@GetMapping("/course")
	public String course() {

		return "course";
	}
}