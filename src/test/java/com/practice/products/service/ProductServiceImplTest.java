package com.practice.products.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.practice.products.exception.ProductException;
import com.practice.products.model.Product;
import com.practice.products.repository.ProductRepository;

@RunWith(SpringRunner.class)
public class ProductServiceImplTest {
	@TestConfiguration
	static class ProductServiceImplTestContextConfiguration {
		@Bean
		public ProductService productService() {
			return new ProductServiceImpl();
		}

	}

	@Autowired
	private ProductService service;
	@MockBean
	private ProductRepository repository;
	private Product p;
	private Product p2;
	private List<Product> products;

	@Before
	public void setUp() throws Exception {
		p = new Product(1, "product1");
		p2 = new Product(2, "product2");
		products = Arrays.asList(p, p2);

	}

	@Test
	public void testGetProducts() {
		when(repository.findAll()).thenReturn(products);
		List<Product> products = service.getProducts();
		assertEquals(products.size(), 2);
	}

	@Test
	public void testGetProductById() {
		when(repository.findOneById(1)).thenReturn(p2);
		Product p = service.getProductById(1);
		assertEquals(p.getName(), "product2");
		assertEquals(p.getId(), 2);
	}

	@Test
	public void testSaveProduct() throws ProductException {
		when(repository.save(Mockito.any(Product.class))).thenReturn(p2);
		Product p = service.saveProduct(p2);
		assertEquals(p.getName(), "product2");
		assertEquals(p.getId(), 2);
	}

	@Test(expected = ProductException.class)
	public void testSaveProduct_withNull() throws ProductException {
		service.saveProduct(null);
	}

}
