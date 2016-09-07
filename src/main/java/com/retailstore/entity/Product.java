package com.retailstore.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Product {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	protected Long id;
    protected String productName;
    protected String catagory;
    protected Double price;
   
    public Product() {

	}

	public Product(String productName, String catagory, double price) {
		this.productName = productName;
		this.catagory = catagory;
		this.price = price;
	}

	@Override
	public String toString() {
		return String.format("Product[id=%d, firstName='%s', lastName='%s']", id, productName, catagory, price);
	}

	public Long getId() {
		return id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getTax() {
		return getPrice() * (10/100);
	}

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}



}
