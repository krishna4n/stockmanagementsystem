package com.IT.Stock.Model;

import java.time.LocalDateTime;

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
    @Column(name = "qunatity")
    private long quantity;
    @Column(name = "updatedOn", nullable = false)
    private LocalDateTime updatedOn;

 
  @PrePersist
    protected void updatedOn() {
        updatedOn = LocalDateTime.now();
    }
    
    public StockBalance() {
    }

    

    public StockBalance(long stockId, Item item, long quantity) {
        this.stockId = stockId;
        this.item = item;
        this.quantity = quantity;
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
