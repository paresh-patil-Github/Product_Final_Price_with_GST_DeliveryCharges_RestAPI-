package com.jbk.dao;

import java.util.List;

import com.jbk.entity.Product;

public interface ProductDAO {

	public boolean saveProduct(Product product);
	
	public Product getProductById(String productid);
	
	public List<Product> getAllProduct();
	
	public boolean deletProductById(String productid);
	
	public boolean updateProduct(Product product);
	
	public List<Product> sortProductsById_ASC();
	
	public List<Product> sortProductsByName_DESC();
	
	public Product getMaxPriceProducts();
	
	public Double countSumOfProductPrice();
	
	public long getTotalCountOfProduct();
	

}
