package com.shoppingcartsystem.dto.response;

import java.util.List;

public class GetAllOrderResponse {
	
	private List<Order> orders;

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	

}
