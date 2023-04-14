package com.jbk.Utility;

import java.util.Scanner;

import com.jbk.Entity.Product;

public class ProductUtility {
	
  public static void generateData() {
	  Scanner sc= new Scanner(System.in);
	  
	  System.out.println("enter product ID");
	  int productId = sc.nextInt();
	  
	 System.out.println("enter the product name ");
	 String productName= sc.next();
	 
	 System.out.println("enter the suplier id");
	 int supplierId=sc.nextInt();
	 
	 
	 System.out.println("enter Category id");
	 int categoryId =sc.nextInt();
	 
	 System.out.println("eter product quantity");
	 int productQty=sc.nextInt();
	 
	 System.out.println("enter the product price");
	 int productPrice=sc.nextInt();
	 
	 Product product= new Product(productId, productName, supplierId, categoryId, productQty, productPrice);
	
	 
	 sc.close();
  }
	
	
	
}
