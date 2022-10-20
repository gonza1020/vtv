/*
package com.certant.vtv.utils;

import com.certant.vtv.dto.VehicleDto;
import com.certant.vtv.model.*;
import com.certant.vtv.repository.*;
import com.certant.vtv.service.VehicleService;
import com.certant.vtv.service.impl.VehicleInspectionServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Component
public class VehicleInspectionSeeder {

    private VehicleInspectionServiceImpl vehicleInspectionService;

    private MeasurementRepository measurementRepository ;
    private ObservationRepository observationRepository;
    private InspectorRepository inspectorRepository;

    private VehicleService vehicleService;
    private VehicleRepository vehicleRepository;



    public void saveMeasurement(){

        if(measurementRepository.count() == 0){
            Measurement measurement = new Measurement(null,null,Condition.APPROVED,Condition.APPROVED,Condition.APPROVED,Condition.APPROVED);
            Measurement measurement1 = new Measurement(null,null,Condition.APPROVED,Condition.APPROVED,Condition.APPROVED,Condition.APPROVED);
            Measurement measurement2 = new Measurement(null,null,Condition.APPROVED,Condition.APPROVED,Condition.REJECTED,Condition.APPROVED);
            Measurement measurement3 = new Measurement(null,null,Condition.APPROVED,Condition.REJECTED,Condition.APPROVED,Condition.APPROVED);
            Measurement measurement4 = new Measurement(null,null,Condition.APPROVED,Condition.APPROVED,Condition.APPROVED,Condition.APPROVED);
            Measurement measurement5 = new Measurement(null,null,Condition.APPROVED,Condition.APPROVED,Condition.APPROVED,Condition.APPROVED);
            Measurement measurement6 = new Measurement(null,null,Condition.APPROVED,Condition.APPROVED,Condition.APPROVED,Condition.APPROVED);
            Measurement measurement7 = new Measurement(null,null,Condition.APPROVED,Condition.CONDITIONAL,Condition.APPROVED,Condition.APPROVED);
            Measurement measurement8 = new Measurement(null,null,Condition.CONDITIONAL,Condition.APPROVED,Condition.APPROVED,Condition.APPROVED);
            Measurement measurement9 = new Measurement(null,null,Condition.APPROVED,Condition.APPROVED,Condition.APPROVED,Condition.APPROVED);

            measurementRepository.save(measurement);
            measurementRepository.save(measurement1);
            measurementRepository.save(measurement2);
            measurementRepository.save(measurement3);
            measurementRepository.save(measurement4);
            measurementRepository.save(measurement5);
            measurementRepository.save(measurement6);
            measurementRepository.save(measurement7);
            measurementRepository.save(measurement8);
            measurementRepository.save(measurement9);
        }
    }

    public void saveObservation(){
    if(observationRepository.count() == 0){
        Observation observation = Observation.builder()
                .chassis(Condition.APPROVED)
                .glasses(Condition.APPROVED)
                .licensePlate(Condition.APPROVED)
                .lights(Condition.APPROVED)
                .securityVehicle(Condition.APPROVED)
                .mirrors(Condition.APPROVED)
                .description("AS")
                .build();

        Observation observation1 = Observation.builder()
                .chassis(Condition.APPROVED)
                .glasses(Condition.APPROVED)
                .licensePlate(Condition.APPROVED)
                .lights(Condition.APPROVED)
                .securityVehicle(Condition.APPROVED)
                .mirrors(Condition.APPROVED)
                .description("AS")
                .build();

        Observation observation2 = Observation.builder()
                .chassis(Condition.APPROVED)
                .glasses(Condition.APPROVED)
                .licensePlate(Condition.APPROVED)
                .lights(Condition.APPROVED)
                .securityVehicle(Condition.APPROVED)
                .mirrors(Condition.APPROVED)
                .description("AS")
                .build();

        Observation observation3 = Observation.builder()
                .chassis(Condition.APPROVED)
                .glasses(Condition.APPROVED)
                .licensePlate(Condition.APPROVED)
                .lights(Condition.APPROVED)
                .securityVehicle(Condition.APPROVED)
                .mirrors(Condition.APPROVED)
                .description("AS")
                .build();

        Observation observation4 = Observation.builder()
                .chassis(Condition.APPROVED)
                .glasses(Condition.APPROVED)
                .licensePlate(Condition.APPROVED)
                .lights(Condition.APPROVED)
                .securityVehicle(Condition.APPROVED)
                .mirrors(Condition.APPROVED)
                .description("AS")
                .build();

        Observation observation5 = Observation.builder()
                .chassis(Condition.APPROVED)
                .glasses(Condition.APPROVED)
                .licensePlate(Condition.APPROVED)
                .lights(Condition.APPROVED)
                .securityVehicle(Condition.APPROVED)
                .mirrors(Condition.APPROVED)
                .description("AS")
                .build();

        Observation observation6 = Observation.builder()
                .chassis(Condition.APPROVED)
                .glasses(Condition.APPROVED)
                .licensePlate(Condition.APPROVED)
                .lights(Condition.APPROVED)
                .securityVehicle(Condition.APPROVED)
                .mirrors(Condition.APPROVED)
                .description("AS")
                .build();

        Observation observation7 = Observation.builder()
                .chassis(Condition.APPROVED)
                .glasses(Condition.APPROVED)
                .licensePlate(Condition.APPROVED)
                .lights(Condition.APPROVED)
                .securityVehicle(Condition.CONDITIONAL)
                .mirrors(Condition.APPROVED)
                .description("AS")
                .build();

        Observation observation8 = Observation.builder()
                .chassis(Condition.APPROVED)
                .glasses(Condition.APPROVED)
                .licensePlate(Condition.APPROVED)
                .lights(Condition.APPROVED)
                .securityVehicle(Condition.APPROVED)
                .mirrors(Condition.APPROVED)
                .description("AS")
                .build();

        Observation observation9 = Observation.builder()
                .chassis(Condition.APPROVED)
                .glasses(Condition.APPROVED)
                .licensePlate(Condition.APPROVED)
                .lights(Condition.APPROVED)
                .securityVehicle(Condition.APPROVED)
                .mirrors(Condition.REJECTED)
                .description("AS")
                .build();



        observationRepository.save(observation);
        observationRepository.save(observation1);
        observationRepository.save(observation2);
        observationRepository.save(observation3);
        observationRepository.save(observation4);
        observationRepository.save(observation5);
        observationRepository.save(observation6);
        observationRepository.save(observation7);
        observationRepository.save(observation8);
        observationRepository.save(observation9);
    }

    }

    public void saveInspection(){

        VehicleInspection vehicleInspection = new VehicleInspection();


        Vehicle vehicle = vehicleRepository.findById(1L).orElse(null);
        Inspector inspector = inspectorRepository.findById(1L).orElse(null);
        Measurement measurement = measurementRepository.findById(1L).orElse(null);
        Observation observation = observationRepository.findById(1L).orElse(null);

        vehicleInspection.setMeasurement(measurement);
        vehicleInspection.setObservation(observation);
        vehicleInspection.setVehicle(vehicle);
        vehicleInspection.setInspector(inspector);

        vehicleInspectionService.createVehicleInspection(vehicleInspection);

        VehicleInspection vehicleInspection1 = new VehicleInspection();


        Vehicle vehicle1 = vehicleRepository.findById(2L).orElse(null);
        Inspector inspector1 = inspectorRepository.findById(2L).orElse(null);
        Measurement measurement1 = measurementRepository.findById(2L).orElse(null);
        Observation observation1 = observationRepository.findById(2L).orElse(null);

        vehicleInspection1.setMeasurement(measurement1);
        vehicleInspection1.setObservation(observation1);
        vehicleInspection1.setVehicle(vehicle1);
        vehicleInspection1.setInspector(inspector1);

        vehicleInspectionService.createVehicleInspection(vehicleInspection1);

        VehicleInspection vehicleInspection2 = new VehicleInspection();


        Vehicle vehicle2 = vehicleRepository.findById(3L).orElse(null);
        Inspector inspector2 = inspectorRepository.findById(2L).orElse(null);
        Measurement measurement2 = measurementRepository.findById(3L).orElse(null);
        Observation observation2 = observationRepository.findById(3L).orElse(null);

        vehicleInspection2.setMeasurement(measurement2);
        vehicleInspection2.setObservation(observation2);
        vehicleInspection2.setVehicle(vehicle2);
        vehicleInspection2.setInspector(inspector2);

        vehicleInspectionService.createVehicleInspection(vehicleInspection2);

        VehicleInspection vehicleInspection3 = new VehicleInspection();


        Vehicle vehicle3 = vehicleRepository.findById(4L).orElse(null);
        Inspector inspector3 = inspectorRepository.findById(1L).orElse(null);
        Measurement measurement3 = measurementRepository.findById(4L).orElse(null);
        Observation observation3 = observationRepository.findById(4L).orElse(null);

        vehicleInspection3.setMeasurement(measurement3);
        vehicleInspection3.setObservation(observation3);
        vehicleInspection3.setVehicle(vehicle3);
        vehicleInspection3.setInspector(inspector3);

        vehicleInspectionService.createVehicleInspection(vehicleInspection3);

        VehicleInspection vehicleInspection4 = new VehicleInspection();


        Vehicle vehicle4 = vehicleRepository.findById(5L).orElse(null);
        Inspector inspector4 = inspectorRepository.findById(1L).orElse(null);
        Measurement measurement4 = measurementRepository.findById(5L).orElse(null);
        Observation observation4 = observationRepository.findById(5L).orElse(null);

        vehicleInspection4.setMeasurement(measurement4);
        vehicleInspection4.setObservation(observation4);
        vehicleInspection4.setVehicle(vehicle4);
        vehicleInspection4.setInspector(inspector4);

        vehicleInspectionService.createVehicleInspection(vehicleInspection4);

        VehicleInspection vehicleInspection5 = new VehicleInspection();


        Vehicle vehicle5 = vehicleRepository.findById(6L).orElse(null);
        Inspector inspector5 = inspectorRepository.findById(1L).orElse(null);
        Measurement measurement5 = measurementRepository.findById(6L).orElse(null);
        Observation observation5 = observationRepository.findById(6L).orElse(null);

        vehicleInspection5.setMeasurement(measurement5);
        vehicleInspection5.setObservation(observation5);
        vehicleInspection5.setVehicle(vehicle5);
        vehicleInspection5.setInspector(inspector5);

        vehicleInspectionService.createVehicleInspection(vehicleInspection5);

        VehicleInspection vehicleInspection6 = new VehicleInspection();


        Vehicle vehicle6 = vehicleRepository.findById(7L).orElse(null);
        Inspector inspector6 = inspectorRepository.findById(2L).orElse(null);
        Measurement measurement6 = measurementRepository.findById(7L).orElse(null);
        Observation observation6 = observationRepository.findById(7L).orElse(null);

        vehicleInspection6.setMeasurement(measurement6);
        vehicleInspection6.setObservation(observation6);
        vehicleInspection6.setVehicle(vehicle6);
        vehicleInspection6.setInspector(inspector6);

        vehicleInspectionService.createVehicleInspection(vehicleInspection6);

        VehicleInspection vehicleInspection7 = new VehicleInspection();


        Vehicle vehicle7 = vehicleRepository.findById(8L).orElse(null);
        Inspector inspector7 = inspectorRepository.findById(2L).orElse(null);
        Measurement measurement7 = measurementRepository.findById(8L).orElse(null);
        Observation observation7 = observationRepository.findById(8L).orElse(null);

        vehicleInspection7.setMeasurement(measurement7);
        vehicleInspection7.setObservation(observation7);
        vehicleInspection7.setVehicle(vehicle7);
        vehicleInspection7.setInspector(inspector7);

        vehicleInspectionService.createVehicleInspection(vehicleInspection7);

        VehicleInspection vehicleInspection8 = new VehicleInspection();


        Vehicle vehicle8 = vehicleRepository.findById(9L).orElse(null);
        Inspector inspector8 = inspectorRepository.findById(2L).orElse(null);
        Measurement measurement8 = measurementRepository.findById(9L).orElse(null);
        Observation observation8 = observationRepository.findById(9L).orElse(null);

        vehicleInspection8.setMeasurement(measurement8);
        vehicleInspection8.setObservation(observation8);
        vehicleInspection8.setVehicle(vehicle8);
        vehicleInspection8.setInspector(inspector8);

        vehicleInspectionService.createVehicleInspection(vehicleInspection8);

        VehicleInspection vehicleInspection9 = new VehicleInspection();


        Vehicle vehicle9 = vehicleRepository.findById(10L).orElse(null);
        Inspector inspector9 = inspectorRepository.findById(2L).orElse(null);
        Measurement measurement9 = measurementRepository.findById(10L).orElse(null);
        Observation observation9 = observationRepository.findById(10L).orElse(null);

        vehicleInspection9.setMeasurement(measurement9);
        vehicleInspection9.setObservation(observation9);
        vehicleInspection9.setVehicle(vehicle9);
        vehicleInspection9.setInspector(inspector9);

        vehicleInspectionService.createVehicleInspection(vehicleInspection9);
    }
}
*/
