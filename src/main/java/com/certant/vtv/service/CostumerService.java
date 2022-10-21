package com.certant.vtv.service;

import com.certant.vtv.model.Costumer;

import java.util.List;

public interface CostumerService {

    Costumer createCostumer(Costumer costumer);
    Costumer getCostumer(String id);
    List<Costumer> getAll();
    Costumer updateCostumer(String id, Costumer costumer);
    void deleteCostumer(String id);
}
