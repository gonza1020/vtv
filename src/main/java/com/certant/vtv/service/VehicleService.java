package com.certant.vtv.service;

import com.certant.vtv.dto.VehicleDto;
import com.certant.vtv.model.Vehicle;

import java.util.List;

public interface VehicleService {
    Vehicle createVehicle(Vehicle vehicle);
    VehicleDto getVehicle(String id);
    List<VehicleDto> getAll();
    Vehicle updateVehicle(String id, Vehicle vehicle);
    void deleteVehicle(String id);
}
