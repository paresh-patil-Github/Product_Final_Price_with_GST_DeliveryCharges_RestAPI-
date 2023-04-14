package com.jbk.DAO;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.jbk.Config.HibernateConfig;
import com.jbk.Entity.Product;



public class TestDao {

	
	//stage1 : get the session factoruy object
	
	SessionFactory sf=HibernateConfig.getSessionFactory();  	//class object can be created outside the method , it is similar as int a=10; 
																// sf is a variable and its type is SessionFactory

	
	
	String msg=null;
	
	public String saveProduct(Product product) {
	
		try {
			Session session=sf.openSession();
			
			Transaction	tr= session.beginTransaction();				//by default transaction.commit() is not auto save , it is set Autosave=False
																	//transaction state diagram must  be styudied , 1.partially commited >> after using tr.commit() >>2. it is in fully commit state
																	//but while commiting if there is an issue , then it dont become commited from Partially commited >>> it becomes failed and transaction is aborted 
																	// transaction is an Interface ,to create its object we need a implementation class OR method which returns Transaction
																	//this will happen in case of Eg. when we try to save primary key twice operation will be failed 
																	//Spring me iska Replacement aaya , tr.commit() karne ki jarurat nai .
			session.save(product);
			
			tr.commit();											//commit mtd return type =void , if commit fails it will throw some exception so we ude  try and catch
			 
			msg="data saved";
			
		} catch (Exception e) {
			e.printStackTrace();    //this shows exception
			msg="something wrong while saving data !!";
		}
		return msg;
	}


	public String deleteProduct(int id) {
		
		try {	
			Session session=sf.openSession();
			
			Transaction	tr= session.beginTransaction();	
			
			Product pd= new Product();
			
			pd.setProductId(id);										//for deleting the product first we have to set it then delete it
			
			session.delete(pd);
			
			tr.commit();
			
			msg="data deleted";
		
		} catch (Exception e) {
			e.printStackTrace();    //this shows exception
			msg="something wrong while deleting data !!";
		}
		return msg;
		
	}


	public String updateProduct(Product product) {
		
		try {
			Session session=sf.openSession();
			
			Transaction	tr= session.beginTransaction();	
			
			session.update(product);
			
			tr.commit();											//commit mtd return type =void , if commit fails it will throw some exception so we ude  try and catch
			 
			msg="data updated";
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			msg="something went wrong while updating";
		}
		
		return msg;
	}


	public Product getProductById(int productId) {
		Product pd=null;
		
		try {	
			//Transaction	tr= session.beginTransaction();											
			Session session=sf.openSession();
			
			 pd=session.get(Product.class, productId);
		
		} catch (Exception e) {
			e.printStackTrace();    //this shows exception
			msg="something wrong while deleting data !!";
		}
		return pd;
		
	}
	
	public List<Product> productWithMaxPrice() {
		
		Session session=null;
		
		double max=0;
		
		List<Product> list1=null;
		
		try {
			
			session=sf.openSession();
			
			Criteria criteria = session.createCriteria(Product.class);
			
			criteria.setProjection(Projections.max("productPrice"));
			
			List list=criteria.list();
			
			max=(Double)list.get(0);
			
			criteria.add(Restrictions.eq("productPrice", max)); 
			
			list1=criteria.list();
			
		} catch (Exception e) {
			  
			e.printStackTrace();
			
		}finally {
			
			if(session != null) {
				
				session.close();
			}
		}
		return list1;
	}
	
	
		
	public 	List<Product> queryEx(){
		
		Session session=null;
		List list=null;
		try {
	
			session=sf.openSession();
			
			Query query=session.createQuery("FROM Product");
			
			list=query.list();
		
		} catch (Exception e) {
			  
			e.printStackTrace();
			
		}finally {
			
			if(session != null) {
				
				session.close();
			}
		}
	
	return list;
	}


	public List<Product> queryEx1() {
		Session session=null;
		List list=null;
		
		//1. double price=10;
		try {
	
			session=sf.openSession();
			
			Query query=session.createQuery("FROM Product WHERE productPrice > 10");
			
			//Query query=session.createQuery("FROM p WHERE p.productPrice > 10"); also possible with alies, p is alies
			
			//1 .  //Query query=session.createQuery("FROM p WHERE p.productPrice >"+price); 
			
			//2.   //Query query=session.createQuery("FROM p WHERE p.productPrice > :xyz"); 
			       
			       //query.setParameter("xyz", price);
			
			//
			
			list=query.list();
		
		} catch (Exception e) {
			  
			e.printStackTrace();
			
		}finally {
			
			if(session != null) {
				
				session.close();
			}
		}
	
	return list;
	}
}
	
	
