package com.IT.Stock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IT.Stock.Model.Scrap;

public interface ScrapJpaRepository extends JpaRepository<Scrap, Long>{
    
}
