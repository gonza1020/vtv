package com.certant.vtv.seeders;


import com.certant.vtv.model.VehicleData;
import com.certant.vtv.repository.VehicleDataRepository;
import com.certant.vtv.utils.VehicleType;
import lombok.AllArgsConstructor;
import org.hibernate.engine.query.spi.HQLQueryPlan;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class VehicleDataSeeder {

    private VehicleDataRepository vehicleDataRepository;
    public void createVehicles(){

        VehicleData c1 = new VehicleData(null,"Citroen","C4", VehicleType.CAR);
        VehicleData c2 = new VehicleData(null,"Citroen","C3",VehicleType.CAR);

        VehicleData c3 = new VehicleData(null,"Chevrolet","Cruze",VehicleType.CAR);
        VehicleData c4 = new VehicleData(null,"Chevrolet","Captiva",VehicleType.CAR);

        VehicleData c5 = new VehicleData(null,"BMW","X3",VehicleType.CAR);
        VehicleData c6 = new VehicleData(null,"BMW","X6",VehicleType.CAR);

        VehicleData c7 = new VehicleData(null,"Yamaha","XTZ",VehicleType.CYCLE);
        VehicleData c8 = new VehicleData(null,"Yamaha","YBR",VehicleType.CYCLE);

        VehicleData c9 = new VehicleData(null,"Honda","Wave",VehicleType.CYCLE);
        VehicleData c10 = new VehicleData(null,"Honda","Tornado",VehicleType.CYCLE);

        VehicleData c11 = new VehicleData(null,"Harley Davidson","Road King",VehicleType.CYCLE);
        VehicleData c12 = new VehicleData(null,"Harley Davidson","Street Guide",VehicleType.CYCLE);


        vehicleDataRepository.save(c1);
        vehicleDataRepository.save(c2);
        vehicleDataRepository.save(c3);
        vehicleDataRepository.save(c4);
        vehicleDataRepository.save(c5);
        vehicleDataRepository.save(c6);
        vehicleDataRepository.save(c7);
        vehicleDataRepository.save(c8);
        vehicleDataRepository.save(c9);
        vehicleDataRepository.save(c10);
        vehicleDataRepository.save(c11);
        vehicleDataRepository.save(c12);

    }
}
