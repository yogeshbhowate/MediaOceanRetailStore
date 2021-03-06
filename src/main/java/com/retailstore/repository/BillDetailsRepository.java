package com.retailstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retailstore.entity.Bill;
import com.retailstore.entity.BillDetails;
import com.retailstore.entity.Product;

public interface BillDetailsRepository extends JpaRepository<BillDetails, Long> {

    
}
