package com.certant.vtv.service.impl;

import com.certant.vtv.DataTest;
import com.certant.vtv.model.*;
import com.certant.vtv.repository.TariffRepository;
import com.certant.vtv.repository.VehicleInspectionRepository;
import com.certant.vtv.repository.VehicleRepository;
import com.certant.vtv.utils.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {VehicleInspectionServiceImpl.class})
@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration( DisplayNameGenerator.ReplaceUnderscores.class )
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
    @SpyBean
    private ModelMapper modelMapper;


    @InjectMocks
    private VehicleInspectionServiceImpl vehicleInspectionService;

    @BeforeEach
    void setUp(){
        // MockitoAnnotations.openMocks(this);
    }


    @Test
    void createVehicleInspection_y_devolver_inspeccion() {

        Costumer costumer = DataTest.getCostumer();
        Vehicle vehicle = DataTest.getVehicle(costumer);

        VehicleInspection vehicleInspection = DataTest.getVehicleInspection(vehicle);

        when(vehicleInspectionRepository.save(any(VehicleInspection.class))).thenReturn(vehicleInspection);

        vehicleInspectionService.createVehicleInspection(vehicleInspection);


        verify(vehicleInspectionRepository).save(any(VehicleInspection.class));

    }

    @Test
    void createVehicleInspection_y_verificar_condicion_aprobado() {

        Costumer costumer = DataTest.getCostumer();
        Vehicle vehicle = DataTest.getVehicle(costumer);

        VehicleInspection vehicleInspection = DataTest.getVehicleInspection(vehicle);

        when(vehicleInspectionRepository.save(any(VehicleInspection.class))).thenReturn(vehicleInspection);
        when(observationService.validateObservations(any())).thenReturn(Condition.APPROVED);
        when(measureService.validateMeasurements(any())).thenReturn(Condition.APPROVED);

        vehicleInspectionService.createVehicleInspection(vehicleInspection);

        LocalDate now = LocalDate.now();

        assertEquals("APPROVED", vehicleInspection.getConditionn().toString());
        // chequear si actualiza fecha de vencimiento
        assertThat(now.plusYears(1)).isEqualTo(vehicleInspection.getExpirationDate());

        verify(vehicleInspectionRepository).save(any(VehicleInspection.class));

    }

    @Test
    void createVehicleInspection_y_verificar_condicion_condicional() {

        Costumer costumer = DataTest.getCostumer();
        Vehicle vehicle = DataTest.getVehicle(costumer);

        VehicleInspection vehicleInspection = DataTest.getVehicleInspection(vehicle);

        when(vehicleInspectionRepository.save(any(VehicleInspection.class))).thenReturn(vehicleInspection);
        when(observationService.validateObservations(any())).thenReturn(Condition.CONDITIONAL);
        when(measureService.validateMeasurements(any())).thenReturn(Condition.APPROVED);

        vehicleInspectionService.createVehicleInspection(vehicleInspection);
        LocalDate now = LocalDate.now();

        assertEquals("CONDITIONAL", vehicleInspection.getConditionn().toString());
        assertThat(now.plusMonths(2)).isEqualTo(vehicleInspection.getExpirationDate());

        verify(vehicleInspectionRepository).save(any(VehicleInspection.class));

    }

    @Test
    void createVehicleInspection_y_verificar_condicion_rechazado() {

        Costumer costumer = DataTest.getCostumer();
        Vehicle vehicle = DataTest.getVehicle(costumer);

        VehicleInspection vehicleInspection = DataTest.getVehicleInspection(vehicle);

        when(vehicleInspectionRepository.save(any(VehicleInspection.class))).thenReturn(vehicleInspection);
        when(observationService.validateObservations(any())).thenReturn(Condition.REJECTED);
        when(measureService.validateMeasurements(any())).thenReturn(Condition.APPROVED);

        vehicleInspectionService.createVehicleInspection(vehicleInspection);

        assertEquals("REJECTED", vehicleInspection.getConditionn().toString());
        assertThat(vehicleInspection.getExpirationDate()).isNull();

        verify(vehicleInspectionRepository).save(any(VehicleInspection.class));

    }


    @Test
    void getAll() {
    }

    @Test
    void deleteVehicleInspection() {
    }
}