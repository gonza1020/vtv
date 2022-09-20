package com.certant.vtv.service;

import com.certant.vtv.model.Vehicle;

import java.util.List;

public interface VehicleService {
    Vehicle createCostumer(Vehicle vehicle);
    Vehicle getVehicle(Long id);
    List<Vehicle> getAll();
    Vehicle updateCostumer(Long id, Vehicle vehicle);
    void deleteVehicle(Long id);
}
