package com.IT.Stock.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.IT.Stock.Model.Inward;
import com.IT.Stock.Model.Store;
import com.IT.Stock.Service.StoreJpaService;


@RestController
public class StoreController {
    @Autowired
    private StoreJpaService storeJpaService;

    @GetMapping("stores")
    public ArrayList<Store> getAllArrayList(){
        return storeJpaService.getAllStores();
    }

    @PostMapping("stores")
    public ArrayList<Inward> addStoreAndInwardAndBalance(@RequestBody Store store){
        System.out.println("store save called");
        return storeJpaService.addStoreAndInwardAndBalance(store);
    }
}
