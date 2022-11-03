package com.certant.vtv.service.impl;


import com.certant.vtv.dto.VehicleDto;
import com.certant.vtv.dto.VehicleInspectionDto;
import com.certant.vtv.dto.VehicleTypeDto;
import com.certant.vtv.model.Measurement;
import com.certant.vtv.model.Observation;
import com.certant.vtv.model.Tariff;
import com.certant.vtv.model.VehicleInspection;
import com.certant.vtv.repository.TariffRepository;
import com.certant.vtv.repository.VehicleInspectionRepository;
import com.certant.vtv.repository.VehicleRepository;
import com.certant.vtv.service.VehicleInspectionService;
import com.certant.vtv.utils.Condition;
import com.certant.vtv.utils.CostumerType;
import com.certant.vtv.utils.VehicleType;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class VehicleInspectionServiceImpl implements VehicleInspectionService {

    private VehicleInspectionRepository vehicleInspectionRepository;
    private TariffRepository tariffRepository;
    private VehicleRepository vehicleRepository;
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
        setCost(vehicleInspection);
        return vehicleInspectionRepository.save(vehicleInspection);
    }

    @Override
    public VehicleInspectionDto getVehicleInspection(String id) {

        ModelMapper mapper = new ModelMapper();

        VehicleInspection vehicleInspection = vehicleInspectionRepository.findById(id).orElse(null);
        checkCondition(vehicleInspection);
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
            vehicleInspectionDto.setInspectionState(vehicleInspection.getConditionn());
            vehicleInspectionDtos.add(vehicleInspectionDto);
        });
        return vehicleInspectionDtos;
    }

    @Override
    public VehicleInspection updateVehicleInspection(String id, VehicleInspection vehicleInspection) {
        return null;
    }

    @Override
    public void deleteVehicleInspection(String id) {
        VehicleInspection vehicleInspection = vehicleInspectionRepository.findById(id).orElse(null);
        assert vehicleInspection != null;
        vehicleInspectionRepository.delete(vehicleInspection);
    }

    private void setState(Observation observation, Measurement measurement, VehicleInspection vehicleInspection){

       Condition obsCondition = observationService.validateObservations(observationService.checkObservations(observation));
       Condition measCondition = measureService.validateMeasurements(measureService.checkMeasurements(measurement));

       if(obsCondition == Condition.APPROVED && measCondition == Condition.APPROVED){
           vehicleInspection.setConditionn(Condition.APPROVED);
       } else if (obsCondition == Condition.REJECTED || measCondition == Condition.REJECTED) {
           vehicleInspection.setConditionn(Condition.REJECTED);
       }else{
           vehicleInspection.setConditionn(Condition.CONDITIONAL);
       }
    }
    
    
    // This method calculate the expiration date of the verification
    private void setExpirationDate(VehicleInspection vehicleInspection){
        if(vehicleInspection.getConditionn() == Condition.APPROVED){
            vehicleInspection.setExpirationDate(LocalDate.now().plusYears(1));
            //TODO: SOME METHOD TO PRINT THE TICKET
        } else if (vehicleInspection.getConditionn() == Condition.CONDITIONAL) {
            vehicleInspection.setExpirationDate(LocalDate.now().plusMonths(2));
            vehicleInspection.getVehicle().getCostumer().setCostumerType(CostumerType.EXEMPT);
        }
    }

    private void setCost(VehicleInspection vehicleInspection){
        if(!(vehicleInspection.getConditionn() == Condition.REJECTED) ){
            CostumerType costumerType = vehicleInspection.getVehicle().getCostumer().getCostumerType();
            if(costumerType == CostumerType.NORMAL){
                log.info("Vehicle id: " + vehicleInspection.getVehicle().getId());
                VehicleTypeDto vehicleTypeDto =  vehicleRepository.findByVehicleType(vehicleInspection.getVehicle().getId()).orElse(null);
                if(vehicleTypeDto != null){
                    String vehicleType = vehicleTypeDto.getVehicleType();
                    log.info("Vehicle type: " + vehicleType);
                    Tariff tariff = tariffRepository.findByVehicleType(VehicleType.valueOf(vehicleType));
                    log.info("Tarifa: " + tariff.getCost());
                    vehicleInspection.setCost(tariff.getCost());
                }

            }
        }
    }

    private void checkCondition(VehicleInspection vehicleInspection){
        if(LocalDate.now().isAfter(vehicleInspection.getExpirationDate())){
            vehicleInspection.setConditionn(Condition.REJECTED);
            vehicleInspection.getVehicle().getCostumer().setCostumerType(CostumerType.NORMAL);
            vehicleInspectionRepository.save(vehicleInspection);
        }
    }
}
