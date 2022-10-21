package com.certant.vtv.service;

import com.certant.vtv.dto.VehicleInspectionDto;
import com.certant.vtv.model.Costumer;
import com.certant.vtv.model.VehicleInspection;

import java.util.List;

public interface VehicleInspectionService {
    VehicleInspection createVehicleInspection(VehicleInspection vehicleInspection);
    VehicleInspectionDto getVehicleInspection(String id);
    List<VehicleInspectionDto> getAll();
    VehicleInspection updateVehicleInspection(String id, VehicleInspection vehicleInspection);
    void deleteVehicleInspection(String id);
}
