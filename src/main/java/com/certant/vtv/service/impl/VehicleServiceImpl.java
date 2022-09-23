package com.certant.vtv.service.impl;

import com.certant.vtv.model.Vehicle;
import com.certant.vtv.repository.VehicleRepository;
import com.certant.vtv.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private VehicleRepository vehicleRepository;
    @Override
    public Vehicle createVehicle(Vehicle vehicle) {

        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle getVehicle(Long id) {

        Optional<Vehicle> vehicle = vehicleRepository.findById(id);

        return vehicle.orElse(null);
    }

    @Override
    public List<Vehicle> getAll() {

        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle updateVehicle(Long id, Vehicle vehicle) {
        return null;
    }

    @Override
    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }
}
