package com.jbk.serviceImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.ProductDAO;
import com.jbk.entity.Product;
import com.jbk.service.ProductService;

@Service
public class ProductServiceIMPL implements ProductService{

	@Autowired
	private ProductDAO dao;         //we made this private so that its access is limited to theis class only it will not go out
	
	@Override
	public boolean saveProduct(Product product) {
		
		//id must be 17 digit  //SSS means nano sec
		String productId =DateTimeFormatter.ofPattern("yyMMddHHmmssSSS").format(LocalDateTime.now());
		
		product.setProductId(productId);			//the product came in the argument do not have an productId , using method we will add the id to the object
		
		boolean isAdded=dao.saveProduct(product);
		
		return isAdded;
	}

	@Override
	public Product getProductById(String productid) {
		
		Product product=dao.getProductById(productid);
		return product;
	}

	@Override
	public List<Product> getAllProduct() {
		
		return dao.getAllProduct();
	}

	@Override
	public boolean deletProductById(String productid) {
		
		return dao.deletProductById(productid);
	}

	@Override
	public boolean updateProduct(Product product) {
		
		return dao.updateProduct(product);
	}

	@Override
	public List<Product> sortProductsById_ASC() {
	
		return dao.sortProductsById_ASC();
	}

	@Override
	public List<Product> sortProductsByName_DESC() {
		// TODO Auto-generated method stub
		return dao.sortProductsByName_DESC();
	}

	@Override
	public Product getMaxPriceProducts() {
		// TODO Auto-generated method stub
		return dao.getMaxPriceProducts();
	}

	@Override
	public Double countSumOfProductPrice() {
		// TODO Auto-generated method stub
		return dao.countSumOfProductPrice();
	}

	@Override
	public long getTotalCountOfProduct() {
		// TODO Auto-generated method stub
		return dao.getTotalCountOfProduct();
	}

}
