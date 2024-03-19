package com.IT.Stock.Repository;

import java.util.ArrayList;

import com.IT.Stock.Model.DefectItemService;

public interface DefectItemRepository {
    ArrayList<DefectItemService> getAllDefectItems();
    DefectItemService addItemService(DefectItemService defectItemService);
}
