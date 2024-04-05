package com.IT.Stock.Repository;

import java.util.ArrayList;


import com.IT.Stock.Model.Outward;
import com.IT.Stock.Model.Store;

public interface StoreRepository {

    ArrayList<Store> getAllStores();
    Store addStore(Store store);
    Store getStoreBySerialNumber(String serialNumber);
    Store updateStoreItemStatus(Store store,Store existingStoreItem);
    Store deleteStore(long storeId);
    ArrayList<Store> getWarrantyDetails();
    Store updateStoreItemOutward(Outward outward,long storeId);
    ArrayList<Store> getStoresByCurrentStatusAndWorkingStatus(String currentStatus, String workingStatus);
    Store updateStoreItemDefectStatus(Outward outward);
}
