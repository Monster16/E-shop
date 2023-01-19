package com.shoppingcartsystem.service;



import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


import com.shoppingcartsystem.dto.request.CreateOrderRequest;
import com.shoppingcartsystem.model.ProductOrder;
//import com.shoppingcartsystem.dto.request.GetAllOrderRequest;
//import com.shoppingcartsystem.dto.request.GetAllOrdersByoId;


@Component
public interface OrderService {

	ResponseEntity<?> createOrder(CreateOrderRequest request);

//	ResponseEntity<?> cancelOrder(CancelOrderRequest request);

//	ResponseEntity<?> getOrdersByuEmail(String uEmail);
//	
//	ResponseEntity<?> getAllOrdersByoId(Long oId);

	List<ProductOrder> getOrdersByuEmail(String uEmail);
	
	List<ProductOrder> getAllOrdersByoId(Long oId);
	
}
