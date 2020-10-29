package com.freshvotes.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.freshvotes.domain.Product;
import com.freshvotes.domain.User;
import com.freshvotes.repositories.ProductRepository;

@Controller
public class ProductController {
	
	private ProductRepository productRepository;

	public ProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@GetMapping(value = "/products")
	public String getProducts(ModelMap modelMap) {
		return "product";
	}
	
	@GetMapping(value = "/products/{productId}")
	public String getProduct(@PathVariable Long productId) {
		return "product";
	}
	
	@PostMapping(value = "/products")
	public String createProduct(@AuthenticationPrincipal User user) {
		Product product = new Product();
	
		product.setPublished(false);
		product.setUser(user);
		
		product = productRepository.save(product);
		
		return "redirect:/products/" + product.getId();
	}
}