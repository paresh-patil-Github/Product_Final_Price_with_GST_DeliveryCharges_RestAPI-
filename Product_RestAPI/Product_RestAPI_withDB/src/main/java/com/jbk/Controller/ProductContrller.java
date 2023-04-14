package com.jbk.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entity.Product;
import com.jbk.service.ProductService;
import com.jbk.serviceImpl.ProductServiceIMPL;


@RestController
@RequestMapping(value="/product")
public class ProductContrller {

	
	//ProductService service = new ProductServiceIMPL();  -->> this is the tight coupling , in which new memory allocation is done every time the object is  created ,and if you make any changes in class variables(constructor) this will affect the calling constructer here 

	@Autowired
	ProductService service ;   //-->> this is a loose coupling, it provides the metat deta to the container and gives the stored object of bin in container 
	
	@PostMapping(value= "/save-Product")
	public ResponseEntity<Boolean> saveProduct(@RequestBody Product product) {
	
	boolean isAdded=service.saveProduct(product);
		
		if(isAdded) { 
			
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.CREATED);
			
		} else {
			
			//throw custome exception( ResourceAlredyExistException(String (msg))
			
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.CONFLICT); 
			
			//HTTP 409 error status: The HTTP 409 status code (Conflict) indicates that the request could not be processed because of conflict in the request, such as the requested resource is not in the expected state, or the result of processing the request would create a conflict within the resource.
		}
		
	}
	
	@GetMapping(value="/get-Product-By-Id")
	public ResponseEntity<Product> getProductById(String productid){
		Product product=service.getProductById(productid);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
		
	}
	
	@GetMapping(value="/get-all-Products")
	public ResponseEntity<List<Product>> getAllProduct(){
		
		List<Product> list =service.getAllProduct();
		
		 return new ResponseEntity<List<Product>>(list,HttpStatus.OK);
		
	}
	
	@DeleteMapping(value="/delete-Product")
	public ResponseEntity<Boolean> deletProductById(String productid){
		
		boolean isDeleted=service.deletProductById(productid);
		
		 return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK) ;
		
	}
	
	@PutMapping(value="/update-Product")
	public ResponseEntity<Boolean> updateProduct(Product product){
		
		boolean isUpdated = service.updateProduct(product);
		
		return  new ResponseEntity<Boolean>(isUpdated, HttpStatus.OK) ;
		
	}
	
	public List<Product> sortProductsById_ASC(){
		return null;
		
	}
	
	public List<Product> sortProductsByName_DESC(){
		return null;
		
	}
	
	public Product getMacPriceProducts(){
		return null;
		
	}
	
	public Double countSumOfProductPrice(){
		return null;
		
	}
	
	public long getTotalCountOfProduct(){
		return 0;
		
	}
	




}
