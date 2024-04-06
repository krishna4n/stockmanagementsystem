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

@Entity
@Table(name = "stock_balance")
public class StockBalance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stockid")
    private long stockId;
    @ManyToOne
    @JoinColumn(name = "itemid")
    private Item item;
    @Column(name = "workingstatus")
    private String workingStatus;
    @Column(name = "quantity")
    private long quantity;
    @Column(name = "updatedOn", nullable = false)
    private LocalDateTime updatedOn;

 
@PrePersist
    protected void updatedOn() {
        updatedOn = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
    }
    
    public StockBalance() {
    }

    public StockBalance(long stockId, Item item, long quantity, String workingStatus) {
        this.stockId = stockId;
        this.item = item;
        this.quantity = quantity;
        this.workingStatus = workingStatus;
    }

    public void setWorkingStatus(String workingStatus) {
        this.workingStatus = workingStatus;
    }
    
    
        public String getWorkingStatus() {
        return workingStatus;
    }

    public long getStockId() {
        return stockId;
    }
    public void setStockId(long stockId) {
        this.stockId = stockId;
    }
    public Item getItem() {
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }
    public long getQuantity() {
        return quantity;
    }
    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }
       
}
