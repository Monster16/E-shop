package com.shoppingcartsystem.dto.response;



import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Order {

	private Long oId;
	private String uEmail;
	private BigDecimal totalPrice;
	private BigDecimal tax;
	private String paymentMethod;
	List<ProductItem> orderItems;
	private Date createdAt;
	
	
	
	
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
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
	public Long getoId() {
		return oId;
	}
	public void setoId(Long oId) {
		this.oId = oId;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public List<ProductItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<ProductItem> orderItems) {
		this.orderItems = orderItems;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	
	
	
}
