package com.retailstore.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="bill")
public class Bill {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long billNumber;
	@OneToMany(fetch=FetchType.EAGER)
	private List<BillDetails> billDetails;
	
	
	
	public List<BillDetails> getBillDetails() {
		return billDetails;
	}

	public void setBillDetails(List<BillDetails> billDetails) {
		this.billDetails = billDetails;
	}

	public Long getBillNumber() {
		return billNumber;
	}

	public Double getTotalAmount() {
		Double totalAmount = 0.00;
		for(BillDetails details : billDetails){
			totalAmount += details.getTotalAmount();
		}
		return totalAmount;
	}

	

	public Double getTotalTax() {
		Double totalTax = 0.00;
		for(BillDetails details : billDetails){
			totalTax += details.getTotalTax();
		}
		return totalTax;
	}

	

	public void setBillNumber(Long billNumber) {
		this.billNumber = billNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((billNumber == null) ? 0 : billNumber.hashCode());
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
		Bill other = (Bill) obj;
		if (billNumber == null) {
			if (other.billNumber != null)
				return false;
		} else if (!billNumber.equals(other.billNumber))
			return false;
		return true;
	}

	
}
