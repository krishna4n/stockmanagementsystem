package com.IT.Stock.Model;

import java.time.LocalDateTime;

import jakarta.persistence.*;


@Entity
@Table(name = "item",uniqueConstraints = {@UniqueConstraint(columnNames = {"itemname", "itembrand","itemmodel","itemcapacity","itemtype"})})

public class Item {    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial",name="itemid")
    private long itemId;
    @Column(name = "itemtype", nullable = false)  
    private String itemType;
    @Column(name = "itemname", nullable = false)
    private String itemName;
    @Column(name = "itembrand", nullable = false)
    private String itemBrand;
    @Column(name = "itemmodel", nullable = false)    
    private String itemModel;
    @Column(name = "itemcapacity", nullable = false)
    private String itemCapacity;    

    public Item() {
    }
    public Item(long itemId, String itemName, String itemBrand, String itemModel, String itemCapacity,
            String itemSource, String itemSerialNumber, String itemType, LocalDateTime createdAt) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemBrand = itemBrand;
        this.itemModel = itemModel;
        this.itemCapacity = itemCapacity;
        this.itemType = itemType;
    }
    public long getItemId() {
        return itemId;
    }
    public void setItemId(long itemId) {
        this.itemId = itemId;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public String getItemBrand() {
        return itemBrand;
    }
    public void setItemBrand(String itemBrand) {
        this.itemBrand = itemBrand;
    }
    public String getItemModel() {
        return itemModel;
    }
    public void setItemModel(String itemModel) {
        this.itemModel = itemModel;
    }
    public String getItemCapacity() {
        return itemCapacity;
    }
    public void setItemCapacity(String itemCapacity) {
        this.itemCapacity = itemCapacity;
    }
    public String getItemType() {
        return itemType;
    }
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
    
    
}
