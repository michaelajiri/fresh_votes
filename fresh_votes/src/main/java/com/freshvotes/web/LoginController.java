package com.freshvotes.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.freshvotes.domain.User;

@Controller
public class LoginController {
	
	@GetMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@GetMapping(value = "/register")
	public String register(ModelMap modelMap) {
		modelMap.put("user", new User());
		return "register";
	}
	
	@PostMapping(value = "/register")
	public String createAccount(User user) {
		System.out.println(user);
		return "redirect:/register";
	}
}