package com.retailstore.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.retailstore.entity.Bill;
import com.retailstore.entity.BillDetails;
import com.retailstore.entity.Product;
import com.retailstore.repository.BillDetailsRepository;
import com.retailstore.repository.BillRepository;
import com.retailstore.repository.ProductRepository;
import com.retailstore.util.ServiceException;
import com.retailstore.util.ServiceException.Status;


@Service
public class ProductService {


	@Resource
	private ProductRepository productRepository;
	
	@Resource
	private BillRepository billRepository;
	@Resource
	private BillDetailsRepository billDetailsRepository;


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
	
	public Bill findByBillNo(Long billNo){
		return billRepository.findOne(billNo);
	}
	
	@Transactional
	public Bill addProductToBill(Long productId, Integer quantity ,Long billNo){
		Bill bill = new Bill();
		List<BillDetails> listBillDetails = new ArrayList<>();
		if(billNo != -1){
			bill = billRepository.findOne(billNo);
			if(bill == null){
				throw new ServiceException(Status.NOT_FOUND.getCode(), "Bill details for bill number "+billNo+ " is not found.");
			}
			listBillDetails = bill.getBillDetails();
		}
		Product product = productRepository.findOne(productId);
		if(product == null){
			throw new ServiceException(Status.NOT_FOUND.getCode(), "Product details for product id "+productId+ " is not found.");
		}
		BillDetails billDetails = new BillDetails();
		billDetails.setProduct(product);
		billDetails.setQuantity(quantity);
		billDetailsRepository.save(billDetails);
		
		
		listBillDetails.add(billDetails);
		bill.setBillDetails(listBillDetails);
		
		billRepository.save(bill);
		return bill;
	}
}
