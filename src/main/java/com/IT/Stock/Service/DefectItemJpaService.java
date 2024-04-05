package com.IT.Stock.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.IT.Stock.Model.DefectItemService;
import com.IT.Stock.Repository.DefectItemJpaRepository;
import com.IT.Stock.Repository.DefectItemRepository;

@Service
public class DefectItemJpaService implements DefectItemRepository{

    @Autowired
    private DefectItemJpaRepository defectItemJpaRepository;

    @Override
    public ArrayList<DefectItemService> getAllDefectItems() {
    try{
        return (ArrayList<DefectItemService>)defectItemJpaRepository.findAll();
    }
    catch(Exception e){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }    
    }

    @SuppressWarnings("null")
    @Override
    public DefectItemService addItemService(DefectItemService defectItemService) {
        try{
            System.out.println("Defect item add requested");
            return defectItemJpaRepository.save(defectItemService);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }    
    }
    
}
