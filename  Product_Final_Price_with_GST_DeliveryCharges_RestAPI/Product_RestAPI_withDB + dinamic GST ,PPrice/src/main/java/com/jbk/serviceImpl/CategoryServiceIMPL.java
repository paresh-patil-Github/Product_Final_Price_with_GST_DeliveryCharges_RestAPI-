package com.jbk.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.CategoryDAO;
import com.jbk.entity.Category;
import com.jbk.service.CategoryService;

@Service
public class CategoryServiceIMPL implements CategoryService {

	@Autowired
	CategoryDAO categoryDao;
	
	@Override
	public boolean saveCategory(Category category) {
		
		return categoryDao.saveCategory( category);
	}
	

	@Override
	public Category getCategoryById(int CategoryId) {
		
		return categoryDao.getCategoryById(CategoryId);
	}

	@Override
	public boolean deletCategoryById(int CategoryId) {
		// TODO Auto-generated method stub
		return categoryDao.deleteCategoryById(CategoryId);
	}


	@Override
	public boolean updateCategory(Category Category) {
		// TODO Auto-generated method stub
		return categoryDao.updateCategory(Category);
	}
	
	/*

	@Override
	public List<Category> getAllCategories() {
		
		return null;
	}

	@Override
	public boolean deletCategoryById(String CategoryId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCategory(Category Category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Category> sortCategoriesById_ASC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> sortCategoriesByName_DESC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category getMaxPriceProductCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getTotalCountOfCategory() {
		// TODO Auto-generated method stub
		return 0;
	}

*/
}
