package com.IT.Stock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.IT.Stock.Model.Outward;

@Repository
public interface OutwardJpaRepository extends JpaRepository<Outward,Long>{
    
}
