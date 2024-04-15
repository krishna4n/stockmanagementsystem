package com.IT.Stock.Model;

import java.time.LocalDateTime;
import java.time.ZoneId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.util.Date;

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
    @Column(name = "inwarddate")
    private Date inwardDate;
    @Column(name = "cityname")
    private String cityName;
    @Column(name = "campusname")
    private String campusName;
    @Column(name = "department")
    private String department;
    @Column(name = "quantity")
    private long quantity;
    @Column(name = "workingstatus")
    private String workingStatus;
    @ManyToOne
    @JoinColumn(name = "itemid")
    private Item item;    
@Column(name = "createdon", nullable = false, updatable = false)
private LocalDateTime createdOn;
    
@PrePersist
    protected void onCreate() {
        createdOn = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
    }
   

    public Inward() {
    }

    
    public Inward(long inwardId, Store store, String cityName, String campusName, String department, Item item,Date inwardDate, int quantity, String workingStatus) {
        this.inwardId = inwardId;
        this.store = store;
        this.cityName = cityName;
        this.campusName = campusName;
        this.department = department;
        this.item = item;
        this.inwardDate = inwardDate;
        this.quantity = quantity;
        this.workingStatus = workingStatus;
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


    public Date getInwardDate() {
        return inwardDate;
    }


    public void setInwardDate(Date inwardDate) {
        this.inwardDate = inwardDate;
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


    public long getQuantity() {
        return quantity;
    }


    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }


    public String getWorkingStatus() {
        return workingStatus;
    }


    public void setWorkingStatus(String workingStatus) {
        this.workingStatus = workingStatus;
    }


    public Item getItem() {
        return item;
    }


    public void setItem(Item item) {
        this.item = item;
    }


    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

 
}
