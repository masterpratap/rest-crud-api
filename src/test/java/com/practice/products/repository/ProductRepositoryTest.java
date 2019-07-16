package com.practice.products.repository;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.practice.products.model.Product;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest {
	@Autowired
	private TestEntityManager testEntityManager;
	@Autowired
	private ProductRepository productRepository;
	
	private Product p;
	private Product p2;

	@Before
	public void setUp() throws Exception {
		p = new Product("product1");
		p2= new Product("product2");
		testEntityManager.persist(p);
		
	}

	@Test
	public void testFindOne_withId() {
		testEntityManager.flush();
		Product product = productRepository.findOneById(1);
		assertEquals(product.getName(),"product1");
		assertEquals(product.getId(),1);
	}
	@Test
	public void testSaveProduct() {
		Product product = productRepository.save(p2);
		assertEquals(product.getName(),"product2");
	}

}
