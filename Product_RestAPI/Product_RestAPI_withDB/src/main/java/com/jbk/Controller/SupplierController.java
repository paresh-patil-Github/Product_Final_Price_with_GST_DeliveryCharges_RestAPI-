package com.jbk.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.jbk.entity.Supplier;
import com.jbk.service.SupplierService;

@RestController
@RequestMapping(value="/supplier")
public class SupplierController {

	@Autowired
	SupplierService service ; 
	
	@PostMapping(value= "/save-Supplier")
	public ResponseEntity<Boolean> saveProduct(@RequestBody Supplier supplier) {
	
	boolean isAdded=service.saveSupplier(supplier);
		
		if(isAdded) { 
			
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.CREATED);
			
		} else {
			
			
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.CONFLICT); 
			
		}
		
	}
	
	@PutMapping(value="/update-Supplier")
	public ResponseEntity<Boolean> updateSupplier(Supplier supplier){
		
		boolean isUpdated = service.updateSupplier(supplier);
		
		
		if(isUpdated) {
			return new ResponseEntity<Boolean>(isUpdated , HttpStatus.OK);
		}
		else {
			
			return new ResponseEntity<Boolean>(isUpdated , HttpStatus.NOT_FOUND);
		}
	}
	

	@DeleteMapping(value="/delete-Supplier")
	public ResponseEntity<Boolean> deletSupplierById(int supplierId){
		
		boolean isDeleted=service.deletSupplierById(supplierId);
		
		if(isDeleted) {
			return new ResponseEntity<Boolean>(isDeleted , HttpStatus.OK);
		
	}else {
		
		return new ResponseEntity<Boolean>(isDeleted , HttpStatus.NOT_FOUND);
	}
	
}
}
