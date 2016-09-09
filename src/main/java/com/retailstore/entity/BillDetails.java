package com.retailstore.entity;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="bill_details")
public class BillDetails {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@ManyToOne(cascade=CascadeType.MERGE, fetch = FetchType.EAGER)
    @ElementCollection(targetClass=Product.class)
	private Product product;
	private Integer quantity;
	private Double totalAmount;
	private Double totalTax;
	
	public Long getId() {
		return id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getTotalAmount() {
		return (getProduct().getPrice() * quantity) + getTotalTax() ;
	}
	public void setTotalAmount(Double totalAmount) {
		totalAmount = (getProduct().getPrice() * quantity) + (getProduct().getTax() * quantity);
		this.totalAmount = totalAmount;
	}
	public Double getTotalTax() {
		return (getProduct().getTax() * quantity);
	}
	public void setTotalTax(Double totalTax) {
		totalTax = (getProduct().getTax() * quantity);
		this.totalTax = totalTax;
	}
	
	
}
