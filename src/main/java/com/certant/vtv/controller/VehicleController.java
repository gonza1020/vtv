package com.certant.vtv.controller;

import com.certant.vtv.model.Costumer;
import com.certant.vtv.model.Vehicle;
import com.certant.vtv.service.CostumerService;
import com.certant.vtv.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vehicle")
@AllArgsConstructor
public class VehicleController {

    private VehicleService vehicleService;


    @PostMapping()
    ResponseEntity<Vehicle> createCostumer(@RequestBody Vehicle vehicle){
        return new ResponseEntity<>(vehicleService.createVehicle(vehicle), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<Vehicle> updateCostumer( @PathVariable  Long id,@RequestBody  Vehicle vehicle){
        return new ResponseEntity<>(vehicleService.updateVehicle(id,vehicle), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    ResponseEntity<Vehicle> getCostumer( @PathVariable  Long id){
        return new ResponseEntity<>(vehicleService.getVehicle(id), HttpStatus.ACCEPTED);
    }

    @GetMapping()
    ResponseEntity<List<Vehicle>> getAll(){
        return new ResponseEntity<>(vehicleService.getAll(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping()
    ResponseEntity<?> deleteCostumer(@PathVariable Long id){
        vehicleService.deleteVehicle(id);
        return ResponseEntity.noContent().build();
    }
}
