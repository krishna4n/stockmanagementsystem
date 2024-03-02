package com.IT.Stock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.IT.Stock.Model.Inward;

@Repository
public interface InwardJpaRepository extends JpaRepository<Inward,Long> {

    
    
}
