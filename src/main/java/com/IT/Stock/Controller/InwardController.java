package com.IT.Stock.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.IT.Stock.Model.Inward;
import com.IT.Stock.Service.InwardJpaService;

@RestController
public class InwardController {
    @Autowired
    private InwardJpaService inwardJpaService;

    @GetMapping("api/stores/inward")
    public ArrayList<Inward> getAllInwards(){

        return inwardJpaService.getAllInwards();
    }

    @GetMapping("api/stores/last-ten-inwards")
    public ArrayList<Inward> getLastTenInwards(){
        return inwardJpaService.getLastTenInwards();
    }

    @PostMapping("api/stores/inward")
    public Inward addInward(@RequestBody Inward inward){
        return inwardJpaService.addInward(inward);
    }
}
