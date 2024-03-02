package com.IT.Stock.Model;

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
    @Column(name = "indentNo")
    private String indenNo;
    @Column(name = "grnNumber")
    private String grnNo;
    @Column(name = "new_replacement")
    private String newReplacement;
    @Column(name = "defectSerialNumber")
    private String defectSerialNumber;
    @Column(name = "outpass")
    private String outPass;
    @ManyToOne
    @JoinColumn(name = "itemId")
    private Item item;
    @ManyToOne
    @JoinColumn(name = "storeid")    
    private Store store;

    public Outward() {
    }
    
    public Outward(long outwardId, String toCampus, String toCity, String toDepartment, String approvedBy,
            String indenNo, String grnNo, String newReplacement, String defectSerialNumber, String outPass, Item item,
            Store store) {
        this.outwardId = outwardId;
        this.toCampus = toCampus;
        this.toCity = toCity;
        this.toDepartment = toDepartment;
        this.approvedBy = approvedBy;
        this.indenNo = indenNo;
        this.grnNo = grnNo;
        this.newReplacement = newReplacement;
        this.defectSerialNumber = defectSerialNumber;
        this.outPass = outPass;
        this.item = item;
        this.store = store;
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
    public String getIndenNo() {
        return indenNo;
    }
    public void setIndenNo(String indenNo) {
        this.indenNo = indenNo;
    }
    public String getGrnNo() {
        return grnNo;
    }
    public void setGrnNo(String grnNo) {
        this.grnNo = grnNo;
    }
    public String getNewReplacement() {
        return newReplacement;
    }
    public void setNewReplacement(String newReplacement) {
        this.newReplacement = newReplacement;
    }
    public String getDefectSerialNumber() {
        return defectSerialNumber;
    }
    public void setDefectSerialNumber(String defectSerialNumber) {
        this.defectSerialNumber = defectSerialNumber;
    }
    public String getOutPass() {
        return outPass;
    }
    public void setOutPass(String outPass) {
        this.outPass = outPass;
    }
    public Item getItem() {
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }
    public Store getStore() {
        return store;
    }
    public void setStore(Store store) {
        this.store = store;
    }
 
}
