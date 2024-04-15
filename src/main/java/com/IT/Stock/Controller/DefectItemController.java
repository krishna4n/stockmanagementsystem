package com.IT.Stock.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.IT.Stock.Model.DefectItemService;
import com.IT.Stock.Service.DefectItemJpaService;

@RestController
public class DefectItemController {
    
    @Autowired
    private DefectItemJpaService defectItemJpaService;

    @GetMapping("/stores/service")
    public ArrayList<DefectItemService> getAllDefectItems(){
        return defectItemJpaService.getAllDefectItems();
    }
    @GetMapping("/stores/service/{serviceId}")
    public DefectItemService getDefectItemById(@PathVariable("serviceId") long serviceId){
        return defectItemJpaService.getDefectItemById(serviceId);
    }
}
