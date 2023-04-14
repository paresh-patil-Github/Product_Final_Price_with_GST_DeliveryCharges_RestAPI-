package com.jbk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Supplier {

	@Id
	@Column(unique =true ,nullable=false)
	private int supplierId;
	
	@Column(unique =true ,nullable=false)
	private String supplierName;
	
	@Column(unique =false ,nullable=false)
	private String City;
	
	@Column(unique =false ,nullable=false)
	private int postalCode; 
	
	@Column(unique =false ,nullable=false)
	private String country;
	
	@Column(unique =true ,nullable=false)
	private String mobile;

	@Override
	public String toString() {
		return "Supplier [supplierId=" + supplierId + ", supplierName=" + supplierName + ", City=" + City
				+ ", postalCode=" + postalCode + ", country=" + country + ", mobile=" + mobile + "]";
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Supplier(int supplierId, String supplierName, String city, int postalCode, String country, String mobile) {
		super();
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		City = city;
		this.postalCode = postalCode;
		this.country = country;
		this.mobile = mobile;
	}

	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
