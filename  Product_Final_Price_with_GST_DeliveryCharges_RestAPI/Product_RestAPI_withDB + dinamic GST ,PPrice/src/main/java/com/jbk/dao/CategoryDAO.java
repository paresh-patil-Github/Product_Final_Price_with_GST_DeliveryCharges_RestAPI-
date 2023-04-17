package com.jbk.dao;

import com.jbk.entity.Category;



public interface CategoryDAO {

	public boolean saveCategory( Category  category);
	
	public boolean deleteCategoryById( int  categoryId);
	
	public boolean updateCategory( Category  category);

	public Category getCategoryById(int categoryId);
}
