package com.IT.Stock.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.IT.Stock.Model.Outward;
import com.IT.Stock.Service.OutwardJpaService;

@RestController
public class OutwardController {
    @Autowired
    private OutwardJpaService outwardJpaService;

    @GetMapping("stores/outward")
    public ArrayList<Outward> getAllOutwards(){
        return outwardJpaService.getAllOutwards();
    }

    @PostMapping("stores/outward")
    public ArrayList<Outward> addStockOutwardAndBalance(@RequestBody Outward outward){
        return outwardJpaService.addStockOutwardAndBalance(outward);
    }

    @GetMapping("stores/outward/recent")
    public ArrayList<Outward> getLast5Transactions(){
        return outwardJpaService.getLast5Transactions();
    }
    
}
