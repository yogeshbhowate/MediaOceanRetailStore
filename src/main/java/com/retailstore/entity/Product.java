package com.retailstore.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	protected Long id;
    protected String productName;
    protected Double price;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="category_id",referencedColumnName="category_id")
    protected ProductCategory category;
    
    public Product() {

	}

	public Product(String productName, String catagory, double price) {
		this.productName = productName;
		this.price = price;
	}

	@Override
	public String toString() {
		return String.format("Product[id=%d, firstName='%s', lastName='%s']", id, productName, category, price);
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
		return getPrice() * getCatagory().getLeavy();
	}

	public ProductCategory getCatagory() {
		return category;
	}

	public void setCatagory(ProductCategory category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}
