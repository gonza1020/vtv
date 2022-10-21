package com.certant.vtv.repository;

import com.certant.vtv.dto.VehicleTypeDto;
import com.certant.vtv.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,String> {

    @Query(
            value = "SELECT v.vehicle_type as vehicleType FROM vehicle v WHERE v.id = :id",
    nativeQuery = true)
    VehicleTypeDto findByVehicleType(String id);
}
