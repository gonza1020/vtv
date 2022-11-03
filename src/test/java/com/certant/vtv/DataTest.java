package com.certant.vtv;

import com.certant.vtv.model.*;
import com.certant.vtv.utils.Condition;
import com.certant.vtv.utils.CostumerType;


public  class DataTest {


    public static VehicleInspection getVehicleInspection(Vehicle vehicle){

        VehicleInspection vehicleInspection = new VehicleInspection();
        vehicleInspection.setVehicle(vehicle);
        vehicleInspection.setCost(1234.35);
        vehicleInspection.setInspector(getInspector());
        vehicleInspection.setId("1234567");
        return vehicleInspection;
    }

    public static Costumer getCostumer(){
        Costumer costumer = new Costumer();
        costumer.setId("1233");
        costumer.setCostumerType(CostumerType.NORMAL);
        costumer.setName("Gonza");
        costumer.setDni("42792711");
        costumer.setPhoneNumber("3777-523238");
        costumer.setLastName("Zoloaga");
        costumer.setEmail("abc@gmail.com");
        return costumer;
    }
    public static Vehicle getVehicle(Costumer costumer){
        Vehicle vehicle = new Vehicle();
        vehicle.setId("123");
        vehicle.setBrand("Chevrolet");
        vehicle.setModel("Onix");
        vehicle.setVersion("1.6 GNC");
        vehicle.setCostumer(costumer);
        return vehicle;
    }


    public static Inspector getInspector(){
        Inspector inspector = new Inspector();
        inspector.setId("1324");
        inspector.setLastName("Pedro");
        inspector.setName("Juan");
        inspector.setEmail("abc@gmail.com");
        inspector.setPhoneNumber("1234-123456");
        inspector.setLegajo("24736");

        return inspector;
    }


    public static Observation getObservation(){
        Observation observation = new Observation();

        observation.setId("1223");
        observation.setChassis(Condition.APPROVED);
        observation.setLights(Condition.REJECTED);
        observation.setGlasses(Condition.APPROVED);
        observation.setMirrors(Condition.APPROVED);
        observation.setSecurityVehicle(Condition.APPROVED);
        observation.setLicensePlate(Condition.APPROVED);
        observation.setDescription("Vehiculo aproabdo");

        return observation;

    }

    public static Measurement getMeasurement(){
        Measurement measurement = new Measurement();

        measurement.setId("123");
        measurement.setBrakes(Condition.APPROVED);
        measurement.setSuspension(Condition.REJECTED);
        measurement.setGasEmisions(Condition.APPROVED);
        measurement.setFrontWheelAssembly(Condition.APPROVED);

        return measurement;
    }
}
