package com.certant.vtv.repository;

import com.certant.vtv.model.VehicleInspection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleInspectionRepository extends JpaRepository<VehicleInspection,Long> {
}
