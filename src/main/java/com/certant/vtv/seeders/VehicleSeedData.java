package com.certant.vtv.seeders;

import com.certant.vtv.model.Car;
import com.certant.vtv.model.Costumer;
import com.certant.vtv.model.Cycle;
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

            Car c1 = Car.builder()
                    .brand("Chevrolet")
                        .licensePlate("ABC234")
                            .model("camaro")
                              .version("1.8 Diesel")
                               .costumer(pedro)
                        .build();

            Cycle cycle = Cycle.builder()
                    .brand("Yamaha")
                            .licensePlate("ABC355")
                                            .costumer(santi)
                    .version("Chopper diesel")
                                                    .model("ybr")
                                                            .build();

            vehicleRepository.save(c1);
            vehicleRepository.save(cycle);
        }
    }
}
