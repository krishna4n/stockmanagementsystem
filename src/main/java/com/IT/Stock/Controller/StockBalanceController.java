package com.IT.Stock.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.IT.Stock.Model.StockBalance;
import com.IT.Stock.Service.StockBalanceService;

@RestController
public class StockBalanceController {
    @Autowired
    private StockBalanceService stockBalanceService;

    @GetMapping("/stock/balance")
    public ArrayList<StockBalance> getAllStockBalances(){
        return stockBalanceService.getAllStocks();
    }

    @PostMapping("/stock/balance")
    public StockBalance addStockBalance(@RequestBody StockBalance stockBalance){
        return stockBalanceService.addStockBalance(stockBalance);
    }
}
