package com.certant.vtv.controller;


import com.certant.vtv.model.Costumer;
import com.certant.vtv.model.VehicleInspection;
import com.certant.vtv.service.CostumerService;
import com.certant.vtv.service.VehicleInspectionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vehicle-inspection")
@AllArgsConstructor
public class VehicleInspectionController {

    private VehicleInspectionService vehicleInspectionService;

    @PostMapping()
    ResponseEntity<VehicleInspection> createCostumer(@RequestBody VehicleInspection vehicleInspection){
        return new ResponseEntity<>(vehicleInspectionService.createVehicleInspection(vehicleInspection), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<VehicleInspection> updateCostumer( @PathVariable  Long id,@RequestBody  VehicleInspection vehicleInspection){
        return new ResponseEntity<>(vehicleInspectionService.updateVehicleInspection(id, vehicleInspection), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    ResponseEntity<VehicleInspection> getCostumer( @PathVariable  Long id){
        return new ResponseEntity<>(vehicleInspectionService.getVehicleInspection(id), HttpStatus.ACCEPTED);
    }

    @GetMapping()
    ResponseEntity<List<VehicleInspection>> getAll(){
        return new ResponseEntity<>(vehicleInspectionService.getAll(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping()
    ResponseEntity<?> deleteCostumer(@PathVariable Long id){
        vehicleInspectionService.deleteVehicleInspection(id);
        return ResponseEntity.noContent().build();
    }
}
