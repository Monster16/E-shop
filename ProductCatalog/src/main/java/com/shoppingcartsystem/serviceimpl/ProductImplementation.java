package com.shoppingcartsystem.serviceimpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.shoppingcartsystem.model.Product;
import com.shoppingcartsystem.repository.ProductRepository;
import com.shoppingcartsystem.service.ProductService;


@Component
public class ProductImplementation implements ProductService {
	
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public List<Product> findBypName(String pName) {
		return productRepository.findBypName(pName);
	}

	@Override
	public List<Product> findBypCategory(String pCategory) {
		return productRepository.findBypCategory(pCategory);
	}

	@Override
	public Product findBypId(long pId) {
		return productRepository.findBypId(pId);
	}
	
	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
		
	}

	@Override
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void deleteBypId(long pId) {
		productRepository.deleteById(pId);
	}

	@Override
	public Page<Product> getProductByPageNo(Pageable p) {
		// TODO Auto-generated method stub
		return productRepository.findAll(p);
	}

	
	
}
