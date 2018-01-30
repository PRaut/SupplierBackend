package com.supp.SupplierBackend.DaoImpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.supp.SupplierBackend.Dao.SupplierDao;
import com.supp.SupplierBackend.config.HibernateConfig;
import com.supp.SupplierBackend.model.Supplier;

@Repository("supplierDao")
@Transactional
public class SupplierDaoImpl  implements SupplierDao{

	private HibernateConfig config;
	
	public boolean insertSupp(Supplier supplier) {
		config = new HibernateConfig();
		Session session = config.getSessionFactory(config.getH2DataSource()).openSession();
		session.beginTransaction();
		session.save(supplier);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	public void updateSupp(Supplier supplier) {
		config = new HibernateConfig();
		Session session = config.getSessionFactory(config.getH2DataSource()).openSession();
		session.beginTransaction();
		session.update(supplier);
		session.getTransaction().commit();
		session.close();
	}

	public void deleteSupp(Supplier supplier) {
		config = new HibernateConfig();
		Session session = config.getSessionFactory(config.getH2DataSource()).openSession();
		session.beginTransaction();
		session.delete(supplier);
		session.getTransaction().commit();
		session.close();
	}

}
