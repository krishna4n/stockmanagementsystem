package com.IT.Stock.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.IT.Stock.Model.Item;
import com.IT.Stock.Repository.ItemJpaRepository;
import com.IT.Stock.Repository.ItemRepository;

@Service
public class ItemJpaService implements ItemRepository {

    @Autowired
    private ItemJpaRepository itemJpaRepository;

    @Override
    public ArrayList<Item> getAllItems() {
        try{
    List<Item> items = itemJpaRepository.findAll();
        return (ArrayList<Item>) items;
       }
       catch(Exception e){
           throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @SuppressWarnings( "null")
    @Override
    public Item addItem(Item item) {
        try{
           
            
            return itemJpaRepository.save(item);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        
    }

    @SuppressWarnings("null")
    @Override
    public Item getItemById(Long itemId) {
        try{
            return itemJpaRepository.findById(itemId).get();
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @SuppressWarnings("null")
    @Override
    public Item updateItem(Item Item, Long itemId) {
        try{
            Item existingItem = itemJpaRepository.findById(itemId).get();
                      
            if(Item.getItemCapacity() != null){
                existingItem.setItemCapacity(Item.getItemCapacity());
            }
            if(Item.getItemModel() != null){
                existingItem.setItemModel(Item.getItemModel());
            }
           
            
            return itemJpaRepository.save(existingItem);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @SuppressWarnings("null")
    @Override
    public void deleteItem(Long itemId) {
        try{
            itemJpaRepository.deleteById(itemId);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }
}
