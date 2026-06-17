package com.ecom.product.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.product.dto.ProductDto;
import com.ecom.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	private final ProductService productService;

	ProductController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping("/addProduct")
	public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto) {

		ProductDto productDtoResult = productService.addProduct(productDto);
		return ResponseEntity.status(HttpStatus.CREATED)
									.body(productDtoResult);

	}

}
