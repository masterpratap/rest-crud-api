package com.practice.products.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.products.exception.ProductException;
import com.practice.products.model.Product;
import com.practice.products.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(long id) {
		return productRepository.findOneById(id);
	}

	@Override
	public Product saveProduct(Product product) throws ProductException {
		if(product == null) {
			throw new ProductException("Product cannot be null");
		}
		return productRepository.save(product);
	}

	@Override
	public void removeProduct(long id) {
		productRepository.delete(id);
	}

}
