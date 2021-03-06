package com.freshvotes.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.freshvotes.domain.Product;
import com.freshvotes.domain.User;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Query("SELECT p FROM Product p" + " JOIN FETCH p.user" + " WHERE p.id = :id")
	Optional<Product> findByIdWithUser(Long id);

	List<Product> findByUser(User user);
}