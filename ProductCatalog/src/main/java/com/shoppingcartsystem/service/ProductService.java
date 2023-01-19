package com.shoppingcartsystem.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.shoppingcartsystem.model.Product;

@Service
public interface ProductService {
	
    List<Product> findAll();
	
    List<Product> findBypName(String pName);
	
	List<Product> findBypCategory(String pCategory);
	
	Product findBypId(long pId);
	
	Product addProduct(Product product);
	
	Product updateProduct(Product product);
	
	void deleteBypId(long pId);
	
	Page<Product> getProductByPageNo(Pageable p);
	
	

}
