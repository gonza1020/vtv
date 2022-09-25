package com.certant.vtv.service.impl;

import com.certant.vtv.dto.VehicleDto;
import com.certant.vtv.model.Vehicle;
import com.certant.vtv.repository.VehicleRepository;
import com.certant.vtv.service.VehicleService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private VehicleRepository vehicleRepository;
    private ModelMapper modelMapper;

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
    public List<VehicleDto> getAll() {
        List<VehicleDto> vehicleDtos = new ArrayList<>();

        vehicleRepository.findAll().forEach(vehicle -> {
            VehicleDto vehicleDto = modelMapper.map(vehicle, VehicleDto.class);
            vehicleDto.setOwner(vehicle.getCostumer().getName() + " " + vehicle.getCostumer().getLastName());
            vehicleDtos.add(vehicleDto);
        });
        return vehicleDtos;
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
