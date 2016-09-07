package com.retailstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retailstore.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByProductName(String id);
}
