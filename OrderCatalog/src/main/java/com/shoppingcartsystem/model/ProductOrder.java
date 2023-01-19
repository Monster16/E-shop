package com.shoppingcartsystem.model;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
//import java.util.Date;
import java.util.List;

//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToMany;
////import jakarta.persistence.PrePersist;
////import jakarta.persistence.PreUpdate;

import javax.persistence.*;



@Entity
@Table(name = "ORDER_TABLE")
public class ProductOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "oId")
	private Long oId;
	
	@Column(name = "USER_EMAIL")
	private String uEmail;
	
	@Column(name = "PAYMENT_METHOD")
	private String paymentMethod;
	
	@Column(name = "TAX")
	private BigDecimal tax;
	
	@Column(name = "TOTAL_ORDER_PRICE")
	private BigDecimal totalPrice;
	
	private Date createdAt;
	
//	private String orderStatus;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "order_o_id")
	private List<OrderItem> orderItems = new ArrayList<>();
	
	
//	private Date updatedAt;
	
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	public Long getoId() {
		return oId;
	}

	public void setoId(Long oId) {
		this.oId = oId;
	}

	public String getuEmail() {
		return uEmail;
	}

	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	
	
	
}