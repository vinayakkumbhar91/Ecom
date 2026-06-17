package com.ecom.product.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public record ProductDto( 
				String productName, 
				@JsonFormat(pattern = "dd/MM/yyyy")LocalDate packagingDate,
				@JsonFormat(pattern = "dd/MM/yyyy")LocalDate expiryDate) {

}
