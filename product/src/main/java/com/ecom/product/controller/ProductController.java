package com.ecom.product.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping("/addProduct")
	public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto) {

		ProductDto productDtoResult = productService.addProduct(productDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(productDtoResult);

	}

	@GetMapping("/getProduct/{id}")
	public ResponseEntity<ProductDto> getProductById(@PathVariable int id) {
		ProductDto productDto = productService.getProductById(id);

		return ResponseEntity.status(HttpStatus.FOUND).body(productDto);
	}

	@GetMapping("/getProducts")
	public ResponseEntity<List<ProductDto>> getAllProducts() {
		List<ProductDto> productDtos = productService.getAllProducts();
		return ResponseEntity.status(HttpStatus.FOUND).body(productDtos);
	}

	@GetMapping("/getProductByExpiry/{expiryDate}")
	public ResponseEntity<List<ProductDto>> getProductsByExpiry(@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate expiryDate) {
		List<ProductDto> productDtos = productService.getProductsByExpiry(expiryDate);
		return ResponseEntity.status(HttpStatus.FOUND).body(productDtos);
	}

}
