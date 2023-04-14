package com.jbk.service;

import java.util.List;

import com.jbk.entity.Product;
import com.jbk.entity.Supplier;

public interface SupplierService {


	public boolean saveSupplier(Supplier supplier);
	
	public boolean deletSupplierById(int supplierId);
	
	public boolean updateSupplier(Supplier supplier);
	
	//public Supplier getSupplierById(int supplierId);
	
	//public List<Supplier> getAllSuppliers();
	
	//public List<Supplier> sortSuppliersById_ASC();
	
//	public List<Supplier> sortSuppliersByName_DESC();
	
	//public Supplier getMaxPriceProductSupplier();
	
	//public Double countSumOfProductPrice();
	
	//public long getTotalCountOfSupplier();
	
	
}
