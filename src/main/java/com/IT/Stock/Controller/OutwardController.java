package com.IT.Stock.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.IT.Stock.Model.Outward;
import com.IT.Stock.Service.OutwardJpaService;

@RestController
public class OutwardController {
    @Autowired
    private OutwardJpaService outwardJpaService;

    @GetMapping("api/stores/outward")
    public ArrayList<Outward> getAllOutwards(){
        return outwardJpaService.getAllOutwards();
    }

    @PostMapping("api/stores/outward")
    public Outward addOutward(@RequestBody Outward outward){
        return outwardJpaService.addOutward(outward);
    }
    
}
