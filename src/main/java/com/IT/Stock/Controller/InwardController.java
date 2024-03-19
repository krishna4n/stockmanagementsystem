package com.IT.Stock.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.IT.Stock.Model.Inward;
import com.IT.Stock.Model.Store;
import com.IT.Stock.Service.InwardJpaService;

@RestController
public class InwardController {
    @Autowired
    private InwardJpaService inwardJpaService;

    @GetMapping("stores/inward")
    public ArrayList<Inward> getAllInwards(){

        return inwardJpaService.getAllInwards();
    }

    @GetMapping("stores/last-ten-inwards")
    public ArrayList<Inward> getLastTenInwards(){
        return inwardJpaService.getLastTenInwards();
    }

    @PostMapping("stores/inward")
    public ArrayList<Inward> addInwardStoreAndBalance(@RequestBody Store store){
        return (ArrayList<Inward>) inwardJpaService.addInwardStoreAndBalance(store);
    }
}
