package com.IT.Stock.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.IT.Stock.Model.Vendor;
import com.IT.Stock.Service.VendorJpaService;

@RestController
public class VendorController {
    @Autowired
    private VendorJpaService vendorJpaService;

    @GetMapping("/vendor/master")
    public ArrayList<Vendor> getAllVendors(){
        return (ArrayList<Vendor>) vendorJpaService.getAllVendors();
    }

    @PostMapping("/vendor/master")
    public Vendor addVendor(@RequestBody Vendor vendor){
        return vendorJpaService.addVendor(vendor);
    }
}
