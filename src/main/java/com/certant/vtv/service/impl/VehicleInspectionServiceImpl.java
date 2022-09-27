package com.certant.vtv.service.impl;


import com.certant.vtv.dto.VehicleDto;
import com.certant.vtv.dto.VehicleInspectionDto;
import com.certant.vtv.model.Measurement;
import com.certant.vtv.model.Observation;
import com.certant.vtv.model.VehicleInspection;
import com.certant.vtv.repository.VehicleInspectionRepository;
import com.certant.vtv.service.VehicleInspectionService;
import com.certant.vtv.utils.Condition;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class VehicleInspectionServiceImpl implements VehicleInspectionService {

    private VehicleInspectionRepository vehicleInspectionRepository;
    private ObservationServiceImpl observationService;
    private MeasureServiceImpl measureService;
    private ModelMapper modelMapper;


    @Override
    public VehicleInspection createVehicleInspection(VehicleInspection vehicleInspection) {
        Observation observation = vehicleInspection.getObservation();
        Measurement measurement = vehicleInspection.getMeasurement();
        setState(observation,measurement,vehicleInspection);
        vehicleInspection.setInspectionDate(LocalDate.now());
        if(vehicleInspection.getState() == Condition.APPROVED){
            vehicleInspection.setExpirationDate(LocalDate.now().plusYears(1));
            //TODO: SOME METHOD TO PRINT THE TICKET
        }
        return vehicleInspectionRepository.save(vehicleInspection);
    }

    @Override
    public VehicleInspectionDto getVehicleInspection(Long id) {

        ModelMapper mapper = new ModelMapper();
        VehicleInspection vehicleInspection = vehicleInspectionRepository.findById(id).orElse(null);

        VehicleInspectionDto vehicleInspectionDto = mapper.map(vehicleInspection,VehicleInspectionDto.class);
        VehicleDto vehicleDto = mapper.map(vehicleInspection.getVehicle(),VehicleDto.class);
        vehicleDto.setOwner(vehicleInspection.getVehicle().getCostumer().getName() + " " + vehicleInspection.getVehicle().getCostumer().getLastName());


        vehicleInspectionDto.setCostumerType(vehicleInspection.getVehicle().getCostumer().getCostumerType());
        vehicleInspectionDto.setInspectorName(vehicleInspection.getInspector().getName() + " " + vehicleInspection.getInspector().getLastName());
        vehicleInspectionDto.setVehicleDto(vehicleDto);

        return vehicleInspectionDto;
    }

    @Override
    public List<VehicleInspectionDto> getAll() {
        List<VehicleInspectionDto> vehicleInspectionDtos = new ArrayList<>();
        ModelMapper mapper = new ModelMapper();

        vehicleInspectionRepository.findAll().forEach(vehicleInspection -> {
            VehicleInspectionDto vehicleInspectionDto = mapper.map(vehicleInspection,VehicleInspectionDto.class);
            VehicleDto vehicleDto = mapper.map(vehicleInspection.getVehicle(),VehicleDto.class);
            vehicleDto.setOwner(vehicleInspection.getVehicle().getCostumer().getName() + " " + vehicleInspection.getVehicle().getCostumer().getLastName());

            vehicleInspectionDto.setCostumerType(vehicleInspection.getVehicle().getCostumer().getCostumerType());
            vehicleInspectionDto.setInspectorName(vehicleInspection.getInspector().getName() + " " + vehicleInspection.getInspector().getLastName());
            vehicleInspectionDto.setVehicleDto(vehicleDto);
            vehicleInspectionDtos.add(vehicleInspectionDto);
        });
        return vehicleInspectionDtos;
    }

    @Override
    public VehicleInspection updateVehicleInspection(Long id, VehicleInspection vehicleInspection) {
        return null;
    }

    @Override
    public void deleteVehicleInspection(Long id) {
        VehicleInspection vehicleInspection = vehicleInspectionRepository.findById(id).orElse(null);
        assert vehicleInspection != null;
        vehicleInspectionRepository.delete(vehicleInspection);
    }

    public void setState(Observation observation, Measurement measurement, VehicleInspection vehicleInspection){
       Condition obsState = observationService.validateObservations(observationService.checkObservations(observation));
       Condition measState = measureService.validateMeasurements(measureService.checkMeasurements(measurement));

       if(obsState == Condition.APPROVED && measState == Condition.APPROVED){
           vehicleInspection.setState(Condition.APPROVED);
       } else if (obsState == Condition.REJECTED || measState == Condition.REJECTED) {
           vehicleInspection.setState(Condition.REJECTED);
       }else{
           vehicleInspection.setState(Condition.CONDITIONAL);
       }
    }
}
