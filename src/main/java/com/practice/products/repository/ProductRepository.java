package com.practice.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.products.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	Product findOneById(long id);

}
