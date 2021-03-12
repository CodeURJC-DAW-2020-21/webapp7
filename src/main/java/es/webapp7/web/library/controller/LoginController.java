package es.webapp7.web.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping("/index")
	public String login() {
		return "index";
	}

	@RequestMapping("/loginerror")
	public String loginerror() {
		return "loginerror";
	}
}