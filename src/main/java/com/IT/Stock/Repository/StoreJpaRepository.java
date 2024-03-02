package com.IT.Stock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IT.Stock.Model.Store;

public interface StoreJpaRepository extends JpaRepository<Store,Long> {
//@Query(value = "SELECT * FROM store s WHERE s.serialnumber = ?1", nativeQuery = true)
   Store findStoreBySerialNumber(String serialNumber);
}
