package com.certant.vtv.utils;

import com.certant.vtv.model.Costumer;
import com.certant.vtv.model.Vehicle;
import com.certant.vtv.repository.CostumerRepository;
import com.certant.vtv.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@AllArgsConstructor
public class VehicleSeedData implements CommandLineRunner {

    private CostumerRepository costumerRepository;
    private VehicleRepository vehicleRepository;

    @Override
    public void run(String... args) throws Exception {

        saveCostumer();
        saveVehicles();
    }
    private void saveCostumer(){
        if(costumerRepository.count() == 0){
            Costumer pedro = new Costumer(CostumerType.EXEMPT,new ArrayList<>());
            pedro.setName("pedro");
            pedro.setEmail("pedro@gmail.com");
            pedro.setLastName("picapiedra");
            pedro.setPhoneNumber("3777-123456");
            costumerRepository.save(pedro);

            Costumer santi = new Costumer(CostumerType.NORMAL,new ArrayList<>());
            santi.setName("Santi");
            santi.setEmail("santi@gmail.com");
            santi.setLastName("simon");
            santi.setPhoneNumber("3777-654321");
            costumerRepository.save(santi);
        }
    }
    private void saveVehicles(){

        if(vehicleRepository.count() == 0){
            Costumer pedro = costumerRepository.findByName("pedro");
            Costumer santi = costumerRepository.findByName("santi");

            Vehicle v1 = new Vehicle(null,"AB-1234","Chevrolet","camaro",pedro);
            Vehicle v2 = new Vehicle(null,"AB-1235","Chevrolet","captiva",pedro);
            Vehicle v3 = new Vehicle(null,"AB-1236","Chevrolet","nisa",pedro);
            Vehicle v4 = new Vehicle(null,"AB-1237","Chevrolet","frasa",pedro);
            Vehicle v5 = new Vehicle(null,"AB-1238","Chevrolet","asda",pedro);
            Vehicle v6 = new Vehicle(null,"AB-1239","Chevrolet","meda",pedro);

            Vehicle v11 = new Vehicle(null,"AB-1334","Toyota","sw4",santi);
            Vehicle v22 = new Vehicle(null,"AB-1335","Toyota","corolla",santi);
            Vehicle v33 = new Vehicle(null,"AB-1336","Toyota","rav4",santi);
            Vehicle v44 = new Vehicle(null,"AB-1337","Toyota","hilux",santi);
            Vehicle v55 = new Vehicle(null,"AB  -1338","Toyota","yaris",santi);
            Vehicle v66 = new Vehicle(null,"AB-1339","Toyota","etios",santi);

            vehicleRepository.save(v1);
            vehicleRepository.save(v2);
            vehicleRepository.save(v3);
            vehicleRepository.save(v4);
            vehicleRepository.save(v5);
            vehicleRepository.save(v6);
            vehicleRepository.save(v11);
            vehicleRepository.save(v22);
            vehicleRepository.save(v33);
            vehicleRepository.save(v44);
            vehicleRepository.save(v55);
            vehicleRepository.save(v66);

        }
    }
}
