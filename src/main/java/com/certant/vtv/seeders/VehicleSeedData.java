package com.certant.vtv.seeders;

import com.certant.vtv.model.Car;
import com.certant.vtv.model.Costumer;
import com.certant.vtv.model.Vehicle;
import com.certant.vtv.repository.CostumerRepository;
import com.certant.vtv.repository.VehicleRepository;
import com.certant.vtv.utils.CostumerType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@AllArgsConstructor
@Component
public class VehicleSeedData {

    private CostumerRepository costumerRepository;
    private VehicleRepository vehicleRepository;


    public void saveVehicles(){

        if(vehicleRepository.count() == 0){
            Costumer pedro = costumerRepository.findByName("pedro");
            Costumer santi = costumerRepository.findByName("santi");

            Car c1 = Car.builder().brand("Chevrolet")
                    .licensePlate("ABC234")
                    .model("camaro")
                    .carType("sedan")
                    .costumer(pedro)
                    .doors(4)
                    .build();

           /* Vehicle v1 = new Vehicle(null,"ABC234","Chevrolet","camaro",pedro,null);
            Vehicle v2 = new Vehicle(null,"ABC235","Chevrolet","captiva",pedro,null);
            Vehicle v3 = new Vehicle(null,"ABC236","Chevrolet","nisa",pedro,null);
            Vehicle v4 = new Vehicle(null,"ABC237","Chevrolet","frasa",pedro,null);
            Vehicle v5 = new Vehicle(null,"ABC238","Chevrolet","asda",pedro,null);
            Vehicle v6 = new Vehicle(null,"ABC239","Chevrolet","meda",pedro,null);

            Vehicle v11 = new Vehicle(null,"ABD334","Toyota","sw4",santi,null);
            Vehicle v22 = new Vehicle(null,"AB335CD","Toyota","corolla",santi,null);
            Vehicle v33 = new Vehicle(null,"AB336CD","Toyota","rav4",santi,null);
            Vehicle v44 = new Vehicle(null,"ABW337","Toyota","hilux",santi,null);
            Vehicle v55 = new Vehicle(null,"ABS138","Toyota","yaris",santi,null);
            Vehicle v66 = new Vehicle(null,"ABF339","Toyota","etios",santi,null);

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
            vehicleRepository.save(v55);*/
            vehicleRepository.save(c1);

        }
    }
}
