package com.webapp7.webapp7.controller;

import com.webapp7.webapp7.model.Course;
import com.webapp7.webapp7.model.Post;
import com.webapp7.webapp7.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
//import java.net.URI;
//import java.util.Collection;

@Controller
public class KiddysController {


	@GetMapping("/student")
	public String user_student() {

		return "user_student";
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