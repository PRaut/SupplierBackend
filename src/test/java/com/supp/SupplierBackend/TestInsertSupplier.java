package com.supp.SupplierBackend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.supp.SupplierBackend.Dao.SupplierDao;
import com.supp.SupplierBackend.DaoImpl.SupplierDaoImpl;
import com.supp.SupplierBackend.model.Supplier;

public class TestInsertSupplier {

	private static SupplierDao suppDao;
	
	@BeforeClass
	public static void setup(){
		suppDao = new SupplierDaoImpl();
	}

	@Test
	public void testInsertSupp(){
		Supplier supplier = new Supplier();
		supplier.setSupplierName("Supp1");
		
		assertTrue(suppDao.insertSupp(supplier));
	}
}
