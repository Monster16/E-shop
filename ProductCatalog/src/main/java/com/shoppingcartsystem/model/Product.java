package com.shoppingcartsystem.model;

import java.math.BigDecimal;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pId")
	private Long pId;
	
	@Column(name = "pName", nullable = false)
	private String pName;
	
	@Column(name = "pPricePerUnit", nullable = false)
	private BigDecimal pPricePerUnit;
	
	@Column(name = "pCategory", nullable = false)
	private String pCategory;
	
	@Column(name = "pImage", nullable = false)
	private String pImage;
	
	@Column(name = "pQuantity")
	private Integer pQuantity;
	
	@Column(name = "pDescription",columnDefinition = "Text")
	private String pDescription;

	
	
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product( String pName, BigDecimal pPricePerUnit, String pCategory, String pImage,
			Integer pQuantity, String pDescription) {
		super();
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