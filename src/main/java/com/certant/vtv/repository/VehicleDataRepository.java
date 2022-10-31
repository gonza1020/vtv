package com.certant.vtv.repository;

import com.certant.vtv.model.VehicleData;
import com.certant.vtv.utils.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VehicleDataRepository extends JpaRepository<VehicleData,String> {


    @Query(value = "SELECT DISTINCT v.brand as brand FROM vehicle_data v WHERE v.vehicle_type = :vehicleType"
            ,nativeQuery = true)
    List<String> findByVehicleType(String vehicleType);


    @Query(value = "SELECT  DISTINCT v.model as model FROM vehicle_data v WHERE v.brand = :brand"
            ,nativeQuery = true)
    List<String> findByBrand(String brand);

    @Query(value = "SELECT DISTINCT v.vehicle_type as vehicleType FROM vehicle_data v"
    ,nativeQuery = true)
    List<String> findVehicleType();
}
