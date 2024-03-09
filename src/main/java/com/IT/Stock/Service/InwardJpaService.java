package com.IT.Stock.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.IT.Stock.Model.Inward;
import com.IT.Stock.Repository.InwardJpaRepository;
import com.IT.Stock.Repository.InwardRepository;

@Service
public class InwardJpaService implements InwardRepository{
    @Autowired
    private InwardJpaRepository inwardJpaRepository;


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
    
}
