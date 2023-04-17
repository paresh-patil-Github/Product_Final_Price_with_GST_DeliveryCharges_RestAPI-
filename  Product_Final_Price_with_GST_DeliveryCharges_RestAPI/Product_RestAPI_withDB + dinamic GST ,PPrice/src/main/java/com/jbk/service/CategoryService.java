package com.jbk.service;

import java.util.List;

import com.jbk.entity.Category;


public interface CategoryService {

public boolean saveCategory(Category category);
	
	public Category getCategoryById(int CategoryId);

	public boolean deletCategoryById(int CategoryId);
	
	public boolean updateCategory(Category Category);
	
	/*
	
	public List<Category> getAllCategories();
	
	
	
	public List<Category> sortCategoriesById_ASC();
	
	public List<Category> sortCategoriesByName_DESC();
	
	public Category getMaxPriceProductCategory();
	
	//public Double countSumOfProductPrice();
	
	public long getTotalCountOfCategory();
	
	
	
	
	
	*/
}
