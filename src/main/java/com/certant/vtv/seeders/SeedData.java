package com.certant.vtv.seeders;

import com.certant.vtv.model.Inspector;
import com.certant.vtv.repository.InspectorRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SeedData implements CommandLineRunner {

    private InspectorRepository inspectorRepository;
    private PersonSeeder personSeeder;
    private VehicleSeedData vehicleSeedData;
    private VehicleDataSeeder vehicleDataSeeder;
    private  TariffSeeder tariffSeeder;

    @Override
    public void run(String... args) throws Exception {

        vehicleDataSeeder.createVehicles();
        tariffSeeder.saveTariff();
        personSeeder.saveCostumer();
        personSeeder.saveInspector();
        vehicleSeedData.saveVehicles();
        /*vehicleInspectionSeeder.saveObservation();
        vehicleInspectionSeeder.saveMeasurement();
        vehicleInspectionSeeder.saveInspection();*/

    }

}
