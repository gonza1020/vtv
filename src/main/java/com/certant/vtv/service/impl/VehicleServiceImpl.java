package com.certant.vtv.service.impl;

import com.certant.vtv.dto.VTypeDto;
import com.certant.vtv.dto.VehicleDto;
import com.certant.vtv.dto.VehicleInspectionDto;
import com.certant.vtv.dto.VehicleTypeDto;
import com.certant.vtv.model.Car;
import com.certant.vtv.model.Cycle;
import com.certant.vtv.model.Vehicle;
import com.certant.vtv.repository.VehicleRepository;
import com.certant.vtv.service.VehicleService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class VehicleServiceImpl implements VehicleService {


    private VehicleInspectionServiceImpl vehicleInspectionService;
    private VehicleRepository vehicleRepository;
    private ModelMapper modelMapper;


    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }


    @Override
    public VehicleDto getVehicle(String id) {
        Vehicle vehicle = vehicleRepository.findById(id).orElse(null);
        return mapVehicle(vehicle);
    }

    @Override
    public List<VehicleDto> getAll() {
        List<VehicleDto> vehicleDtos = new ArrayList<>();
        vehicleRepository.findAll().forEach(vehicle -> {
            vehicleDtos.add(mapVehicle(vehicle));
        });
        return vehicleDtos;
    }

    @Override
    public Vehicle updateVehicle(String id, VTypeDto vehicle) {
        VehicleTypeDto vehicleTypeDto = vehicleRepository.findByVehicleType(id).orElse(null);

        if(vehicleTypeDto != null){
            String vehicleType = vehicleTypeDto.getVehicleType();
            if (vehicleType.equals("CAR")) {
                Car car = modelMapper.map(vehicle, Car.class);
                car.setId(id);
                return vehicleRepository.save(car);
            }
            if (vehicleType.equals("CYCLE")) {
                Cycle cycle = modelMapper.map(vehicle, Cycle.class);
                cycle.setId(id);
                return vehicleRepository.save(cycle);
            }
        }
        return null;
    }

    @Override
    public void deleteVehicle(String id) {

        Vehicle vehicle = vehicleRepository.findById(id).orElse(null);
        assert vehicle != null;
        vehicleRepository.delete(vehicle);
    }

    public VehicleDto findByLicensePlate(String licensePlate) {
        return mapVehicle(vehicleRepository.findByLicensePlate(licensePlate));
    }

    public Car createCar(Car car) {
        return vehicleRepository.save(car);
    }

    public Cycle createCycle(Cycle cycle) {
        return vehicleRepository.save(cycle);
    }

    public List<VehicleDto> getVehiclesCondition(String condition) {
        List<VehicleInspectionDto> vehicleInspectionDtos = vehicleInspectionService.getAll();
        List<VehicleDto> vehicleDtos = new ArrayList<>();
        List<VehicleInspectionDto> vehicleInspectionDtos1 = vehicleInspectionDtos.stream()
                .filter(vehicleInspectionDto -> vehicleInspectionDto.getInspectionState().toString().equals(condition.toUpperCase()))
                .toList();

        vehicleInspectionDtos1.forEach(vehicleInspectionDto -> {
            vehicleDtos.add(vehicleInspectionDto.getVehicleDto());
        });
        return vehicleDtos;
    }

    private VehicleDto mapVehicle(Vehicle vehicle) {
        VehicleDto vehicleDto = modelMapper.map(vehicle, VehicleDto.class);
        vehicleDto.setOwner(vehicle.getCostumer().getName() + " " + vehicle.getCostumer().getLastName());
        return vehicleDto;
    }

}
