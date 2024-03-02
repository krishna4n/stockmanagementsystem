package com.IT.Stock.Service;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.IT.Stock.Model.Inward;
import com.IT.Stock.Model.Store;
import com.IT.Stock.Repository.InwardJpaRepository;
import com.IT.Stock.Repository.StoreJpaRepository;
import com.IT.Stock.Repository.StoreRepository;

@Service
public class StoreJpaService implements StoreRepository{

    @Autowired
    private StoreJpaRepository storeJpaRepository;

    @Autowired
    private InwardJpaRepository inwardJpaRepository;

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
    public Store addStore(Store store) {
        Store savedStoreItem = new Store();
        Inward newInward = new Inward();
            if(store.getSource() == "CENTRAL_OFFICE"){
            newInward.setCampusName(store.getSource());
            newInward.setCityName(store.getCityName());
            newInward.setDepartment(store.getDepartment());
            }
            else{
                newInward.setCampusName(store.getCampusName());
                newInward.setCityName(store.getCityName());
                newInward.setDepartment(store.getDepartment());
            }

        try{
           
            Store existingStoreItem = storeJpaRepository.findStoreBySerialNumber(store.getSerialNumber());
           

            
           if(existingStoreItem == null){

            savedStoreItem = storeJpaRepository.save(store);            

            newInward.setItem(store.getItem());
            newInward.setStore(savedStoreItem);
            inwardJpaRepository.save(newInward);            

            return savedStoreItem;
        
        }
            else{     
                System.out.println(existingStoreItem.getCurrentStatus());
                if(existingStoreItem.getCurrentStatus().equals("IN")){
                    System.out.println("duplicate entry");
                    throw new ResponseStatusException(HttpStatus.FOUND, "This stock is already in Store");
                }

                newInward.setItem(store.getItem());
                newInward.setStore(existingStoreItem);
                inwardJpaRepository.save(newInward);
                return existingStoreItem;
            }

        }
        catch(NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Store getStoreById(long storeId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStoreById'");
    }

    @Override
    public Store updaStore(Store store, long storeId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updaStore'");
    }

    @Override
    public Store deleteStore(long storeId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteStore'");
    }
    
}
