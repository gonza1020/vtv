package com.certant.vtv.repository;

import com.certant.vtv.model.Tariff;
import com.certant.vtv.utils.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TariffRepository extends JpaRepository<Tariff,String> {

    Tariff findByVehicleType(VehicleType vehicleType);
}
