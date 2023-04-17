package com.jbk.serviceImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.ProductDAO;
import com.jbk.entity.Product;
import com.jbk.model.Charges;
import com.jbk.model.FinalProduct;
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
		
		return dao.sortProductsByName_DESC();
	}

	@Override
	public List<Product> getMaxPriceProducts() {
		
		return dao.getMaxPriceProducts();
	}

	@Override
	public Double countSumOfProductPrice() {
		
		return dao.countSumOfProductPrice();
	}

	@Override
	public int getTotalCountOfProduct() {
		
		return dao.getTotalCountOfProduct();
	}
	
	@Override
	public FinalProduct getProductwithFinalPrice(String productId) {
		
		Product product = dao.getProductById(productId);
		
		Charges charges = new Charges(product.getCategory().getGst(),product.getCategory().getDeliveryCharges());
		
		double discountAmunt = product.getProductPrice() * (product.getCategory().getDiscount()/100);
		
		double gst = product.getProductPrice() * (charges.getGst()/100) ;
		
		double finalProductPrice = gst + charges.getDeliveryCharges() + product.getProductPrice() - discountAmunt ;
		
		FinalProduct finalProduct = new FinalProduct(product.getProductId(), product.getProductName(), product.getSupplier(), product.getCategory(), product.getProductQty(), product.getProductPrice(), charges, discountAmunt, finalProductPrice);
				
		return finalProduct;
		
	}
	

}
