package com.jbk.Service;

import java.util.List;

import com.jbk.DAO.TestDao;
import com.jbk.Entity.Product;
import com.jbk.Utility.TestUtility;

public class ProductService {

	
	
	TestDao dao= new TestDao();
	
		public String saveProduct(Product product) {
						
				String msg = dao.saveProduct(product);

			return msg;
		}

		public String deleteProduct(int id) {
		
			String msg = dao.deleteProduct(id);
			return msg;
		}

		public String updateProduct(Product product) {
			
			String msg = dao.updateProduct(product);

			return msg;
		}

		public Product getProductById(int id) {
			

			Product product = dao.getProductById(id);
			return product;
		}

		public List<Product> productWithMaxPrice() {
			
			return  dao.productWithMaxPrice();
		}
		
		public List<Product> queryEx(){
			
			return  dao.queryEx();
		}

		public List<Product> queryEx1() {
			
			return  dao.queryEx1();
		}
		
		
		
}
