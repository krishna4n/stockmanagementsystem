package com.IT.Stock.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.IT.Stock.Model.Inward;
import com.IT.Stock.Service.InwardJpaService;

@RestController
public class InwardController {
    @Autowired
    private InwardJpaService inwardJpaService;

    @PostMapping("/stores/inward")
    public Inward addInward(@RequestBody Inward inward){
        return inwardJpaService.addInward(inward);
    }
}
