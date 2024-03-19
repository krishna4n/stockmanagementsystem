package com.IT.Stock.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.IT.Stock.Model.Vendor;
import com.IT.Stock.Repository.VendorJpaRepository;
import com.IT.Stock.Repository.VendorRepository;

@Service
public class VendorJpaService implements VendorRepository {
    
    @Autowired
    private VendorJpaRepository vendorJpaRepository;

    @Override
    public ArrayList<Vendor> getAllVendors() {
    try{
        return (ArrayList<Vendor>) vendorJpaRepository.findAll();
    }
    catch(Exception e){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    } 
    }

    @SuppressWarnings("null")
    @Override
    public Vendor addVendor(Vendor vendor) {
        try{
            return vendorJpaRepository.save(vendor);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
