package com.certant.vtv.service;

import com.certant.vtv.model.VehicleData;

import java.util.List;

public interface VehicleDataService {
    VehicleData createVehicleData(VehicleData vehicleData);
    VehicleData getVehicleData(String id);
    List<VehicleData> getAll();
    VehicleData updateVehicleData(String id, VehicleData vehicleData);
    void deleteVehicleData(String id);
}
