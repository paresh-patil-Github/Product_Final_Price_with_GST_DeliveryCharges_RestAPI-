package com.jbk.Utility;

import java.util.Scanner;

import com.jbk.Entity.Product;

public class TestUtility {

	
	
	public static Product prepareProductData() {
		
		Scanner sc= new Scanner(System.in);

		
		System.out.println("Enter ID");
		int productId=sc.nextInt();
		
		System.out.println("Enter Product name");
		String productname=sc.next();
		
		System.out.println("please enter supplier id");
		int supplierid=sc.nextInt();
	
		System.out.println("Enter Category ID");
		int categoryid=sc.nextInt();
	
	
		System.out.println("Enter QTY");
		int productQy=sc.nextInt();
		
		System.out.println("Enter price");
		double productPrice=sc.nextDouble();
		
		Product product = new Product(productId, productname, supplierid, categoryid, productQy, productPrice);
	
		return product;		
	
	
	}
}
