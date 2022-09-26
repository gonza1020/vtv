package com.certant.vtv.service;

import com.certant.vtv.dto.VehicleInspectionDto;
import com.certant.vtv.model.Costumer;
import com.certant.vtv.model.VehicleInspection;

import java.util.List;

public interface VehicleInspectionService {
    VehicleInspection createVehicleInspection(VehicleInspection vehicleInspection);
    VehicleInspectionDto getVehicleInspection(Long id);
    List<VehicleInspectionDto> getAll();
    VehicleInspection updateVehicleInspection(Long id, VehicleInspection vehicleInspection);
    void deleteVehicleInspection(Long id);
}
