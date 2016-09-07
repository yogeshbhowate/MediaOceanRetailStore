package com.retailstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.retailstore.entity.Product;
import com.retailstore.service.ProductService;


@RestController
public class ProductServiceController {

	@Autowired
	ProductService productService;

	@RequestMapping(value = "/", produces="application/json" )
	public Product index() {
		productService.create(new Product("Product 1", "A",12));
		return productService.create(new Product("Product 1", "A",12));
	}


	@RequestMapping("/bill")
	@ResponseBody
	public List<Product> generateBill() {
		return productService.findAll();
	}
	
}
