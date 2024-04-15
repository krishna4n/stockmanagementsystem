package com.IT.Stock.Service;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.IT.Stock.Model.Outward;
import com.IT.Stock.Model.Store;

import com.IT.Stock.Repository.StoreJpaRepository;
import com.IT.Stock.Repository.StoreRepository;

@Service
public class StoreJpaService implements StoreRepository{

    @Autowired
    private StoreJpaRepository storeJpaRepository;

    @Override
    public ArrayList<Store> getAllStores() {
    try{
        return (ArrayList<Store>) storeJpaRepository.findAll();
    }
    catch(Exception e){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }    
    }

    @Override
    public Store getStoreBySerialNumber(String serialNumber) {
       try{
        return storeJpaRepository.findStoreBySerialNumber(serialNumber);
       }
       catch(Exception e){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
       }
    }

    @Override
    public Store deleteStore(long storeId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteStore'");
    }

    @SuppressWarnings("null")
    @Override
    public Store addStore(Store store) {
        try{
            return storeJpaRepository.save(store);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ArrayList<Store> getWarrantyDetails() {
        try{
            return (ArrayList<Store>) storeJpaRepository.getWarrantyDetails();
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Store updateStoreItemStatus(Store store, Store existingStoreItem) {
       try{
        long quantity = existingStoreItem.getQuantity() + store.getQuantity();
        existingStoreItem.setWorkingStatus(store.getWorkingStatus());
        if(store.getItem().getItemType() != "EXPENSE"){
        existingStoreItem.setQuantity(quantity);
        existingStoreItem.setCurrentLocation(store.getCurrentLocation());
        existingStoreItem.setCurrentStatus(store.getCurrentStatus());
        }
        return storeJpaRepository.save(existingStoreItem);
       }
       catch(Exception e){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
       }
    }

    @Override
    public Store updateStoreItemOutward(Outward outward, long storeId) {
        try{
            Store existingStoreItem = storeJpaRepository.findById(storeId).get();
            existingStoreItem.setCurrentStatus("OUT");
            existingStoreItem.setCurrentLocation(outward.getToCampus());
            return storeJpaRepository.save(existingStoreItem);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }



    @Override
    public ArrayList<Store> getStoresByCurrentStatusAndWorkingStatus(String currentStatus, String workingStatus) {
        try{
            return (ArrayList<Store>) storeJpaRepository.getStoresByCurrentStatusAndWorkingStatus(currentStatus, workingStatus);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    @Override
    public Store updateStoreItemDefectStatus(Outward outward) {
    try{
        Store existingStoreItem = storeJpaRepository.findStoreBySerialNumber(outward.getFaultySerialNumber());
        if(existingStoreItem != null){
            existingStoreItem.setCurrentStatus("SERVICE");
            return storeJpaRepository.save(existingStoreItem);
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    catch(NoSuchElementException e){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }    
    }
    
}
