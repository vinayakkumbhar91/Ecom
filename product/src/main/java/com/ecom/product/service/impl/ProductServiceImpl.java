package com.ecom.product.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ecom.product.dto.ProductDto;
import com.ecom.product.entity.Product;
import com.ecom.product.mapper.ProductMapper;
import com.ecom.product.repostory.ProductRepository;
import com.ecom.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	private final ProductRepository productRepository;
	private final ProductMapper productMapper;

	ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
		this.productRepository = productRepository;
		this.productMapper = productMapper;
	}

	@Override
	public ProductDto addProduct(ProductDto productDto) {

		Product product = productMapper.toEntity(productDto);

		product = productRepository.save(product);

		return productMapper.toDto(product);
	}

	@Override
	public ProductDto getProductById(int id) {
		Optional<Product> product = productRepository.findById(id);

		return product.isPresent() ? productMapper.toDto(product.get()) : null;

	}

	@Override
	public List<ProductDto> getAllProducts() {

		List<Product> products = productRepository.findAll();
		return products.stream().map(prod -> productMapper.toDto(prod)).collect(Collectors.toList());
	}

	@Override
	public List<ProductDto> getProductsByExpiry(LocalDate expiryDate) {

		Optional<List<Product>> prods = productRepository.findByExpiryDate(expiryDate);

		return prods.isPresent()
				? prods.get().stream().map(prod -> productMapper.toDto(prod)).collect(Collectors.toList())
				: null;
	}

}
