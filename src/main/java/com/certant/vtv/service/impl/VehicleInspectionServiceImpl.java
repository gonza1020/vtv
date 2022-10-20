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
        setExpirationDate(vehicleInspection);
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

    private void setState(Observation observation, Measurement measurement, VehicleInspection vehicleInspection){
       Condition obsCondition = observationService.validateObservations(observationService.checkObservations(observation));
       Condition measCondition = measureService.validateMeasurements(measureService.checkMeasurements(measurement));

       if(obsCondition == Condition.APPROVED && measCondition == Condition.APPROVED){
           vehicleInspection.setCondition(Condition.APPROVED);
       } else if (obsCondition == Condition.REJECTED || measCondition == Condition.REJECTED) {
           vehicleInspection.setCondition(Condition.REJECTED);
       }else{
           vehicleInspection.setCondition(Condition.CONDITIONAL);
       }
    }
    
    
    // This method calculate the expiration date of the verification
    private void setExpirationDate(VehicleInspection vehicleInspection){
        if(vehicleInspection.getCondition() == Condition.APPROVED){
            vehicleInspection.setExpirationDate(LocalDate.now().plusYears(1));
            //TODO: SOME METHOD TO PRINT THE TICKET
        } else if (vehicleInspection.getCondition() == Condition.CONDITIONAL) {
            vehicleInspection.setExpirationDate(LocalDate.now().plusMonths(2));
        }
    }
}
