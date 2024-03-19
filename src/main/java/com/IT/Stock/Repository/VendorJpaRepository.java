package com.IT.Stock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.IT.Stock.Model.Vendor;

@Repository
public interface VendorJpaRepository extends JpaRepository<Vendor,Long>{
    
}
