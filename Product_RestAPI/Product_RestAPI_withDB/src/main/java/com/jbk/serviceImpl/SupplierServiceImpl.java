package com.jbk.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.SupplierDao;
//import java.util.List;
import com.jbk.entity.Supplier;
import com.jbk.service.SupplierService;


@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierDao supplierDao ;
	
	
	@Override
	public boolean saveSupplier(Supplier supplier) {
		
		return supplierDao.saveSupplier(supplier);
	}


	@Override
	public boolean updateSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		return supplierDao.updateSupplier( supplier);
	}
	

	@Override
	public boolean deletSupplierById(int supplierId) {
		// TODO Auto-generated method stub
		return supplierDao.deleteSupplier(supplierId);
	}
	/*
	@Override
	public Supplier getSupplierById(String supplierId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Supplier> getAllSuppliers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deletSupplierById(String supplierId) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public List<Supplier> sortSuppliersById_ASC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Supplier> sortSuppliersByName_DESC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Supplier getMaxPriceProductSupplier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getTotalCountOfSupplier() {
		// TODO Auto-generated method stub
		return 0;
	}

*/
}
