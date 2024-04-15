package com.IT.Stock.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.IT.Stock.Model.Scrap;
import com.IT.Stock.Service.ScrapJpaService;

@RestController
public class ScrapController {
    
    @Autowired
    private ScrapJpaService scrapJpaService;

    @GetMapping("/stores/scrap")
    public ArrayList<Scrap> getAllScraps(){
        return scrapJpaService.getAllScraps();
    }

    @PostMapping("/stores/scrap")
    public Scrap addScrap(@RequestBody Scrap scrap){
        return scrapJpaService.addScrap(scrap);
    }
}
