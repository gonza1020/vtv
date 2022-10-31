package com.certant.vtv.service.impl;

import com.certant.vtv.model.*;
import com.certant.vtv.repository.TariffRepository;
import com.certant.vtv.repository.VehicleInspectionRepository;
import com.certant.vtv.repository.VehicleRepository;
import com.certant.vtv.utils.Condition;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class VehicleInspectionServiceImplTest {

    @MockBean
    private VehicleInspectionRepository vehicleInspectionRepository;
    @MockBean
    private TariffRepository tariffRepository;
    @MockBean
    private VehicleRepository vehicleRepository;
    @MockBean
    private ObservationServiceImpl observationService;
    @MockBean
    private MeasureServiceImpl measureService;
    @MockBean
    private ModelMapper modelMapper;

    private VehicleInspectionServiceImpl vehicleInspectionService;

    void setUp(){
        vehicleInspectionService = new VehicleInspectionServiceImpl(vehicleInspectionRepository,tariffRepository,vehicleRepository,observationService,measureService,modelMapper);
    }

    private static VehicleInspection getVehicleInspection(){
        VehicleInspection vehicleInspection = new VehicleInspection();
        vehicleInspection.setVehicle(mock(Vehicle.class));
        vehicleInspection.setCost(1234.35);
        vehicleInspection.setObservation(mock(Observation.class));
        vehicleInspection.setMeasurement(mock(Measurement.class));
        vehicleInspection.setExpirationDate(LocalDate.now().plusYears(1));
        vehicleInspection.setConditionn(Condition.APPROVED);
        vehicleInspection.setInspector(mock(Inspector.class));
        vehicleInspection.setId("1234567");
        return null;
    }
    @Test
    void createVehicleInspection() {
        VehicleInspection vehicleInspection;
    }



    @Test
    void getAll() {
    }

    @Test
    void deleteVehicleInspection() {
    }
}