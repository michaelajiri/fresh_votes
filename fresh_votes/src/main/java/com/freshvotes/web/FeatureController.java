package com.freshvotes.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.freshvotes.service.FeatureService;

@Controller
@RequestMapping(value = "/products/{productId}/features")
public class FeatureController {
	
	private FeatureService featureService;

	public FeatureController(FeatureService featureService) {
		this.featureService = featureService;
	}
	
	@PostMapping(value = "")
	private String createFeature(@PathVariable Long productId) {
		featureService.createFeature(productId);
		return "feature";
	}
}