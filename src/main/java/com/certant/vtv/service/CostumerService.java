package com.certant.vtv.service;

import com.certant.vtv.model.Costumer;

import java.util.List;

public interface CostumerService {

    Costumer createCostumer(Costumer costumer);
    Costumer getCostumer(Long id);
    List<Costumer> getAll();
    Costumer updateCostumer(Long id, Costumer costumer);
    void deleteCostumer(Long id);
}
