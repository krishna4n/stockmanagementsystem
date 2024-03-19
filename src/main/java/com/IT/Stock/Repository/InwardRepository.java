package com.IT.Stock.Repository;

import java.util.ArrayList;

import com.IT.Stock.Model.Inward;
import com.IT.Stock.Model.Store;

public interface InwardRepository {
    ArrayList<Inward> getAllInwards();
    ArrayList<Inward> getLastTenInwards();
    Inward addInward(Inward inward);
    Inward getInwardById(long inwardId);
    Inward updateInward(Inward inward, long inwardId);
    void deleteInward(long inwardId);
    ArrayList<Inward> addInwardStoreAndBalance(Store store);
}
