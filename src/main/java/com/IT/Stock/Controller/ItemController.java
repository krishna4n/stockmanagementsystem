package com.IT.Stock.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.IT.Stock.Model.Item;
import com.IT.Stock.Service.ItemJpaService;


@RestController
public class ItemController {
    @Autowired
    private ItemJpaService itemJpaService;

    @GetMapping("items")
    public ArrayList<Item> getAllItems(){
       return itemJpaService.getAllItems();
    }

    @PostMapping("items")
    public Item addItem(@RequestBody Item item){
        return itemJpaService.addItem(item);
    }

    @GetMapping("items/{itemId}")
    public Item getItemById(@PathVariable("itemId") long itemId){
        return itemJpaService.getItemById(itemId);
    }

    @PutMapping("items/{itemId}")
    public Item updateItem(@RequestBody Item item, @PathVariable("itemId") long itemId){
        return itemJpaService.updateItem(item, itemId);
    }

    @DeleteMapping("items/{itemId}")
    public void deleteItem(@PathVariable("itemId") long itemId){
        itemJpaService.deleteItem(itemId);
    }
   
}
