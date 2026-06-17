package com.ecom.product.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Product {

	@Id
	@GeneratedValue(generator = "prod_id_gen", strategy = GenerationType.AUTO)
	@Column(name = "PRODID", unique = true)
	private int productId;

	@Column(name = "PRODNAME")
	private String productName;

	@Column(name = "PRODPACKDATE")
	private LocalDate packagingDate;

	@Column(name = "PRODEXPRDATE")
	private LocalDate expiryDate;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public LocalDate getPackagingDate() {
		return packagingDate;
	}

	public void setPackagingDate(LocalDate packagingDate) {
		this.packagingDate = packagingDate;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	
}
