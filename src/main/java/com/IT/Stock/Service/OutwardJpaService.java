package com.IT.Stock.Service;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.IT.Stock.Model.*;
import com.IT.Stock.Repository.InwardJpaRepository;
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

    @Autowired
    private InwardJpaRepository inwardJpaRepository;

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
        System.out.println("===================================================");
        System.out.println("In outward class addstockoutward initiated");
        System.out.println("===================================================");
    try{
       
        
        Long lastInwardId =  inwardJpaRepository.findMaxInwardIdByStoreId(outward.getStore().getStoreId());
        System.out.println("==========last oinwardid is=========================================");
        System.out.println(lastInwardId);
        System.out.println("===================================================");
        outward.setInwardId(lastInwardId);
        if(outward.getNewReplacement().equals("REPLACEMENT")){
        Store updatedDefectStock = storeJpaService.updateStoreItemDefectStatus(outward);
        if(updatedDefectStock == null){
            System.out.println("===================================================");
            System.out.println("In outward updateddefectstock is null");
            System.out.println("===================================================");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"store details are invalid");
        }
    }
        if(lastInwardId.equals(0)){
            System.out.println("===================================================");
            System.out.println("In outward lastinwardid is 0");
            System.out.println("===================================================");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"inwardid is invalid");
        }
        Store existingStoreItem = outward.getStore();

        if(outward.getNewReplacement().equals("REPLACEMENT") && existingStoreItem == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"replacement details are wrong");
        }
        
        long outwardQty = outward.getStore().getItem().getItemType().equals("ASSET") ? 1 : outward.getQuantity();
        
        Store isStoreUpdated = storeJpaService.updateStoreItemOutward(outward,existingStoreItem.getStoreId());
       
        if(isStoreUpdated != null){
            outward.setQuantity(outwardQty);
           Outward newOutward =  outwardJpaRepository.save(outward);
           if(newOutward != null){
            StockBalance existingStockBalance = stockBalancerRepository.findByItemAndWorkingStatus(outward.getStore().getItem(), outward.getStore().getWorkingStatus());
            if(existingStockBalance != null){
                long outwardQuantity = outward.getStore().getItem().getItemType().equals("ASSET") ? 1 : outward.getQuantity();
                long updatedQuantity = outward.getStore().getItem().getItemType().equals("EXPENSE") ? (existingStockBalance.getQuantity() - outwardQuantity) : existingStockBalance.getQuantity() - outwardQuantity;
                System.out.println(existingStockBalance.getQuantity());
                System.out.println(outward.getQuantity());
                existingStockBalance.setQuantity(updatedQuantity);
                isStoreUpdated.setQuantity(updatedQuantity);
                storeJpaService.addStore(isStoreUpdated);
                stockBalanceService.addStockBalance(existingStockBalance);               
            }
            }
        }
        return (ArrayList<Outward>)outwardJpaRepository.findTop10Outward();
    }
    catch(NoSuchElementException e){
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
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
