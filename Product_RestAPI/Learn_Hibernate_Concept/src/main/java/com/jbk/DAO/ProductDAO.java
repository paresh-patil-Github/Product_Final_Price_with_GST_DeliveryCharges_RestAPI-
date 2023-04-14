package com.jbk.DAO;


import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jbk.Config.HibernateConfig;
import com.jbk.Entity.Product;

public class ProductDAO {

	SessionFactory sf= HibernateConfig.getSessionFactory();
	
	Scanner scanner =new Scanner(System.in);

		
		
	public String saveProduct(Product product) {
		System.out.println("please enter what you want");
		System.out.println("press 1 for save product");
		System.out.println("press 2 for delete product by id");
		System.out.println("press 3 for get single product");
		System.out.println("press 4 for get all product");
		Scanner scanner =new Scanner(System.in);
		int choice = scanner.nextInt();
		char ch;
		
		Session session =sf.openSession();
		
		String msg=null ;
		
		switch (choice) {
		case 1:
		{
			try {
				
				Transaction tr=session.beginTransaction();
				
				session.save(product);
				
				tr.commit();  //commit gets in partial commit and if there is any error  the process is aborted to save the data , if everything is right fully commit is done 
				
				msg="Data is Saved Succesfully";
				
				
			
			} catch (Exception e) {
				
		         e.printStackTrace();
		       
		         msg="Something Wrong while Data Saving !";
		      
			}
			finally {
				
				if(session!= null) {
					
					session.close();
					
				}
			}
			
		}break;
		

		default:{
			msg="please enter valid data ";
		}
			break;
		}
		return msg;
	}}
