package com.IT.Stock.Model;

import java.time.LocalDateTime;
import java.time.ZoneId;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "storeid")
    private long storeId;
    @ManyToOne
    @JoinColumn(name = "itemid")
    private Item item;
    @Column(name = "source")
    private String source;
    @Column(name = "campusname")
    private String campusName;
    @Column(name = "cityname")
    private String cityName;
    @Column(name = "department")
    private String department;
    @Column(name = "ponumber")
    private String poNumber;
    @Column(name = "invoicenumber")
    private String invoiceNumber;
    @Column(name = "invoicedate")
    private String invoiceDate;
    @Column(name = "serialnumber", unique = true)
    private String serialNumber;
    @Column(name = "quantity")
    private long quantity;
    @Column(name = "vendorName")
    private String vendorName;
    @Column(name = "vendorAddress")
    private String vendorAddress;
    @Column(name = "vendorContact")
    private String vendorContact;
    @Column(name = "warrantyenddate")
    private String warrantyEndDate;
    @Column(name = "warrantytype")
    private String warrantyType;
    @Column(name = "currentstatus")
    private String currentStatus;
    @Column(name = "workingstatus")
    private String workingStatus;   
    @Column(name = "inwarddate")
    private Date inwardDate; 
    @Column(name = "currentlocation")
    private String currentLocation;
    @Column(name = "createdon", nullable = false, updatable = false)
    private LocalDateTime createdOn;

    @PrePersist
    protected void onCreate() {
        createdOn = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
    }


    public Store() {
    }

    public Store(long storeId, Item item, String source, String campusName, String cityName, String department,
            String poNumber, String invoiceNumber, String invoiceDate, String serialNumber, int quantity,
            String vendorName, String vendorAddress, String vendorContact, String warrantyEndDate, String warrantyType,
            String currentStatus, String workingStatus, Date inwardDate, String currentLocation,
            LocalDateTime createdOn) {
        this.storeId = storeId;
        this.item = item;
        this.source = source;
        this.campusName = campusName;
        this.cityName = cityName;
        this.department = department;
        this.poNumber = poNumber;
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.serialNumber = serialNumber;
        this.quantity = quantity;
        this.vendorName = vendorName;
        this.vendorAddress = vendorAddress;
        this.vendorContact = vendorContact;
        this.warrantyEndDate = warrantyEndDate;
        this.warrantyType = warrantyType;
        this.currentStatus = currentStatus;
        this.workingStatus = workingStatus;
        this.inwardDate = inwardDate;
        this.currentLocation = currentLocation;
        this.createdOn = createdOn;
    }


    public String getCurrentLocation() {
        return currentLocation;
    }


    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
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


    public long getStoreId() {
        return storeId;
    }
    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }
    public Item getItem() {
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public String getCampusName() {
        return campusName;
    }
    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }
    public String getCityName() {
        return cityName;
    }
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
   
    public String getPoNumber() {
        return poNumber;
    }
    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }
    public String getInvoiceNumber() {
        return invoiceNumber;
    }
    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }
    public String getInvoiceDate() {
        return invoiceDate;
    }
    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }
    public String getSerialNumber() {
        return serialNumber;
    }
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
    public long getQuantity() {
        return quantity;
    }
    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
    public String getWarrantyEndDate() {
        return warrantyEndDate;
    }
    public void setWarrantyEndDate(String warrantyEndDate) {
        this.warrantyEndDate = warrantyEndDate;
    }
    public String getWarrantyType() {
        return warrantyType;
    }
    public void setWarrantyType(String warrantyType) {
        this.warrantyType = warrantyType;
    }
    public String getCurrentStatus() {
        return currentStatus;
    }
    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }
    public LocalDateTime getCreatedOn() {
        return createdOn;
    }
    public void setWorkingStatus(String workingStatus){
        this.workingStatus = workingStatus;
    }
   
    public String getWorkingStatus() {
        return workingStatus;
    }


    public Date getInwardDate() {
        return inwardDate;
    }


    public void setInwardDate(Date inwardDate) {
        this.inwardDate = inwardDate;
    }
    
}
