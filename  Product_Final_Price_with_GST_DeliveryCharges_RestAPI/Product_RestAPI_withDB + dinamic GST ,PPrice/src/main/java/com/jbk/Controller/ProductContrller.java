package com.jbk.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entity.Product;
import com.jbk.model.FinalProduct;
import com.jbk.service.ProductService;



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
	
	@GetMapping(value="/get-Product-By-Id/{productid}")
	public ResponseEntity<Product> getProductById(@PathVariable String productid){
		
		Product product=service.getProductById(productid);
		
		if(product!= null) { 
			
		return new ResponseEntity<Product>(product, HttpStatus.OK);     //to pass only body to frontend use ==>> return ResponseEntity.ok(product)
		
		}else {
			
			return new  ResponseEntity<Product>(HttpStatus.NO_CONTENT);  // NO_CONTENT means Api is working but there is no content to return  , here we dont have any thing to return so we don't pass the object 
		}
	}
	
	@GetMapping(value="/get-all-Products")
	public ResponseEntity<List<Product>> getAllProduct(){
		
		List<Product> list =service.getAllProduct();
		
		if(list.isEmpty()) {
			
			 return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
			 
		} else {
			
			 return new ResponseEntity<List<Product>>(list,HttpStatus.OK);
		}
	}
	
	@DeleteMapping(value="/delete-Product-By-Id")
	public ResponseEntity<Boolean> deletProductById(@RequestParam String productId){
		
		boolean isDeleted=service.deletProductById(productId);
		
		if(isDeleted) {
		
		 return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK) ;
		 
		} else {
		
			 return new ResponseEntity<Boolean>(isDeleted, HttpStatus.NO_CONTENT);	
		}
	}
	
	@PutMapping(value="/update-Product")
	public ResponseEntity<Boolean> updateProduct(@RequestBody Product product){
		
		boolean isUpdated = service.updateProduct(product);
		
		if(isUpdated) {
			
		return  new ResponseEntity<Boolean>(isUpdated, HttpStatus.OK) ;
		
		} else {
			
			return  new ResponseEntity<Boolean>(isUpdated, HttpStatus.NO_CONTENT) ;
		}
	}
	
	@GetMapping(value="/sort-Products-By-Id_ASC")
	public ResponseEntity<List<Product>> sortProductsById_ASC(){
		
		List<Product> list= service.sortProductsById_ASC();
		
		if(list.isEmpty()) {
			
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		
		}	 else {
			
			 return new ResponseEntity<List<Product>>(list,HttpStatus.OK);
		}
		
	}
	
	@GetMapping(value="/sort-Products-By-Name_DESC")
	public ResponseEntity<List<Product>> sortProductsByName_DESC(){
		
		List<Product> list= service.sortProductsByName_DESC();
		
		if(list.isEmpty()) {
			
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		
		}	 else {
			
			 return new ResponseEntity<List<Product>>(list,HttpStatus.OK);
		}
		
	}
	
	@GetMapping(value="/get-max-pricep-roducts")
	public ResponseEntity<List<Product>> getMaxPriceProducts(){
		
		List<Product> list= service.getMaxPriceProducts();
		
		if(list.isEmpty()) {
			
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		
		}	 else {
			
			 return new ResponseEntity<List<Product>>(list,HttpStatus.OK);
		}
		
		
	}
	
	@GetMapping(value="/get-count-Sum-Of-Product-Price")
	public ResponseEntity<Double> countSumOfProductPrice(){
		
		double sumOfProductPrice=service.countSumOfProductPrice();
		
		if(sumOfProductPrice > 0) {
			
			return new ResponseEntity<Double>(sumOfProductPrice,HttpStatus.OK);
		
		}else {
			
			return new ResponseEntity<Double>(sumOfProductPrice,HttpStatus.NO_CONTENT);
		}
		
	}
	
	@GetMapping(value="/get-Total-Count-Of-Product")
	public ResponseEntity<Integer> getTotalCountOfProduct(){
		
		int totalCountOfProduct =service.getTotalCountOfProduct();
		
		if(totalCountOfProduct > 0) {
			
			return new ResponseEntity<Integer>(totalCountOfProduct,HttpStatus.OK);
			
		}else {
			
			return new ResponseEntity<Integer>(totalCountOfProduct,HttpStatus.NO_CONTENT);
		}
		
	}
		@GetMapping(value="/get-Product-with-Final-Price")
	public	ResponseEntity<FinalProduct> getProductwithFinalPrice(@RequestParam String productId) {
			
			FinalProduct finalProduct̵=service.getProductwithFinalPrice(productId);

		if(finalProduct̵!= null) { 
				
				return new ResponseEntity<FinalProduct>(finalProduct̵, HttpStatus.OK);     
				
		}else {
					
				return new  ResponseEntity<FinalProduct>(finalProduct̵,HttpStatus.NO_CONTENT);  
			}
			
		}
	
	




}
