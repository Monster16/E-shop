package com.shoppingcartsystem.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcartsystem.model.ProductOrder;



@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long>{

	List<ProductOrder> findByuEmail(String uEmail);
	
	List<ProductOrder> findByoId(Long oId);


}
