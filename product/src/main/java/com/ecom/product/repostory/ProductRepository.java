package com.ecom.product.repostory;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecom.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
