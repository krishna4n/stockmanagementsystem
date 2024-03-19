package com.IT.Stock.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.IT.Stock.Model.Store;

@Repository
public interface StoreJpaRepository extends JpaRepository<Store,Long> {
//@Query(value = "SELECT * FROM store s WHERE s.serialnumber = ?1", nativeQuery = true)
   Store findStoreBySerialNumber(String serialNumber);
   
   @Query(value = "select * from store where currentstatus = 'IN' and warrantytype in ('ON-SITE','OFF-SITE') order by warrantyenddate asc", nativeQuery = true)
   List<Store> getWarrantyDetails();

   List<Store> getStoresByCurrentStatusAndWorkingStatus(String currentStatus,String workingStatus);
}
