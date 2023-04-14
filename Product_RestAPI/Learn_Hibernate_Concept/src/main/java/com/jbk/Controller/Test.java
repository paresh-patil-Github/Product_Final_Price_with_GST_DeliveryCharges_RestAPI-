package com.jbk.Controller;

import java.util.List;
import java.util.Scanner;

import com.jbk.Entity.Product;
import com.jbk.Service.ProductService;
import com.jbk.Utility.TestUtility;

public class Test {

	
	public static void main(String[] args) {
		
		char ch;
		
		String msg=null;
		
		Scanner sc = new Scanner(System.in);
		
		ProductService ps= new ProductService();
		
		do {
			
		System.out.println("Enter 1 to save the data ");
		
		System.out.println("Enter 2 to delete data");
		
		System.out.println("Enter 3 to update data");
		
		System.out.println("Enter 4 to get data");
	
		System.out.println("Enter 8 for MaxPrice Product , Projection + Restriction Example");
		
		System.out.println("Enter 9 for Query Example");
		
		
		int choice =sc.nextInt();
		
		
		
		switch (choice) {
		
		case 1:{

//			Product product = new Product(2, "pensil", 1, 1, 10, 10); now we are interested to take data from user to make mtd in utility class
			 
			Product product=TestUtility.prepareProductData();
			
			msg=ps.saveProduct(product);
		
			System.out.println(msg);
			
			break;
		}

		case 2:{
			System.out.println("Enter product id which is to be deleted");
			
			int id=sc.nextInt();
			
			msg=ps.deleteProduct(id);
			
			System.out.println(msg);
			
			break;
		}
			
		case 3:{
			
			Product product=TestUtility.prepareProductData();
			
			msg=ps.updateProduct(product);
			
			System.out.println(msg);

			break;
		}
		
		case 4:{
			
			System.out.println("Enter product id ");
			
			int id=sc.nextInt();
			
			Product prod=ps.getProductById(id);
			
			System.out.println(prod);

			break;
		}
			
		case 8:{	
			
			List<Product> list=ps.productWithMaxPrice();
			
			for (Product product : list) {
				
				System.out.println(product);
			}
		}
		case 9:{
			List<Product> queryEx=ps.queryEx();
			
			for (Product product : queryEx) {
				System.out.println(product);
			}
			
		}
		
		case 10:{
			List<Product> queryEx=ps.queryEx1();
			
			for (Product product : queryEx) {
				System.out.println(product);
			}
			
		}
		default: 
			
			System.out.println("please enter the valid option");
			break;
		}
		

		System.out.println("do you want to continue ? type y or type n");
		
		ch= sc.next().charAt(0);
		
	} while (ch=='Y' || ch=='y');
		
		System.out.println("Application is terminated");
	}
	
	
	
}
