package com.IT.Stock.Model;

import java.time.LocalDateTime;
import java.time.ZoneId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "vendor")
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vendorid")
    private long vendorId;
    @Column(name = "vendorname")
    private String vendorName;
    @Column(name = "vendoraddress")
    private String vendorAddress;
    @Column(name = "vendorcontact")
    private String vendorContact;
    @Column(name = "createdon", nullable = false, updatable = false)
private LocalDateTime createdOn;
    
@PrePersist
    protected void onCreate() {
        createdOn = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
    }
    public Vendor() {
    }
    public Vendor(long vendorId, String vendorName, String vendorAddress, String vendorContact) {
        this.vendorId = vendorId;
        this.vendorName = vendorName;
        this.vendorAddress = vendorAddress;
        this.vendorContact = vendorContact;
    }
    public long getVendorId() {
        return vendorId;
    }
    public void setVendorId(long vendorId) {
        this.vendorId = vendorId;
    }
    public String getVendorName() {
        return vendorName;
    }
    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }
    public String getVendorAddress() {
        return vendorAddress;
    }
    public void setVendorAddress(String vendorAddress) {
        this.vendorAddress = vendorAddress;
    }
    public String getVendorContact() {
        return vendorContact;
    }
    public void setVendorContact(String vendorContact) {
        this.vendorContact = vendorContact;
    }
    public LocalDateTime getCreatedOn() {
        return createdOn;
    }
    
    
}
