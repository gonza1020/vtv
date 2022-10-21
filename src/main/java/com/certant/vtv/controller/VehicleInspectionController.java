package com.certant.vtv.controller;


import com.certant.vtv.dto.CreateVehicleInspectionDto;
import com.certant.vtv.dto.VehicleInspectionDto;
import com.certant.vtv.model.Costumer;
import com.certant.vtv.model.VehicleInspection;
import com.certant.vtv.service.CostumerService;
import com.certant.vtv.service.VehicleInspectionService;
import io.swagger.v3.oas.annotations.Operation;
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


    @Operation(summary = "Create vehicle inspection")

    @PostMapping()
    ResponseEntity<VehicleInspection> createVehicleInspection(@RequestBody VehicleInspection vehicleInspection){
        return new ResponseEntity<>(vehicleInspectionService.createVehicleInspection(vehicleInspection), HttpStatus.CREATED);
    }


    @Operation(summary = "Update vehicle inspection")

    @PutMapping("/{id}")
    ResponseEntity<VehicleInspection> updateVehicleInspection( @PathVariable  String id,@RequestBody  VehicleInspection vehicleInspection){
        return new ResponseEntity<>(vehicleInspectionService.updateVehicleInspection(id, vehicleInspection), HttpStatus.OK);
    }

    @Operation(summary = "get vehicle inspection")


    @GetMapping("/{id}")
    ResponseEntity<VehicleInspectionDto> getVehicleInspection(@PathVariable  String id){
        return new ResponseEntity<>(vehicleInspectionService.getVehicleInspection(id), HttpStatus.OK);
    }

    @Operation(summary = "get all vehicle inspections")

    @GetMapping()
    ResponseEntity<List<VehicleInspectionDto>> getAll(){
        return new ResponseEntity<>(vehicleInspectionService.getAll(), HttpStatus.OK);
    }

    @Operation(summary = "delete vehicle inspection")

    @DeleteMapping("{id}")
    ResponseEntity<?> deleteVehicleInspection(@PathVariable String id){
        vehicleInspectionService.deleteVehicleInspection(id);
        return ResponseEntity.noContent().build();
    }
}
