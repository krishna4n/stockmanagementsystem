package com.IT.Stock.Model;

import java.time.LocalDateTime;
import java.util.Date;

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
@Table(name = "defectitemservice")
public class DefectItemService {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "serviceid")
    private long serviceId;
    @ManyToOne
    @JoinColumn(name = "storeid")
    private Store store;
    @Column(name = "receivedfrom")
    private String receivedFrom;
    @Column(name = "receivedDate")
    private Date receivedDate;
    @Column(name = "complaint")
    private String complaint;
    @Column(name = "resolution")
    private String resolution;
    @Column(name = "servicedby")
    private String servicedBy;
    @Column(name = "workingstatus")
    private String workingStatus;
    @Column(name = "servicedate")
    private Date servicedDate;
    @Column(name = "createdon")
    private LocalDateTime createdOn;
    @ManyToOne
    @JoinColumn(name = "replacedStock")
    private Store replacedStock;
    @Column(name = "quantity")
    private long quantity;

        
@PrePersist
    protected void onCreate() {
        createdOn  = LocalDateTime.now();
       
    }   

    public DefectItemService() {
    }

    public DefectItemService(long serviceId, Store store, String receivedFrom, Date receivedDate, String complaint,
            String resolution, String servicedBy, String workingStatus, Date servicedDate, LocalDateTime createdOn,
            Store replacedStock, long quantity) {
        this.serviceId = serviceId;
        this.store = store;
        this.receivedFrom = receivedFrom;
        this.receivedDate = receivedDate;
        this.complaint = complaint;
        this.resolution = resolution;
        this.servicedBy = servicedBy;
        this.workingStatus = workingStatus;
        this.servicedDate = servicedDate;
        this.createdOn = createdOn;
        this.replacedStock = replacedStock;
        this.quantity = quantity;
    }

    public long getServiceId() {
        return serviceId;
    }

    public void setServiceId(long serviceId) {
        this.serviceId = serviceId;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String getReceivedFrom() {
        return receivedFrom;
    }

    public void setReceivedFrom(String receivedFrom) {
        this.receivedFrom = receivedFrom;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getServicedBy() {
        return servicedBy;
    }

    public void setServicedBy(String servicedBy) {
        this.servicedBy = servicedBy;
    }

    public String getWorkingStatus() {
        return workingStatus;
    }

    public void setWorkingStatus(String workingStatus) {
        this.workingStatus = workingStatus;
    }

    public Date getServicedDate() {
        return servicedDate;
    }

    public void setServicedDate(Date servicedDate) {
        this.servicedDate = servicedDate;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }


    public Store getReplacedStock() {
        return replacedStock;
    }

    public void setReplacedStock(Store replacedStock) {
        this.replacedStock = replacedStock;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    
    

}
