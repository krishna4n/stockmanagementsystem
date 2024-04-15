package com.IT.Stock.Service;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.IT.Stock.Model.DefectItemService;
import com.IT.Stock.Model.Inward;
import com.IT.Stock.Model.Scrap;
import com.IT.Stock.Model.StockBalance;
import com.IT.Stock.Model.Store;
import com.IT.Stock.Repository.InwardJpaRepository;
import com.IT.Stock.Repository.InwardRepository;
import com.IT.Stock.Repository.StockBalanceJpaRepository;
import com.IT.Stock.Repository.StoreJpaRepository;

@Service
public class InwardJpaService implements InwardRepository{
    @Autowired
    private InwardJpaRepository inwardJpaRepository;

    @Autowired
    private StoreJpaRepository storeJpaRepository;

    @Autowired
    private StoreJpaService storeJpaService;

    @Autowired
    private StockBalanceService stockBalanceService;

    @Autowired
    private StockBalanceJpaRepository stockBalanceJpaRepository;

    @Autowired
    private DefectItemJpaService defectItemJpaService;

    @Autowired
    private ScrapJpaService scrapJpaService;


    @Override
    public ArrayList<Inward> getAllInwards() {
    try{
        return (ArrayList<Inward>) inwardJpaRepository.findAll();
    }
    catch(Exception e){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }    
    }


    @SuppressWarnings("null")
    @Override
    public Inward addInward(Inward inward) {
        try{
            System.out.println("in adward:        ");
            System.out.println("end");
           
           return inwardJpaRepository.save(inward);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Inward getInwardById(long inwardId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getInwardById'");
    }

    @Override
    public Inward updateInward(Inward inward, long inwardId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateInward'");
    }

    @Override
    public void deleteInward(long inwardId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteInward'");
    }


    @Override
    public ArrayList<Inward> getLastTenInwards() {
        try{
           return (ArrayList<Inward>) inwardJpaRepository.findTop10Inward();
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        
    }


    @SuppressWarnings("null")
    @Override
    public ArrayList<Inward> addInwardStoreAndBalance(Store store) {
        
        try{
            Inward newInward = new Inward();  
            
            if(store.getSource().equals("CENTRAL_OFFICE")){
                newInward.setCampusName(store.getCampusName());
                newInward.setCityName(store.getCityName());
                newInward.setDepartment(store.getDepartment());
            }
            else if(store.getSource().equals("VENDOR")){
                newInward.setCampusName(store.getVendorName());
                newInward.setCityName(store.getVendorName());
                newInward.setDepartment(store.getVendorName());
            }
            
            Store existingStoreItem = storeJpaRepository.findStoreBySerialNumber(store.getSerialNumber());
            
            newInward.setItem(store.getItem());
            newInward.setInwardDate(store.getInwardDate());
            newInward.setQuantity(store.getQuantity());
            newInward.setWorkingStatus(store.getWorkingStatus());
            
            if(existingStoreItem != null){
                // This condition is for checking duplicate and base 
                //on ASSET and EXPENSE validation quantity will be updated.
                if(existingStoreItem.getCurrentStatus().equals("IN") & !store.getSerialNumber().equals("") & store.getItem().getItemType().equals("ASSET")){
                    System.out.println("duplicate record");
                    throw new ResponseStatusException(HttpStatus.FOUND, "This stock item is already in Store");
                } 
                else {
                 
                   newInward.setStore(existingStoreItem);
                }  
                
                storeJpaService.updateStoreItemStatus(store, existingStoreItem);     
                   
            }
            else{
              
                existingStoreItem = storeJpaService.addStore(store);  
                if(existingStoreItem == null){
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND,"invalid store details");
                }      
                newInward.setStore(existingStoreItem); 
                
            }

            StockBalance existingStockBalance = stockBalanceJpaRepository.findByItemAndWorkingStatus(store.getItem(),store.getWorkingStatus());
            System.out.printf("Existingstock balance is :",existingStockBalance);
            Inward inward = inwardJpaRepository.save(newInward);
            if(inward != null){
            if(existingStockBalance != null )
            {
                
                stockBalanceService.updateQuantity(inward,existingStockBalance);
             
            }

            else if((store.getItem().getItemType().equals("EXPENSE") && store.getWorkingStatus().equals("WORKING")) || (store.getItem().getItemType().equals("ASSET"))){
                
                StockBalance newStockBalance = new StockBalance();
                newStockBalance.setItem(store.getItem());
                newStockBalance.setQuantity(inward.getQuantity());
                newStockBalance.setWorkingStatus(store.getWorkingStatus());
                
                stockBalanceService.addStockBalance(newStockBalance);
            }    
            
             if(store.getWorkingStatus().equals("NOT_WORKING") && store.getItem().getItemType().equals("ASSET")){
                long inwardQuantity = inward.getItem().getItemType().equals("ASSET") ? 1 : inward.getQuantity();
                      
                         DefectItemService defectItemService = new DefectItemService();
                        Store defectiveStock = storeJpaService.getStoreBySerialNumber(store.getSerialNumber());
                        defectItemService.setQuantity(inwardQuantity); 
                        defectItemService.setReceivedFrom(store.getCampusName());
                        defectItemService.setWorkingStatus("NOT_WORKING");
                        defectItemService.setStore(defectiveStock);
                        defectItemJpaService.addItemService(defectItemService);
                    
                }
            else if(store.getWorkingStatus().equals("NOT_WORKING") && store.getItem().getItemType().equals("EXPENSE")){
                //SCRAP ENTRY HERE
                Scrap newScrap = new Scrap();
                long scrapQuantity = store.getItem().getItemType().equals("ASSET") ? 1 : store.getQuantity();
                newScrap.setStore(existingStoreItem);
                newScrap.setReceivedDate(store.getInwardDate());
                newScrap.setReceivedFrom(store.getCampusName());
                existingStoreItem.setWorkingStatus("SCRAP");
                newScrap.setQuantity(scrapQuantity);
                storeJpaService.addStore(existingStoreItem);
                scrapJpaService.addScrap(newScrap);
            }    
        
        }

            return (ArrayList<Inward>)inwardJpaRepository.findTop10Inward();
        }
        catch(NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    
}
