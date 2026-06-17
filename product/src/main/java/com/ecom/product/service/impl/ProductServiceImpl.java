package com.ecom.product.service.impl;

import org.springframework.stereotype.Service;

import com.ecom.product.dto.ProductDto;
import com.ecom.product.entity.Product;
import com.ecom.product.mapper.ProductMapper;
import com.ecom.product.repostory.ProductRepository;
import com.ecom.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	private final  ProductRepository productRepository;
	private final  ProductMapper productMapper;

	ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
		this.productRepository = productRepository;
		this.productMapper = productMapper;
	}

	@Override
	public ProductDto addProduct(ProductDto productDto) {
		
		Product product = productMapper.toEntity(productDto);
		
		product =  productRepository.save(product);
		
		return productMapper.toDto(product);
	}

}
