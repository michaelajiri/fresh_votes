package com.freshvotes.web;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
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
	public String getProduct(@PathVariable Long productId, ModelMap modelMap, HttpServletResponse response)
			throws IOException {

		Optional<Product> productOpt = productRepository.findById(productId);
		if (productOpt.isPresent()) {
			Product product = productOpt.get();
			modelMap.put("product", product);
		} else {
			response.sendError(HttpStatus.NOT_FOUND.value(), "Product with id " + productId + " was not found");
			return "product";
		}
		return "product";
	}
	
	@PostMapping(value = "/products/{productId}")
	public String saveProduct(@PathVariable Long productId, Product product) {
		product = productRepository.save(product);
		return "redirect:/products/" + product.getId();
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