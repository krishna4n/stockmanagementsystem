package com.IT.Stock.Repository;

import java.util.ArrayList;

import com.IT.Stock.Model.Item;

public interface ItemRepository {
    ArrayList<Item> getAllItems();
    Item addItem(Item item);
    Item getItemById(Long itemId);
    Item updateItem(Item item,Long itemId);
    void deleteItem(Long itemId);    
}
