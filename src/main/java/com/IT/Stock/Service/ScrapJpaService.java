package com.IT.Stock.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.IT.Stock.Model.Scrap;
import com.IT.Stock.Repository.ScrapJpaRepository;
import com.IT.Stock.Repository.ScrapRepository;

@Service
public class ScrapJpaService implements ScrapRepository{

    @Autowired
    private ScrapJpaRepository scrapJpaRepository;

    @Override
    public ArrayList<Scrap> getAllScraps() {
       try{
        return (ArrayList<Scrap>) scrapJpaRepository.findAll();
       }
       catch(Exception e){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No details are found");
       }
    }

    public Scrap addScrap(Scrap scrap){
        try{
            scrapJpaRepository.save(scrap);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return null;
    }


    
}
