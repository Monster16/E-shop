package com.shoppingcartsystem.model;

import java.math.BigDecimal;


public class Product {

	private Long pId;

	private String pName;
	
	private BigDecimal pPricePerUnit;
	
	private String pCategory;
	
	private String pImage;
	
	private Integer pQuantity;
	
	private String pDescription;

	
	
	
	
	public Product() {
		
	}

	public Product( String pName, BigDecimal pPricePerUnit, String pCategory, String pImage,
			Integer pQuantity, String pDescription) {

		this.pName = pName;
		this.pPricePerUnit = pPricePerUnit;
		this.pCategory = pCategory;
		this.pImage = pImage;
		this.pQuantity = pQuantity;
		this.pDescription = pDescription;
	}

	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public BigDecimal getpPricePerUnit() {
		return pPricePerUnit;
	}

	public void setpPricePerUnit(BigDecimal pPricePerUnit) {
		this.pPricePerUnit = pPricePerUnit;
	}

	public String getpCategory() {
		return pCategory;
	}

	public void setpCategory(String pCategory) {
		this.pCategory = pCategory;
	}

	public String getpImage() {
		return pImage;
	}

	public void setpImage(String pImage) {
		this.pImage = pImage;
	}

	public Integer getpQuantity() {
		return pQuantity;
	}

	public void setpQuantity(Integer pQuantity) {
		this.pQuantity = pQuantity;
	}

	public String getpDescription() {
		return pDescription;
	}

	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}
	
	
	
	
}