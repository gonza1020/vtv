package com.certant.vtv.service;

import com.certant.vtv.model.Costumer;
import com.certant.vtv.model.VehicleInspection;

import java.util.List;

public interface VehicleInspectionService {
    VehicleInspection createVehicleInspection(VehicleInspection vehicleInspection);
    VehicleInspection getVehicleInspection(Long id);
    List<VehicleInspection> getAll();
    VehicleInspection updateVehicleInspection(Long id, VehicleInspection vehicleInspection);
    void deleteVehicleInspection(Long id);
}
