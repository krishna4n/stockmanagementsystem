package com.IT.Stock.Repository;

import java.util.ArrayList;

import com.IT.Stock.Model.Outward;

public interface OutwardRepository {
    ArrayList<Outward> getAllOutwards();
    Outward addOutward(Outward outward);
    Outward getOutwardById(long outwardId);
    Outward updateOutward(Outward outward, long outwardId);
    void deleteOutward(long outwardId);
}
