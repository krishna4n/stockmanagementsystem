package com.IT.Stock.Model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "outward")
public class Outward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "outwardid")
    private long outwardId;
    @Column(name = "tocampus")
    private String toCampus;
    @Column(name = "tocity")
    private String toCity;
    @Column(name = "todepartment")
    private String toDepartment;
    @Column(name = "approvedBy")
    private String approvedBy;
    @Column(name = "indent")
    private String indent;
    @Column(name = "grn")
    private String grn;
    @Column(name = "newreplacement")
    private String newReplacement;
    @Column(name = "faultyserialnumber")
    private String faultySerialNumber;
    @Column(name = "outpass")
    private String outPass;
    @Column(name = "quantity")
    private long quantity;
    @Column(name = "outwarddate")
    private Date outwardDate;
    @ManyToOne
    @JoinColumn(name = "storeid")    
    private Store store;
    @Column(name = "inwardid")
    private String inwardId;

    public Outward() {
    }
    
    public Outward(long outwardId, String toCampus, String toCity, String toDepartment, String approvedBy,
            String indent,Date outwardDate, String grn, String newReplacement,long quantity, String faultySerialNumber, String outPass, Store store, String inwardId)
            {
        this.outwardId = outwardId;
        this.toCampus = toCampus;
        this.toCity = toCity;
        this.toDepartment = toDepartment;
        this.approvedBy = approvedBy;
        this.indent = indent;
        this.grn = grn;
        this.newReplacement = newReplacement;
        this.faultySerialNumber = faultySerialNumber;
        this.outPass = outPass;
        this.store = store;
        this.quantity = quantity;
        this.outwardDate = outwardDate;
        this.inwardId = inwardId;
    }
  
    public long getOutwardId() {
        return outwardId;
    }
    public void setOutwardId(long outwardId) {
        this.outwardId = outwardId;
    }
    public String getToCampus() {
        return toCampus;
    }
    public void setToCampus(String toCampus) {
        this.toCampus = toCampus;
    }
    public String getToCity() {
        return toCity;
    }
    public void setToCity(String toCity) {
        this.toCity = toCity;
    }
    public String getToDepartment() {
        return toDepartment;
    }
    public void setToDepartment(String toDepartment) {
        this.toDepartment = toDepartment;
    }
    public String getApprovedBy() {
        return approvedBy;
    }
    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }
    public String getIndent() {
        return indent;
    }
    public void setIndent(String indent) {
        this.indent = indent;
    }
    public String getGrn() {
        return grn;
    }
    public void setGrn(String grn) {
        this.grn = grn;
    }
    public String getNewReplacement() {
        return newReplacement;
    }
    public void setNewReplacement(String newReplacement) {
        this.newReplacement = newReplacement;
    }
    public String getOutPass() {
        return outPass;
    }
    public void setOutPass(String outPass) {
        this.outPass = outPass;
    }
   
    public Store getStore() {
        return store;
    }
    public void setStore(Store store) {
        this.store = store;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public Date getOutwardDate() {
        return outwardDate;
    }

    public void setOutwardDate(Date outwardDate) {
        this.outwardDate = outwardDate;
    }

    public String getFaultySerialNumber() {
        return faultySerialNumber;
    }

    public void setFaultySerialNumber(String faultySerialNumber) {
        this.faultySerialNumber = faultySerialNumber;
    }

    public String getInwardId() {
        return inwardId;
    }

    public void setInwardId(String inwardId) {
        this.inwardId = inwardId;
    }
 
}
