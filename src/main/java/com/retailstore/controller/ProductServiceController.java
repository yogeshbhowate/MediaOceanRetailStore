package com.retailstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.retailstore.entity.Bill;
import com.retailstore.entity.Product;
import com.retailstore.service.ProductService;
import com.retailstore.util.ErrorResponse;
import com.retailstore.util.ServiceException;
import com.retailstore.util.ServiceException.Status;


@RestController
public class ProductServiceController {

	@Autowired
	ProductService productService;

	@RequestMapping(value = "/", produces="application/json", method = RequestMethod.GET )
	public List<Product> allProducts() {
		return productService.findAll();
	}


	@RequestMapping("/generateBill")
	@ResponseBody
	public List<Product> generateBill() {
		return productService.findAll();
	}
	
	@RequestMapping(value = "/scanProduct", produces="application/json", method = RequestMethod.POST )
	@ResponseBody
	public ResponseEntity<Bill> scanProduct(@RequestParam(value = "productId") Long productId,
			@RequestParam(value = "quantity") Integer quantity, @RequestParam(value = "billNumber") Long billNumber) {

		Bill bill = productService.addProductToBill(productId, quantity, billNumber);
		return new ResponseEntity<Bill>(bill, HttpStatus.OK);

	}
	
	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(ServiceException ex) {
		ErrorResponse error = new ErrorResponse();
		error.setStatusCode(ex.getCode());
		error.setMessages(ex.getMessage());
		if(ex.getCode() == Status.NOT_FOUND.getCode()){
			return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
	}
}

