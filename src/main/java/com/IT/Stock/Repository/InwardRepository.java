package com.IT.Stock.Repository;

import java.util.ArrayList;

import com.IT.Stock.Model.Inward;

public interface InwardRepository {
    ArrayList<Inward> getAllInwards();
    Inward addInward(Inward inward);
    Inward getInwardById(long inwardId);
    Inward updateInward(Inward inward, long inwardId);
    void deleteInward(long inwardId);
}
