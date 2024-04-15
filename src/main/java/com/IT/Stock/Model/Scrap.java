package com.IT.Stock.Model;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "scrap")
public class Scrap {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scrapid")
    private long scrapId;
    @Column(name = "receiveddate")
    private Date receivedDate;
    @Column(name = "receivedFrom")
    private String receivedFrom;
    @Column(name = "quantity")
    private long quantity;
    @OneToOne
    private Store store;
    @Column(name = "createdon", nullable = false, updatable = false)
private LocalDateTime createdOn;
    
@PrePersist
    protected void onCreate() {
        createdOn = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
    }

public Scrap(long scrapId, Date receivedDate, String receivedFrom, long quantity, Store store,
        LocalDateTime createdOn) {
    this.scrapId = scrapId;
    this.receivedDate = receivedDate;
    this.receivedFrom = receivedFrom;
    this.quantity = quantity;
    this.store = store;
    this.createdOn = createdOn;
}

public Scrap() {
}

public long getScrapId() {
    return scrapId;
}

public void setScrapId(long scrapId) {
    this.scrapId = scrapId;
}

public Date getReceivedDate() {
    return receivedDate;
}

public void setReceivedDate(Date receivedDate) {
    this.receivedDate = receivedDate;
}

public String getReceivedFrom() {
    return receivedFrom;
}

public void setReceivedFrom(String receivedFrom) {
    this.receivedFrom = receivedFrom;
}

public long getQuantity() {
    return quantity;
}

public void setQuantity(long quantity) {
    this.quantity = quantity;
}

public Store getStore() {
    return store;
}

public void setStore(Store store) {
    this.store = store;
}

public LocalDateTime getCreatedOn() {
    return createdOn;
}
    
}
