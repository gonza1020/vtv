package com.certant.vtv.utils;

import com.certant.vtv.model.Inspector;
import com.certant.vtv.repository.InspectorRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SeedData implements CommandLineRunner {

    private InspectorRepository inspectorRepository;
    private VehicleInspectionSeeder vehicleInspectionSeeder;
    private VehicleSeedData vehicleSeedData;

    @Override
    public void run(String... args) throws Exception {
        saveInspector();
        vehicleSeedData.saveCostumer();
        vehicleSeedData.saveVehicles();
        vehicleInspectionSeeder.saveObservation();
        vehicleInspectionSeeder.saveMeasurement();
        vehicleInspectionSeeder.saveInspection();

    }

    private void saveInspector(){
        if(inspectorRepository.count() == 0){
            Inspector inspector = new Inspector();
            inspector.setPhoneNumber("3777-123456");
            inspector.setEmail("fabri@gmail.com");
            inspector.setName("Fabricio");
            inspector.setLastName("Perfetti");
            inspectorRepository.save(inspector);

            Inspector inspector1 = new Inspector();
            inspector1.setPhoneNumber("3777-987654");
            inspector1.setEmail("sergio@gmail.com");
            inspector1.setName("Sergio");
            inspector1.setLastName("Ramos");
            inspectorRepository.save(inspector1);
        }
    }
}
