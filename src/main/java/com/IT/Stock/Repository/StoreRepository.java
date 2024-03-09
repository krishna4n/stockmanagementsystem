package com.IT.Stock.Repository;

import java.util.ArrayList;

import com.IT.Stock.Model.Inward;
import com.IT.Stock.Model.Store;

public interface StoreRepository {

    ArrayList<Store> getAllStores();
    Store addStore(Store store);
    Store getStoreById(long storeId);
    Store updaStore(Store store,long storeId);
    Store deleteStore(long storeId);
    ArrayList<Inward> addStoreAndInwardAndBalance(Store store);
    
}
