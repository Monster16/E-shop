package com.shoppingcartsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shoppingcartsystem.dto.request.CancelOrderRequest;
import com.shoppingcartsystem.dto.request.CreateOrderRequest;
import com.shoppingcartsystem.dto.request.GetAllOrderRequest;
import com.shoppingcartsystem.dto.request.GetAllOrdersByoId;
import com.shoppingcartsystem.dto.response.GetAllOrderResponse;
import com.shoppingcartsystem.dto.response.Order;
import com.shoppingcartsystem.dto.response.ProductItem;
import com.shoppingcartsystem.dto.response.ServiceResponse;
import com.shoppingcartsystem.model.OrderItem;
import com.shoppingcartsystem.model.ProductOrder;
import com.shoppingcartsystem.repository.ProductOrderRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

	@Autowired
	private ProductOrderRepository productOrderRepository;
	
	@Override
	public ResponseEntity<?> createOrder(CreateOrderRequest request) {
		
		ResponseEntity<?> responseEntity;
		ServiceResponse serviceResponse = new ServiceResponse();
		
		try {
			ProductOrder productOrder = new ProductOrder();
		
			//Set<OrderItem> orderItems = new HashSet<>();
			
			List<OrderItem> orderItems = new ArrayList<>();
			
			for(int i = 0; i < request.getOrderItems().size(); i++) {
				OrderItem orderItem = new OrderItem();
				orderItem.setProduct(request.getOrderItems().get(i).getProduct());
				orderItem.setpName(request.getOrderItems().get(i).getpName());
				orderItem.setQty(request.getOrderItems().get(i).getQty());
				orderItem.setpPricePerUnit(request.getOrderItems().get(i).getpPricePerUnit());
				orderItem.setpImage(request.getOrderItems().get(i).getpImage());
				orderItems.add(orderItem);
			}			
			productOrder.setOrderItems(orderItems);
			productOrder.setuEmail(request.getuEmail());
			productOrder.setTotalPrice(request.getTotalPrice());
			productOrder.setTax(request.getTax());
			productOrder.setPaymentMethod(request.getPaymentMethod());
			productOrderRepository.save(productOrder);
			serviceResponse.setCode("200");
			serviceResponse.setMessage("Order Placed Successfully");
			responseEntity = new ResponseEntity<>(serviceResponse, HttpStatus.OK);
		} catch (Exception e) {
			serviceResponse.setCode("500");
			serviceResponse.setMessage("Internal Server Error");
			responseEntity = new ResponseEntity<>(serviceResponse, HttpStatus.OK);
		}
		
		
		return responseEntity;
	}

	@Override
	public List<ProductOrder> getOrdersByuEmail(String uEmail) {
		// TODO Auto-generated method stub
		return productOrderRepository.findByuEmail(uEmail);
	}

	@Override
	public List<ProductOrder> getAllOrdersByoId(Long oId) {
		// TODO Auto-generated method stub
		return productOrderRepository.findByoId(oId);
	}

	

//	@Override
//	public ResponseEntity<?> cancelOrder(CancelOrderRequest request) {
//		
//		ServiceResponse response = new ServiceResponse();
//		ResponseEntity<?> responseEntity;
//		
//		try {
//			ProductOrder prodOrder = productOrderRepository.findById(request.getoId()).orElse(null);
////			prodOrder.setOrderStatus("Cancelled");
//			productOrderRepository.save(prodOrder);
//			response.setCode("200");
//			response.setMessage("Order Cancelled");
//			responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
//		} catch (Exception e) {
//			response.setCode("500");
//			response.setMessage("Internal Server Error");
//			responseEntity = new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		
//		return responseEntity;
//	}

//	@Override
//	public ResponseEntity<?> getOrdersByuEmail(String uEmail) {
//
//		ResponseEntity<?> responseEntity = null;
//	
//		try {
//			
//			List<ProductOrder> allOrder = productOrderRepository.findByuEmail(uEmail);
//			
//			if(!(allOrder.size() == 0)) {
//				GetAllOrderResponse response = new GetAllOrderResponse();	
//				
//				List<Order> orders = new ArrayList<>();
//				
//				for(int i = 0; i < allOrder.size(); i++){
//					Order order = new Order();
//					order.setoId(allOrder.get(i).getoId());
//					order.setuEmail(allOrder.get(i).getuEmail());
//					order.setTax(allOrder.get(i).getTax());
//					order.setPaymentMethod(allOrder.get(i).getPaymentMethod());
//					order.setTotalPrice(allOrder.get(i).getTotalPrice());
//					order.setCreatedAt(allOrder.get(i).getCreatedAt());
//					List<ProductItem> products = new ArrayList<>();
//					for(int j = 0; j < allOrder.get(i).getOrderItems().size(); j++) {
//						ProductItem item = new ProductItem();
//						item.setOiId(allOrder.get(i).getOrderItems().get(j).getOiId());
//						item.setProduct(allOrder.get(i).getOrderItems().get(j).getProduct());
//						item.setpName(allOrder.get(i).getOrderItems().get(j).getpName());
//						item.setQty(allOrder.get(i).getOrderItems().get(j).getQty());
//						item.setpPricePerUnit(allOrder.get(i).getOrderItems().get(j).getpPricePerUnit());
//						item.setpImage(allOrder.get(i).getOrderItems().get(j).getpImage());
//						products.add(item);				
//					}
//					order.setOrderItems(products);
//					orders.add(order);
//				}
//				response.setOrders(orders);
//				responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
//			}else {
//				responseEntity = new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
//			}
//			
//		} catch (Exception e) {
//			log.error("No orders");
//		}		
//		return responseEntity;
//	}
//
//	@Override
//	public ResponseEntity<?> getAllOrdersByoId(Long oId) {
//		
//		ResponseEntity<?> responseEntity = null;
//		
//		try {
//			
//			List<ProductOrder> allOrder = productOrderRepository.findByoId(oId);
//			
//			if(!(allOrder.size() == 0)) {
//				GetAllOrderResponse response = new GetAllOrderResponse();	
//				
//				List<Order> orders = new ArrayList<>();
//				
//				for(int i = 0; i < allOrder.size(); i++){
//					Order order = new Order();
//					order.setoId(allOrder.get(i).getoId());
//					order.setuEmail(allOrder.get(i).getuEmail());
//					order.setTax(allOrder.get(i).getTax());
//					order.setPaymentMethod(allOrder.get(i).getPaymentMethod());
//					order.setTotalPrice(allOrder.get(i).getTotalPrice());
//					order.setCreatedAt(allOrder.get(i).getCreatedAt());
//					List<ProductItem> products = new ArrayList<>();
//					for(int j = 0; j < allOrder.get(i).getOrderItems().size(); j++) {
//						ProductItem item = new ProductItem();
//						item.setOiId(allOrder.get(i).getOrderItems().get(j).getOiId());
//						item.setProduct(allOrder.get(i).getOrderItems().get(j).getProduct());
//						item.setpName(allOrder.get(i).getOrderItems().get(j).getpName());
//						item.setQty(allOrder.get(i).getOrderItems().get(j).getQty());
//						item.setpPricePerUnit(allOrder.get(i).getOrderItems().get(j).getpPricePerUnit());
//						item.setpImage(allOrder.get(i).getOrderItems().get(j).getpImage());
//						products.add(item);				
//					}
//					order.setOrderItems(products);
//					orders.add(order);
//				}
//				response.setOrders(orders);
//				responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
//			}else {
//				responseEntity = new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
//			}
//			
//		} catch (Exception e) {
//			log.error("No orders");
//		}		
//		return responseEntity;
//	}

}

