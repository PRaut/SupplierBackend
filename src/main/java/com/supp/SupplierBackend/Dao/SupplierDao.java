package com.supp.SupplierBackend.Dao;

import com.supp.SupplierBackend.model.*;

public interface SupplierDao {
	boolean insertSupp(Supplier supplier);

	void updateSupp(Supplier supplier);

	void deleteSupp(Supplier supplier);
}
