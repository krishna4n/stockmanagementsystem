package com.IT.Stock.Service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.IT.Stock.Model.Outward;
import com.IT.Stock.Repository.OutwardRepository;

@Service
public class OutwardJpaService implements OutwardRepository{

    @Override
    public ArrayList<Outward> getAllOutwards() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllOutwards'");
    }

    @Override
    public Outward addOutward(Outward outward) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addOutward'");
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
