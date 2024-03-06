package com.IT.Stock.Repository;

import java.util.ArrayList;

import com.IT.Stock.Model.StockBalance;

public interface StockBalanceRepository {
    ArrayList<StockBalance> getAllStocks();
    StockBalance addStockBalance(StockBalance stockBalance);
    StockBalance getStockBalance(long stockBalanceId);
    StockBalance updateStockBalance(StockBalance stockBalance, long stockBalanceId);
    void deleteStockBalance(long stockBalanceId);
}
