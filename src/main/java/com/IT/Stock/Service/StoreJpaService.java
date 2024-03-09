package com.IT.Stock.Service;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.IT.Stock.Model.Inward;
import com.IT.Stock.Model.StockBalance;
import com.IT.Stock.Model.Store;
import com.IT.Stock.Repository.InwardJpaRepository;
import com.IT.Stock.Repository.StockBalanceJpaRepository;
import com.IT.Stock.Repository.StoreJpaRepository;
import com.IT.Stock.Repository.StoreRepository;

@Service
public class StoreJpaService implements StoreRepository{

    @Autowired
    private StoreJpaRepository storeJpaRepository;

    @Autowired
    private InwardJpaRepository inwardJpaRepository;

    @Autowired
    private StockBalanceJpaRepository stockBalanceJpaRepository;

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
    public ArrayList<Inward> addStoreAndInwardAndBalance(Store store) {
        Store savedStoreItem = new Store();
        Inward newInward = new Inward();
        StockBalance newBalance = new StockBalance();
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

            StockBalance stockBalance = stockBalanceJpaRepository.findStockBalanceByItem(store.getItem());

            if(stockBalance == null){
                System.out.println("No stock with this item id");
                newBalance.setItem(store.getItem());
                newBalance.setQuantity(store.getQuantity());            
                stockBalanceJpaRepository.save(newBalance);
            }
            else{
                System.out.println("Stock exists with this itemid");
                long totalBalance = store.getQuantity() + stockBalance.getQuantity();
                System.out.println(store.getQuantity());
                System.out.println(stockBalance.getQuantity());
                System.out.println(store.getQuantity() + stockBalance.getQuantity());
                stockBalance.setQuantity(totalBalance);
                stockBalanceJpaRepository.save(stockBalance);
            }
           
            Store existingStoreItem = storeJpaRepository.findStoreBySerialNumber(store.getSerialNumber());
           

            
           if(existingStoreItem == null){

            savedStoreItem = storeJpaRepository.save(store);            

            newInward.setItem(store.getItem());
            newInward.setStore(savedStoreItem);
            inwardJpaRepository.save(newInward);            
        
        }
            else{     
                if(store.getItem().getItemType() == "EXPENSE"){
                    storeJpaRepository.save(store);
                }
                System.out.println(existingStoreItem.getCurrentStatus());
                System.out.println(store.getSerialNumber());
                if(existingStoreItem.getCurrentStatus().equals("IN") & !store.getSerialNumber().equals("") & store.getItem().getItemType().equals("ASSET")){
                    System.out.println("duplicate entry");
                    throw new ResponseStatusException(HttpStatus.FOUND, "This stock is already in Store");
                }

                newInward.setItem(store.getItem());
                newInward.setStore(existingStoreItem);
                inwardJpaRepository.save(newInward);
               
            }

          return (ArrayList<Inward>) inwardJpaRepository.findTop10Inward();

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

    @Override
    public Store addStore(Store store) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addStore'");
    }
    
}
