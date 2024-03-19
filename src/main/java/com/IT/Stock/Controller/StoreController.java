package com.IT.Stock.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/stores/warranty")
    public ArrayList<Store> getWarrantyDetails(){
        return storeJpaService.getWarrantyDetails();
    }

    @GetMapping("/stores/currentWorkingItems")
    public ArrayList<Store> getStoresWorkingDetails(){
        return storeJpaService.getStoresByCurrentStatusAndWorkingStatus("IN","WORKING");
    }

    @GetMapping("/stores/currentNotworkingItems")
    public ArrayList<Store> getStoreNotWorkingDetails(){
        return storeJpaService.getStoresByCurrentStatusAndWorkingStatus("IN", "NOT_WORKING");
    }

}
