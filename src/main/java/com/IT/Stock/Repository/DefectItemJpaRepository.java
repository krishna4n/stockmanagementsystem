package com.IT.Stock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.IT.Stock.Model.DefectItemService;

@Repository
public interface DefectItemJpaRepository extends JpaRepository<DefectItemService, Long>{
    
}
