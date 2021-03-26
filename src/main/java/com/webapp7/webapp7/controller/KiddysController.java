package com.webapp7.webapp7.controller;

import com.webapp7.webapp7.Service.UserService;
import com.webapp7.webapp7.model.Course;
import com.webapp7.webapp7.model.Material;
import com.webapp7.webapp7.model.User;
import com.webapp7.webapp7.repository.CourseRepository;
import com.webapp7.webapp7.repository.MaterialRepository;
import com.webapp7.webapp7.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
//import java.net.URI;
//import java.util.Collection;

@Controller
public class KiddysController {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private MaterialRepository materialRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String sendToPage(Model model, HttpServletRequest request){
		if (request.isUserInRole("profesor")){
			return "redirect:/user_instructor";
		}
		if (request.isUserInRole("alumno")){
			return "redirect:/student";
		}
		if (request.isUserInRole("administrador")){
			return "redirect:/admin";
		}
		return "/index";
	}

	@GetMapping("/admin")
	public String showCourses(Model model){
		List<Course> courses= courseRepository.findAll();
		model.addAttribute("courselist", courses);
		List<Material> listMaterial = materialRepository.findAll();
		model.addAttribute("listMaterial",listMaterial);
		List<User> listTeachers = userRepository.findByRol("profesor");
		model.addAttribute("listTeacher",listTeachers);
		List<User> listStudents = userRepository.findByRol("alumno");
		model.addAttribute("listStudent", listStudents);
		return "user_admin";
	}

	@GetMapping("/login")
	public String login (){ return "login";}

	@GetMapping("/email")
	public String email() {

		return "email";
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