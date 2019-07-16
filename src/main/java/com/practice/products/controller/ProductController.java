package com.practice.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.products.exception.ProductException;
import com.practice.products.model.Product;
import com.practice.products.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts() {
		return new ResponseEntity<List<Product>>(productService.getProducts(),HttpStatus.OK);
		
	}
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable long id) {
		return new ResponseEntity<Product>(productService.getProductById(id),HttpStatus.OK);
	}
	@PostMapping("/products/save")
	public ResponseEntity<Product> saveProduct(@RequestBody Product payLoad) throws ProductException{
		if(payLoad == null) {
			throw new ProductException("Product cannot be null");
		}
		return new ResponseEntity<Product>(productService.saveProduct(payLoad),HttpStatus.OK);
		
	}
	@PutMapping("/products/update")
	public ResponseEntity<Product> updateProduct(@RequestBody Product payLoad) throws ProductException{
		Product product = productService.getProductById(payLoad.getId());
		if(product == null || product.getId()<=0) {
			throw new ProductException("Product to update doesn't exist");
		}
		return new ResponseEntity<Product>(productService.saveProduct(payLoad),HttpStatus.OK);
		
	}
	@DeleteMapping("/products/delete/{id}")
	public void removeProduct(@PathVariable long id) throws ProductException {
		Product product = productService.getProductById(id);
		if(product == null || product.getId() <= 0) {
			throw new ProductException("Product doesn't exist");
		}
		productService.removeProduct(id);
		
	}
}
