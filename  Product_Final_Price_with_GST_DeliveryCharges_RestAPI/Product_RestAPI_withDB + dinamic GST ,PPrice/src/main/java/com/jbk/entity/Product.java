package com.jbk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table//(name= "product table")   //to do mapping with table  ,,, if we do not pass the name , it will take default name as class name
public class Product {
	
	@Id
	@Column(unique =true ,nullable=false)
	private String productId;
	
	@Column(unique =true ,nullable=false)
	private String productName;
	
	//@OneToOne
	//@Column(unique =false ,nullable=false) no need to give annotation on one to one 
	//private Supplier supplierId;     as supplier is not a permeative data type its an class so we pass an object 
	
	@OneToOne
	private Supplier supplier;
	
	//@Column(unique =false ,nullable=false)
	@OneToOne
	private Category category;
	
	@Column(unique =false ,nullable=false)
	private int productQty;
	
	@Column(unique =false ,nullable=false)
	private double productPrice;
	
	
	public Product() {
		// TODO Auto-generated constructor stub
	}




	public Product(String productId, String productName, Supplier supplier, Category category, int productQty,
			double productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.supplier = supplier;
		this.category = category;
		this.productQty = productQty;
		this.productPrice = productPrice;
	}




	public String getProductId() {
		return productId;
	}




	public void setProductId(String productId) {
		this.productId = productId;
	}




	public String getProductName() {
		return productName;
	}




	public void setProductName(String productName) {
		this.productName = productName;
	}




	public Supplier getSupplier() {
		return supplier;
	}




	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}




	public Category getCategory() {
		return category;
	}




	public void setCategory(Category category) {
		this.category = category;
	}




	public int getProductQty() {
		return productQty;
	}




	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}




	public double getProductPrice() {
		return productPrice;
	}




	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}




	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", supplier=" + supplier
				+ ", category=" + category + ", productQty=" + productQty + ", productPrice=" + productPrice + "]";
	}




}
