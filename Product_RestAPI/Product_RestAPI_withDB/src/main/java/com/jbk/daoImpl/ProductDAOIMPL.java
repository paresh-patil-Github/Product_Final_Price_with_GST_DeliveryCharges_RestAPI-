package com.jbk.daoImpl;

import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.dao.ProductDAO;
import com.jbk.entity.Product;

@Repository
public class ProductDAOIMPL implements ProductDAO{

	@Autowired
	private SessionFactory sf;
	
	@Override
	public boolean saveProduct(Product product) {
		
		boolean isAdded = false;
		
		Session session= null;
		try {
			
			session = sf.openSession();
			
			Transaction tr = session.beginTransaction();
			
			session.save(product);
			
			tr.commit();
			
			isAdded=true;
			
		} catch (PersistenceException e) {
			//msg="Product not saved due to Duplicate Entry with id ="+ product.getProductId()+"and name ="+ product.getProductName();
		
			e.printStackTrace();
			
			 isAdded=false;
			 
		}catch(Exception e) {
			
			e.printStackTrace();
			//msg="something wrong while Data saving !!";
			
		}finally {
			if (session != null ) {
				
				session.close();
			}
		}
		
		return isAdded;
	}

	@Override
	public Product getProductById(String productid) {
		
		Product product = null;
		Session session=null;
		
		try {
			session =sf.openSession();
			
			product= session.get(Product.class, productid);
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			if(session != null) {
				
				session.close();
			}
		}
		
		return product;
	}

	@Override
	public List<Product> getAllProduct() {
		
		Session session = null;
		
		List<Product> list =null ;
		
		try {
			session =sf.openSession();
			
			Criteria criteria =session.createCriteria(Product.class);
			
			list =criteria.list();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			if(session != null) {
				
				session.close();
			}
		}
		
		
		return list;
	}

	@Override
	public boolean deletProductById(String productid) {
		
		Session session =null;
		
		boolean isDeleted =false;
		
		try {
			
			session =sf.openSession();
			
			Transaction tr = session.beginTransaction();
			
			Product product =getProductById(productid);  //this is the method we created above , here we are calling a method from method 
		
			if(product != null) {
				
				session.delete(product);
				
				tr.commit();
				
				isDeleted=true;
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			if(session != null) {
				session.close();
			}
		}
		return isDeleted;
	}

	@Override
	public boolean updateProduct(Product product) {
		Session session = null;
		boolean isUpdated=false;
		
		try {
			session =sf.openSession();
			
			Transaction tr= session.beginTransaction();
			
			Product dbProduct=getProductById(product.getProductId()); //here we will pass productid of  product from user to the getproductById method, this will give me the product from database matching to the id , if the no product it will give me null
			
			if(dbProduct !=null) {
			
			session.update(product);
			
			tr.commit();
			
			isUpdated= true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			if(session != null) {
				session.close();
			}
		}
		
		return isUpdated ;
	}

	@Override
	public List<Product> sortProductsById_ASC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> sortProductsByName_DESC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getMaxPriceProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double countSumOfProductPrice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getTotalCountOfProduct() {
		// TODO Auto-generated method stub
		return 0;
	}

}
