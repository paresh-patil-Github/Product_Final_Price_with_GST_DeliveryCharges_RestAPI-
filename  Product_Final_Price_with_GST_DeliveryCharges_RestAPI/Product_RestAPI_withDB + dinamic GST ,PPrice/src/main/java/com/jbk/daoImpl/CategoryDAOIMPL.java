package com.jbk.daoImpl;
import javax.persistence.PersistenceException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.dao.CategoryDAO;
import com.jbk.entity.Category;


@Repository
public class CategoryDAOIMPL implements CategoryDAO{

	
	@Autowired
	SessionFactory sf;
	
	
	@Override
	public boolean saveCategory(Category category) {
		
		boolean isAdded = false;
		
		Session session = null;
		try {
			
			session = sf.openSession();
			
			Transaction tr = session.beginTransaction();
			
			session.save(category);
			
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
	public Category getCategoryById(int categoryId) {
		
		Category category = null;
		Session session=null;
		
		try {
			session =sf.openSession();
			
			category= session.get(Category.class, categoryId);
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			if(session != null) {
				
				session.close();
			}
		}
		
		return category;
	}
	
	@Override
	public boolean deleteCategoryById(int categoryId) {
		
		Session session =null;
		
		boolean isDeleted =false;
		
		try {
			
			session =sf.openSession();
			
			Transaction tr = session.beginTransaction();
			
			Category category =session.get(Category.class,categoryId);  //this is the method we created above , here we are calling a method from method 
		
			if(category != null) {
				
				session.delete(category);
				
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
	public boolean updateCategory(Category category) {
		
		boolean isupdated = false;
		
		Session session = null;
		try {
			
			session = sf.openSession();
			
			Transaction tr = session.beginTransaction();
			
			session.update(category);
			
			tr.commit();
			
			isupdated=true;
			
		} catch (PersistenceException e) {
			//msg="Product not saved due to Duplicate Entry with id ="+ product.getProductId()+"and name ="+ product.getProductName();
		
			e.printStackTrace();
			
			isupdated=false;
			 
		}catch(Exception e) {
			
			e.printStackTrace();
			//msg="something wrong while Data saving !!";
			
		}finally {
			if (session != null ) {
				
				session.close();
			}
		}
		
		return isupdated;
	}

}
