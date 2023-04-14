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

import com.jbk.entity.Category;
import com.jbk.service.CategoryService;

@RestController
@RequestMapping(value= "/Category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	
	@PostMapping(value="/save-Category")
	public ResponseEntity<Boolean> saveCategory(@RequestBody Category category){
		
		boolean isAdded=categoryService.saveCategory(category);
		
		if(isAdded) {
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping(value="/update-Category")
	public ResponseEntity<Boolean> updateProduct(@RequestBody Category category){
		
		boolean isUpdated=categoryService.updateCategory(category);
		
		if(isUpdated) {
			return new ResponseEntity<Boolean>(isUpdated , HttpStatus.OK);
		}
		else {
			
			return new ResponseEntity<Boolean>(isUpdated , HttpStatus.NOT_FOUND);
		}
	}
	

	@DeleteMapping(value="/delete-Category")
	public ResponseEntity<Boolean> deletCategoryById(int categoryId){
		
		boolean isDeleted=categoryService.deletCategoryById(categoryId);
		
		if(isDeleted) {
			return new ResponseEntity<Boolean>(isDeleted , HttpStatus.OK);
		
	}else {
		
		return new ResponseEntity<Boolean>(isDeleted , HttpStatus.NOT_FOUND);
	}
	}
	
	
}
