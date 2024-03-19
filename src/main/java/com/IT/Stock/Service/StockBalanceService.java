package com.IT.Stock.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.IT.Stock.Model.Inward;
import com.IT.Stock.Model.StockBalance;
import com.IT.Stock.Repository.StockBalanceJpaRepository;
import com.IT.Stock.Repository.StockBalanceRepository;

@Service
public class StockBalanceService implements StockBalanceRepository{

    @Autowired
    private StockBalanceJpaRepository stockBalanceJpaRepository;

    @Override
    public ArrayList<StockBalance> getAllStocks() {
       try{
        return (ArrayList<StockBalance>) stockBalanceJpaRepository.findAll();
       }
       catch(Exception e){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
       }
    }

    @SuppressWarnings("null")
    @Override
    public StockBalance addStockBalance(StockBalance stockBalance) {
        try{
            return stockBalanceJpaRepository.save(stockBalance);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public StockBalance getStockBalance(long stockBalanceId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStockBalance'");
    }

    @Override
    public StockBalance updateStockBalance(StockBalance stockBalance, long stockBalanceId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateStockBalance'");
    }

    @Override
    public void deleteStockBalance(long stockBalanceId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteStockBalance'");
    }


    public void updateQuantity(Inward inward, StockBalance existingStockBalance) {
       try{
        long quantity = inward.getQuantity() + existingStockBalance.getQuantity();
            existingStockBalance.setQuantity(quantity);
            stockBalanceJpaRepository.save(existingStockBalance);
       }
       catch(Exception e){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
       }
    }
    
}
