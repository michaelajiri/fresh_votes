package com.freshvotes.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.freshvotes.domain.Feature;
import com.freshvotes.domain.Product;
import com.freshvotes.repositories.FeatureRepository;
import com.freshvotes.repositories.ProductRepository;

@Service
public class FeatureService {

	private FeatureRepository featureRepository;
	private ProductRepository productRepository;

	public FeatureService(FeatureRepository featureRepository, ProductRepository productRepository) {
		this.featureRepository = featureRepository;
		this.productRepository = productRepository;
	}

	public Feature createFeature(Long productId) {

		Feature feature = new Feature();

		Optional<Product> productOpt = productRepository.findById(productId);

		if (productOpt.isPresent()) {

			Product product = productOpt.get();
			feature.setProduct(product);
			product.getFeatures().add(feature);
			feature.setStatus("Pending review");

			return featureRepository.save(feature);
		}

		return feature;
	}
}