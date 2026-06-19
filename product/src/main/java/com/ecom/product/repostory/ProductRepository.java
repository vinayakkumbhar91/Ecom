package com.ecom.product.repostory;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	Optional<List<Product>> findByExpiryDate(LocalDate expiryDate);

}
