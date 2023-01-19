package com.shoppingcartsystem.dto.request;


import java.math.BigDecimal;
import java.util.List;




public class CreateOrderRequest {
	
	private String uEmail;
	private BigDecimal totalPrice;
	private BigDecimal tax;
	private String paymentMethod;
	private List<OrderProductItem> orderItems;
	
	
	public BigDecimal getTax() {
		return tax;
	}
	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public List<OrderProductItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderProductItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	
	
	
}
