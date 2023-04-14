package com.jbk.Config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jbk.Entity.Product;

public class HibernateConfig {
	
	
public static SessionFactory getSessionFactory() {
	
	Configuration cfg= new Configuration();
	
	cfg.configure().addAnnotatedClass(Product.class); // if in a table there are multiple entities we use multiple AddAnotated class using . over exiting
	
	SessionFactory sf=cfg.buildSessionFactory();
	
	return sf;
}
	
}
