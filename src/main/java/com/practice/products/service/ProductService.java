package com.practice.products.service;

import java.util.List;

import com.practice.products.exception.ProductException;
import com.practice.products.model.Product;

public interface ProductService {
	
	public List<Product> getProducts();
	public Product getProductById(long id);
	public Product saveProduct(Product product) throws ProductException;
	public void removeProduct(long id); 

}
