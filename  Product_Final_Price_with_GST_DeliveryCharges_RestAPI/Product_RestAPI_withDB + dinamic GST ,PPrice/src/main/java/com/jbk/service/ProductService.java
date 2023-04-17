package com.jbk.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jbk.entity.Product;
import com.jbk.model.FinalProduct;

@Component //this gives metadeta for creation of bin
public interface ProductService {

	
	public boolean saveProduct(Product product);
	
	public Product getProductById(String productid);
	
	public List<Product> getAllProduct();
	
	public boolean deletProductById(String productid);
	
	public boolean updateProduct(Product product);
	
	public List<Product> sortProductsById_ASC();
	
	public List<Product> sortProductsByName_DESC();
	
	public List<Product> getMaxPriceProducts();
	
	public Double countSumOfProductPrice();
	
	public int getTotalCountOfProduct();

	public FinalProduct getProductwithFinalPrice(String productId);
	
}
