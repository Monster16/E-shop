package com.shoppingcartsystem.dto.request;



import java.math.BigDecimal;

public class OrderProductItem {
	
	private Long product;
	private String pName;
	private Long qty;
	private BigDecimal pPricePerUnit;
	private String pImage;
	
	
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
	
	
	
	
}