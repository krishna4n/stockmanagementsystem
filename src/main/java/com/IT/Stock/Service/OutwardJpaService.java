package com.IT.Stock.Service;

import java.util.ArrayList;

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

        Store existingStoreItem = outward.getStore();
        Store isStoreUpdated = storeJpaService.updateStoreItemOutward(outward,existingStoreItem.getStoreId());
       
        if(isStoreUpdated != null){
           Outward newOutward =  outwardJpaRepository.save(outward);
           if(newOutward != null){
            StockBalance existingStockBalance = stockBalancerRepository.findByItemAndWorkingStatus(outward.getStore().getItem(), outward.getStore().getWorkingStatus());
            if(existingStockBalance != null){
                long outwardQuantity = outward.getStore().getItem().getItemType().equals("ASSET") ? 1 : outward.getQuantity();
                long quantity = existingStockBalance.getQuantity() - outwardQuantity;
                System.out.println(existingStockBalance.getQuantity());
                System.out.println(outward.getQuantity());
                existingStockBalance.setQuantity(quantity);
                isStoreUpdated.setQuantity(quantity);
                storeJpaService.addStore(isStoreUpdated);
                stockBalanceService.addStockBalance(existingStockBalance);
                outwardJpaRepository.save(outward);
                if(outward.getNewReplacement().equals("REPLACEMENT")){
                    System.out.println("Replacement process initialized");
                    Store updatedDefectSerialNumber = storeJpaService.updateStoreItemReplacement(outward.getFaultySerialNumber());
                    if(updatedDefectSerialNumber != null){
                        DefectItemService defectItemService = new DefectItemService();
                        Store defectiveStock = storeJpaService.getStoreBySerialNumber(outward.getFaultySerialNumber());
                        defectItemService.setQuantity(outward.getQuantity()); 
                        defectItemService.setReceivedFrom(outward.getToCampus());
                        defectItemService.setWorkingStatus("NOT_WORKING");
                        defectItemService.setStore(defectiveStock);
                        defectItemJpaService.addItemService(defectItemService);
                    }
                }
            }
            }
        }
        return (ArrayList<Outward>)outwardJpaRepository.findTop10Outward();
    }
    catch(Exception e){
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
