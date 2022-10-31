package com.certant.vtv.service.impl;

import com.certant.vtv.model.VehicleData;
import com.certant.vtv.repository.VehicleDataRepository;
import com.certant.vtv.service.VehicleDataService;
import com.certant.vtv.utils.VehicleType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VehicleDataServiceImpl implements VehicleDataService {


    private VehicleDataRepository vehicleDataRepository;
    @Override
    public VehicleData createVehicleData(VehicleData vehicleData) {
        return null;
    }

    @Override
    public VehicleData getVehicleData(String id) {
        return null;
    }

    @Override
    public List<VehicleData> getAll() {

        return vehicleDataRepository.findAll();
    }

    public List<String> findByVehicleType(String vehicleType){
        vehicleType = vehicleType.toUpperCase();
        return vehicleDataRepository.findByVehicleType(vehicleType);
    }

    public List<String> findByBrand(String brand){
        return vehicleDataRepository.findByBrand(brand);
    }
    @Override
    public VehicleData updateVehicleData(String id, VehicleData vehicleData) {
        return null;
    }

    @Override
    public void deleteVehicleData(String id) {

    }

    public List<String> getVehicleType() {
            return vehicleDataRepository.findVehicleType();
    }
}
