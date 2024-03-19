package com.IT.Stock.Repository;

import java.util.ArrayList;

import com.IT.Stock.Model.Vendor;

public interface VendorRepository {
    ArrayList<Vendor> getAllVendors();
    Vendor addVendor(Vendor vendor);
}
