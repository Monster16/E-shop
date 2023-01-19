package com.shoppingcartsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcartsystem.dto.request.CancelOrderRequest;
import com.shoppingcartsystem.dto.request.CreateOrderRequest;
import com.shoppingcartsystem.dto.request.GetAllOrderRequest;
import com.shoppingcartsystem.dto.request.GetAllOrdersByoId;
import com.shoppingcartsystem.model.ProductOrder;
import com.shoppingcartsystem.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping("/getOrderByEmail/{uEmail}")
	public ResponseEntity<?> getOrdersByuEmail(@PathVariable String uEmail) {
		List<ProductOrder> order = orderService.getOrdersByuEmail(uEmail);
		if (order != null) {
			log.info("GETTING USERBYUEMAIL!!! " + uEmail);
			return new ResponseEntity<Object>(order, HttpStatus.OK);
		} else {
			log.error("ORDER NOT PRESENT WITH THIS UEMAIL {} " + uEmail);
			return new ResponseEntity<Object>("ORDER NOT PRESENT WITH THIS UEMAIL {} " + uEmail, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getOrderByoId/{oId}")
	public ResponseEntity<?> getAllOrdersByoId(@PathVariable Long oId) {
		List<ProductOrder> order = orderService.getAllOrdersByoId(oId);
		if (order != null) {
			log.info("GETTING USERBYoId!!! " + oId);
			return new ResponseEntity<Object>(order, HttpStatus.OK);
		} else {
			log.error("ORDER NOT PRESENT WITH THIS oId {} " + oId);
			return new ResponseEntity<Object>("ORDER NOT PRESENT WITH THIS oId {} " + oId, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/createOrder")
	public ResponseEntity<?> createOrder(@RequestBody CreateOrderRequest request) {
		ResponseEntity<?> response = orderService.createOrder(request);
		return response;

	}

//	@PostMapping("/cancelOrder")
//	public ResponseEntity<?> cancelOrder(@RequestBody CancelOrderRequest request){
//		ResponseEntity<?> response = orderService.cancelOrder(request);
//		return response;
//	}
//	
}