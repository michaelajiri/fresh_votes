package com.freshvotes.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

	@GetMapping(value = "/")
	public String homePage() {
		return "index";
	}
	
	@GetMapping(value = "/dashboard")
	public String dashboard() {
		return "dashboard";
	}
}