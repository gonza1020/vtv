package com.certant.vtv.service.impl;

import com.certant.vtv.dto.VehicleDto;
import com.certant.vtv.dto.VehicleInspectionDto;
import com.certant.vtv.model.Car;
import com.certant.vtv.model.Vehicle;
import com.certant.vtv.repository.CarRepository;
import com.certant.vtv.repository.CycleRepository;
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

    private VehicleInspectionServiceImpl vehicleInspectionService;
    private VehicleRepository vehicleRepository;
    private CarRepository carRepository;
    private CycleRepository cycleRepository;
    private ModelMapper modelMapper;


    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }


    @Override
    public VehicleDto getVehicle(String id) {

        Vehicle vehicle = vehicleRepository.findById(id).orElse(null);

        VehicleDto vehicleDto = modelMapper.map(vehicle, VehicleDto.class);
        vehicleDto.setOwner(vehicle.getCostumer().getName() + " " + vehicle.getCostumer().getLastName());

        return vehicleDto;
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
    public Vehicle updateVehicle(String id, Vehicle vehicle) {
        return null;
    }

    @Override
    public void deleteVehicle(String id) {

        Vehicle vehicle = vehicleRepository.findById(id).orElse(null);
        assert vehicle != null;
        vehicleRepository.delete(vehicle);
    }

    public Car createCar(Car car){
        return vehicleRepository.save(car);
    }

    public List<VehicleDto> getVehiclesCondition(String condition){
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

}
