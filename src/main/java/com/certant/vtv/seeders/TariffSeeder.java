package com.certant.vtv.seeders;

import com.certant.vtv.model.Tariff;
import com.certant.vtv.repository.TariffRepository;
import com.certant.vtv.utils.VehicleType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TariffSeeder {

    private TariffRepository tariffRepository;

    public void saveTariff(){
        Tariff carTariff = new Tariff(null, VehicleType.CAR,25000.99);
        Tariff cycleTariff = new Tariff(null, VehicleType.CYCLE,15000.58);

        tariffRepository.save(carTariff);
        tariffRepository.save(cycleTariff);
    }
}
