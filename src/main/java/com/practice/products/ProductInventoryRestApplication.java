package com.practice.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

import com.practice.products.model.Product;
import com.practice.products.repository.ProductRepository;

@SpringBootApplication
public class ProductInventoryRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductInventoryRestApplication.class, args);
	}
	@Bean
	public CommandLineRunner setUp(ProductRepository productRepository) {
		return (args) ->{
			productRepository.save(new Product("product1"));
			productRepository.save(new Product("product2"));
			
		};
	}
}
