package com.supp.SupplierBackend;

import org.hibernate.Session;
import org.junit.BeforeClass;
import org.junit.Test;

import com.supp.SupplierBackend.Dao.SupplierDao;
import com.supp.SupplierBackend.DaoImpl.SupplierDaoImpl;
import com.supp.SupplierBackend.config.HibernateConfig;
import com.supp.SupplierBackend.model.Supplier;

public class TestDeleteSupplier {

	private static SupplierDao suppDao;
	private static HibernateConfig config;

	@BeforeClass
	public static void setUp() {
		suppDao = new SupplierDaoImpl();
		config = new HibernateConfig();
	}
	
	@Test
	public void testDeleteuSupplier(){
//		Session session = config.getSessionFactory(config.getH2DataSource()).openSession();
//		session.beginTransaction();
//		Supplier supplier = session.get(Supplier.class, 1);
		Supplier supplier = new Supplier();
		supplier.setSid(2);
		suppDao.deleteSupp(supplier);
	}

}
