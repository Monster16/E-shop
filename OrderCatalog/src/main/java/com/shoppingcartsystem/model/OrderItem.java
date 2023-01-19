package com.shoppingcartsystem.model;



import java.math.BigDecimal;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "ORDER_ITEM")
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDER_ITEM_ID")
	private Long oiId;
	
	@Column(name = "PRODUCT_ID")
	private Long product;
	
	@Column(name = "PRODUCT_NAME")
	private String pName;
	
	@Column(name = "PRODUCT_QTY")
	private Long qty;
	
	@Column(name = "PRODUCT_PRICEPERUNIT")
	private BigDecimal pPricePerUnit;
	
	@Column(name = "PRODUCT_IMAGE")
	private String pImage;
	
	@JsonIgnore
	@ManyToOne
	private ProductOrder order;

	public Long getOiId() {
		return oiId;
	}

	public void setOiId(Long oiId) {
		this.oiId = oiId;
	}

	public Long getProduct() {
		return product;
	}

	public void setProduct(Long product) {
		this.product = product;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public Long getQty() {
		return qty;
	}

	public void setQty(Long qty) {
		this.qty = qty;
	}

	public BigDecimal getpPricePerUnit() {
		return pPricePerUnit;
	}

	public void setpPricePerUnit(BigDecimal pPricePerUnit) {
		this.pPricePerUnit = pPricePerUnit;
	}

	public String getpImage() {
		return pImage;
	}

	public void setpImage(String pImage) {
		this.pImage = pImage;
	}

	public ProductOrder getOrder() {
		return order;
	}

	public void setOrder(ProductOrder order) {
		this.order = order;
	}

	public OrderItem(Long product, String pName, Long qty, BigDecimal pPricePerUnit, String pImage,
			ProductOrder order) {
		super();
		this.product = product;
		this.pName = pName;
		this.qty = qty;
		this.pPricePerUnit = pPricePerUnit;
		this.pImage = pImage;
		this.order = order;
	}

	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}