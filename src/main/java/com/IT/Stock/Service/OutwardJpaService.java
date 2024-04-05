package com.IT.Stock.Service;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.IT.Stock.Model.*;
import com.IT.Stock.Repository.OutwardJpaRepository;
import com.IT.Stock.Repository.OutwardRepository;
import com.IT.Stock.Repository.StockBalanceJpaRepository;

@Service
public class OutwardJpaService implements OutwardRepository{

    @Autowired
    private OutwardJpaRepository outwardJpaRepository;

    @Autowired
    private StoreJpaService storeJpaService;

    @Autowired
    private StockBalanceJpaRepository stockBalancerRepository;

    @Autowired
    private StockBalanceService stockBalanceService;

    @Autowired
    private DefectItemJpaService defectItemJpaService;

    @Override
    public ArrayList<Outward> getAllOutwards() {
    try{
        return (ArrayList<Outward>) outwardJpaRepository.findAll();
    }
    catch(Exception e){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }    
    }

    @Override
    public ArrayList<Outward> addStockOutwardAndBalance(Outward outward) {
       
    try{
        if(outward.getNewReplacement().equals("REPLACEMENT")){
        Store updatedDefectStock = storeJpaService.updateStoreItemDefectStatus(outward);
        if(updatedDefectStock == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        }
       
        long outwardQty = outward.getQuantity();
        Store existingStoreItem = outward.getStore();
        Store isStoreUpdated = storeJpaService.updateStoreItemOutward(outward,existingStoreItem.getStoreId());
       
        if(isStoreUpdated != null){
            outward.setQuantity(outwardQty);
           Outward newOutward =  outwardJpaRepository.save(outward);
           if(newOutward != null){
            StockBalance existingStockBalance = stockBalancerRepository.findByItemAndWorkingStatus(outward.getStore().getItem(), outward.getStore().getWorkingStatus());
            if(existingStockBalance != null){
                long outwardQuantity = outward.getStore().getItem().getItemType().equals("ASSET") ? 1 : outward.getQuantity();
                long quantity = outward.getStore().getItem().getItemType().equals("EXPENSE") ? (existingStockBalance.getQuantity() - outwardQuantity) : existingStockBalance.getQuantity();
                System.out.println(existingStockBalance.getQuantity());
                System.out.println(outward.getQuantity());
                existingStockBalance.setQuantity(quantity);
                isStoreUpdated.setQuantity(quantity);
                storeJpaService.addStore(isStoreUpdated);
                stockBalanceService.addStockBalance(existingStockBalance);
               
                if(outward.getNewReplacement().equals("REPLACEMENT")){
                      
                         DefectItemService defectItemService = new DefectItemService();
                        Store defectiveStock = storeJpaService.getStoreBySerialNumber(outward.getFaultySerialNumber());
                        defectItemService.setQuantity(outwardQuantity); 
                        defectItemService.setReceivedFrom(outward.getToCampus());
                        defectItemService.setWorkingStatus("NOT_WORKING");
                        defectItemService.setStore(defectiveStock);
                        defectItemJpaService.addItemService(defectItemService);
                        
                    
                }
               
            }
            }
        }
        return (ArrayList<Outward>)outwardJpaRepository.findTop10Outward();
    }
    catch(NoSuchElementException e){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }    
    }

    @Override
    public Outward getOutwardById(long outwardId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOutwardById'");
    }

    @Override
    public Outward updateOutward(Outward outward, long outwardId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateOutward'");
    }

    @Override
    public void deleteOutward(long outwardId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteOutward'");
    }
    
}
