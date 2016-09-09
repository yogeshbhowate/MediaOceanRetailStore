package com.retailstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_category")
public class ProductCategory {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="category_id")
	protected Long id;
	protected String category;
	protected double leavy;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getLeavy() {
		return leavy;
	}
	public void setLeavy(double leavy) {
		this.leavy = leavy;
	}
	
	
}
