package com.certant.vtv.service;

import com.certant.vtv.dto.VehicleDto;
import com.certant.vtv.model.Vehicle;

import java.util.List;

public interface VehicleService {
    Vehicle createVehicle(Vehicle vehicle);
    Vehicle getVehicle(Long id);
    List<VehicleDto> getAll();
    Vehicle updateVehicle(Long id, Vehicle vehicle);
    void deleteVehicle(Long id);
}
