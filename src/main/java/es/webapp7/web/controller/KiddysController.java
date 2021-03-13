package es.webapp7.web.controller;

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
	public String index() {

		return "index";
	}
	@GetMapping("/email")
	public String email() {

		return "email";
	}
	@GetMapping("/about")
	public String about() {

		return "about";
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
	@GetMapping("/blog")
	public String blog() {

		return "blog";
	}
	@GetMapping("/blog-single")
	public String blogsingle() {

		return "blog-single";
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