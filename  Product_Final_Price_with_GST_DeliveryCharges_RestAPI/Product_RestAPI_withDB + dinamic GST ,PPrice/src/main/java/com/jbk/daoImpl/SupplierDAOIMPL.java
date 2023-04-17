package com.jbk.daoImpl;

import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.dao.SupplierDao;
import com.jbk.entity.Supplier;

@Repository
public class SupplierDAOIMPL implements SupplierDao{
	
	@Autowired
	SessionFactory sf;
	
	@Override
	public boolean saveSupplier(Supplier supplier) {
		boolean isAdded = false;
		
		Session session = null;
		try {
			
			session = sf.openSession();
			
			Transaction tr = session.beginTransaction();
			
			session.save(supplier);
			
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
	public boolean deleteSupplier(int supplierId) {
		Session session =null;
		
		boolean isDeleted =false;
		
		try {
			
			session =sf.openSession();
			
			Transaction tr = session.beginTransaction();
			
			Supplier supplier = session.get(Supplier.class, supplierId); 
		
			if(supplier != null) {
				
				session.delete(supplier);
				
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

	
	
	
	public Supplier getSupplierById(int supplierId) {
		
		Supplier supplier = null;
		
		Session session=null;
		
		try {
			session =sf.openSession();
			
			supplier= session.get(Supplier.class, supplierId);
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			if(session != null) {
				
				session.close();
			}
		}
		
		return supplier;
	}
	
	@Override
	public boolean updateSupplier(Supplier supplier) {
		
		boolean isupdated = false;
		
		Session session = null;
		try {
			
			session = sf.openSession();
			
			Transaction tr = session.beginTransaction();
			
			session.update(supplier);
			
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
