package com.shoppingcartsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcartsystem.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	
	boolean existsBypName(String pName);
	public List<Product> findBypName(String pName);
	
	boolean existsBypCategory(String pCategory);
	public List<Product> findBypCategory(String pCategory);
	

	public Product findBypId(long pId);
	
}
