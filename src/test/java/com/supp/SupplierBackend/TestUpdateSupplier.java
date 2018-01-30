package com.supp.SupplierBackend;

import org.hibernate.Session;
import org.junit.BeforeClass;
import org.junit.Test;

import com.supp.SupplierBackend.Dao.SupplierDao;
import com.supp.SupplierBackend.DaoImpl.SupplierDaoImpl;
import com.supp.SupplierBackend.config.HibernateConfig;
import com.supp.SupplierBackend.model.Supplier;

import static org.junit.Assert.*;

public class TestUpdateSupplier {
	
	private static SupplierDao suppDao;
	private static HibernateConfig config;
	
	@BeforeClass
	public static void setup(){
		suppDao = new SupplierDaoImpl();
		config =  new HibernateConfig();
	}
	
	@Test
	public void testUpdateSupp(){
//		Session session = config.getSessionFactory(config.getH2DataSource()).openSession();
//		session.beginTransaction();
//		
		//Supplier supplier = session.get(Supplier.class, 2);
		Supplier supplier = new Supplier();
		supplier.setSid(2);
		supplier.setSupplierName("Pritam");
		
		suppDao.updateSupp(supplier);
		
	}
}
