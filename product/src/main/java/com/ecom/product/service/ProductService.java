package com.ecom.product.service;

import java.time.LocalDate;
import java.util.List;

import com.ecom.product.dto.ProductDto;

public interface ProductService {
	
	public ProductDto addProduct(ProductDto productDto);
	public ProductDto getProductById(int id);
	public List<ProductDto> getAllProducts();
	public List<ProductDto> getProductsByExpiry(LocalDate expiryDate);

}
