package com.certant.vtv.repository;

import com.certant.vtv.model.VehicleData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VehicleDataRepository extends JpaRepository<VehicleData,String> {
}
