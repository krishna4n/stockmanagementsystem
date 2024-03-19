package com.IT.Stock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.IT.Stock.Model.Item;
import com.IT.Stock.Model.StockBalance;

@Repository
public interface StockBalanceJpaRepository extends JpaRepository<StockBalance, Long> {
    StockBalance findByItemAndWorkingStatus(Item item,String workingStatus);
    
}
