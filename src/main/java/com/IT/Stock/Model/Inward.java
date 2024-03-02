package com.IT.Stock.Model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "inward")
public class Inward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inwardid")
    private long inwardId;
    @ManyToOne
    @JoinColumn(name = "storeid")
    private Store store;
    @Column(name = "cityname")
    private String cityName;
    @Column(name = "campusname")
    private String campusName;
    @Column(name = "department")
    private String department;
    @ManyToOne
    @JoinColumn(name = "itemid")
    private Item item;
    
   

    public Inward() {
    }

    
    public Inward(long inwardId, Store store, String cityName, String campusName, String department, Item item,
            Date created_on) {
        this.inwardId = inwardId;
        this.store = store;
        this.cityName = cityName;
        this.campusName = campusName;
        this.department = department;
        this.item = item;
    }


    public long getInwardId() {
        return inwardId;
    }
    public void setInwardId(long inwardId) {
        this.inwardId = inwardId;
    }
    public Store getStore() {
        return store;
    }
    public void setStore(Store store) {
        this.store = store;
    }
    public String getCityName() {
        return cityName;
    }
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    public String getCampusName() {
        return campusName;
    }
    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public Item getItem() {
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }
    
}
