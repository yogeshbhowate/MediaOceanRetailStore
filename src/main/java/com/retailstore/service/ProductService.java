package com.retailstore.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.retailstore.entity.Product;
import com.retailstore.repository.ProductRepository;


@Service
public class ProductService {


	@Resource
	private ProductRepository productRepository;


	@Transactional
	public Product findById(Long id) {
		return productRepository.findOne(id);
	}
	
	@Transactional
    public Product create(Product product) {
		Product createdProduct = product;
        return productRepository.save(product);
    }
	
	@Transactional
    public List<Product> findAll() {
		return productRepository.findAll();
    }
	
	public void generateBill(List<Long> products){

	}
}
