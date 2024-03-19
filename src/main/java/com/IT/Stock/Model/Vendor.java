package com.IT.Stock.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    
}
