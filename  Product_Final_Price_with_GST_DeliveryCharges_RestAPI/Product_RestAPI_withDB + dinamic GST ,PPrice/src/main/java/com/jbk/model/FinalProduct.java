package com.jbk.model;

import com.jbk.entity.Category;
import com.jbk.entity.Supplier;

public class FinalProduct {

	
	private String productId;
	private String ProductName;
	private Supplier supplier;
	private Category Category;
	private int productQty;
	private double productPrice;
	private Charges charges;
	private double discountAmount;
	private double finalProductPrice;
	public FinalProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FinalProduct(String productId, String productName, Supplier supplier, com.jbk.entity.Category category,
			int productQty, double productPrice, Charges charges, double discountAmount, double finalProductPrice) {
		super();
		this.productId = productId;
		ProductName = productName;
		this.supplier = supplier;
		Category = category;
		this.productQty = productQty;
		this.productPrice = productPrice;
		this.charges = charges;
		this.discountAmount = discountAmount;
		this.finalProductPrice = finalProductPrice;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public Category getCategory() {
		return Category;
	}
	public void setCategory(Category category) {
		Category = category;
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
	public Charges getCharges() {
		return charges;
	}
	public void setCharges(Charges charges) {
		this.charges = charges;
	}
	public double getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}
	public double getFinalProductPrice() {
		return finalProductPrice;
	}
	public void setFinalProductPrice(double finalProductPrice) {
		this.finalProductPrice = finalProductPrice;
	}
	@Override
	public String toString() {
		return "FinalProduct [productId=" + productId + ", ProductName=" + ProductName + ", supplier=" + supplier
				+ ", Category=" + Category + ", productQty=" + productQty + ", productPrice=" + productPrice
				+ ", charges=" + charges + ", discountAmount=" + discountAmount + ", finalProductPrice="
				+ finalProductPrice + "]";
	}
	
	
	
	
}
