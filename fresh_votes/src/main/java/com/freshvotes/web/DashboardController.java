package com.freshvotes.web;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.freshvotes.domain.Product;
import com.freshvotes.domain.User;
import com.freshvotes.repositories.ProductRepository;

@Controller
public class DashboardController {
	
	private ProductRepository productRepository;
	
	public DashboardController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@GetMapping(value = "/")
	public String homePage() {
		return "index";
	}
	
	@GetMapping(value = "/dashboard")
	public String dashboard(@AuthenticationPrincipal User user, ModelMap modelMap) {
		List<Product> listProducts = productRepository.findByUser(user);

		modelMap.put("listProducts", listProducts);
		
		return "dashboard";
	}
}