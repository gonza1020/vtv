package com.certant.vtv.service.impl;

import com.certant.vtv.DataTest;
import com.certant.vtv.dto.VehicleDto;
import com.certant.vtv.model.Costumer;
import com.certant.vtv.model.Vehicle;
import com.certant.vtv.repository.VehicleRepository;
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

import java.util.ArrayList;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ContextConfiguration(classes = {VehicleServiceImpl.class})
@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration( DisplayNameGenerator.ReplaceUnderscores.class )
class VehicleServiceImplTest {

    @MockBean
    private VehicleRepository vehicleRepository;
    @MockBean
    private VehicleInspectionServiceImpl vehicleInspectionService;

    @SpyBean
    private ModelMapper modelMapper;

    @InjectMocks
    private VehicleServiceImpl vehicleServiceImpl;

    @BeforeEach
    void setUp(){
        // Inyecto dependencias con mockito
        //vehicleServiceImpl = new VehicleServiceImpl(vehicleInspectionService,vehicleRepository,modelMapper);
    }


    @Test
    void createVehicle() {

        Costumer costumer = DataTest.getCostumer();
        Vehicle vehicle = DataTest.getVehicle(costumer);

        when(vehicleRepository.save(any(Vehicle.class))).thenReturn(vehicle);

        assertThat(vehicleServiceImpl.createVehicle(vehicle)).isNotNull();
        verify(vehicleRepository).save(vehicle);
    }

    @Test
    void obtener_vehiculo() {
        Costumer costumer = DataTest.getCostumer();
        Vehicle vehicle = DataTest.getVehicle(costumer);

        //given
        // Stubbing del mock vehicle repository
        // Preparo cel entorno de prueba
        when(vehicleRepository.findById(anyString())).thenReturn(Optional.of(vehicle));

        // Ejecuto la prueba
        assertThat(vehicleServiceImpl.getVehicle("123")).isNotNull();
        verify(modelMapper,atLeast(1)).map(any(),any());
        verify(vehicleRepository).findById(any());

    }



    @Test
    void getAll_listar_y_no_econtrar_nada_devuelve_lista_vacia() {

        when(vehicleRepository.findAll()).thenReturn(new ArrayList<>());
        assertThat(vehicleServiceImpl.getAll()).isEmpty();
        verify(vehicleRepository).findAll();
    }

    @Test
    void getAll_listar_y_devolver_elemntos_presentes() {

        ArrayList<Vehicle> vehicles = new ArrayList<>();
        Costumer costumer = DataTest.getCostumer();
        Vehicle vehicle = DataTest.getVehicle(costumer);

        Costumer costumer1 = DataTest.getCostumer();
        Vehicle vehicle1 = DataTest.getVehicle(costumer1);

        vehicles.add(vehicle);
        vehicles.add(vehicle1);

        when(vehicleRepository.findAll()).thenReturn(vehicles);
        assertEquals(2,vehicleServiceImpl.getAll().size());
        verify(modelMapper,atLeast(2)).map(any(),any());
        verify(vehicleRepository).findAll();
    }
    @Test
    void getAll_devolver_exactamente_los_elementos_presentes(){
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        Costumer costumer = DataTest.getCostumer();
        Vehicle vehicle = DataTest.getVehicle(costumer);

        Costumer costumer1 = DataTest.getCostumer();
        Vehicle vehicle1 = DataTest.getVehicle(costumer1);

        vehicles.add(vehicle);
        vehicles.add(vehicle1);


        when(vehicleRepository.findAll()).thenReturn(vehicles);
        assertThat(vehicleServiceImpl.getAll()).isExactlyInstanceOf(ArrayList.class);
        verify(modelMapper,atLeast(2)).map(any(),any());
        verify(vehicleRepository).findAll();
    }

    @Test
    void updateVehicle() {

    }

    @Test
    void deleteVehicle_encuentra_y_lo_elimina() {

        Costumer costumer = DataTest.getCostumer();
        Vehicle vehicle = DataTest.getVehicle(costumer);

        Optional<Vehicle> result = Optional.of(vehicle);

        // Preparo mocks para ejecutar los tests
        when(vehicleRepository.findById(anyString())).thenReturn(result);
        doNothing().when(vehicleRepository).delete(any());

        vehicleServiceImpl.deleteVehicle("123");

        verify(vehicleRepository).findById(anyString());
        verify(vehicleRepository).delete(any());
    }

    @Test
    void findByLicensePlate() {

        Costumer costumer = DataTest.getCostumer();
        Vehicle vehicle = DataTest.getVehicle(costumer);

        when(vehicleRepository.findByLicensePlate(anyString())).thenReturn(vehicle);

        assertThat(vehicleServiceImpl.findByLicensePlate(anyString())).isExactlyInstanceOf(VehicleDto.class);

        verify(vehicleRepository).findByLicensePlate(anyString());
        verify(modelMapper,atLeast(1)).map(any(),any());
    }

    @Test
    void testUpdateVehicle_al_no_encontrar_no_hacer_nada() {

        when(vehicleRepository.save(any())).thenReturn(Optional.empty());
        when(vehicleRepository.findByVehicleType(anyString())).thenReturn(Optional.empty());


        vehicleServiceImpl.updateVehicle("123",any());
        verify(vehicleRepository).findByVehicleType(anyString());
        verify(vehicleRepository, atMost(0)).save(any());
    }

    @Test
    void updateCAR_devolver_vehiculo_actualziado(){

    }

    @Test
    void getVehiclesCondition() {
        when(vehicleInspectionService.getAll()).thenReturn(new ArrayList());
    }
}