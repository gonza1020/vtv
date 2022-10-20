package com.certant.vtv.controller;

import com.certant.vtv.dto.VehicleDto;
import com.certant.vtv.model.Car;
import com.certant.vtv.model.Vehicle;
import com.certant.vtv.service.impl.VehicleServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("vehicle")
@AllArgsConstructor
public class VehicleController {

    private VehicleServiceImpl vehicleService;


    @Operation(summary = "create vehicle")
    @PostMapping()
    ResponseEntity<Vehicle> createVehicle(@Valid @RequestBody Vehicle vehicle){
        return new ResponseEntity<>(vehicleService.createVehicle(vehicle), HttpStatus.CREATED);
    }

    @Operation(summary = "create car")
    @PostMapping("/car" )
    ResponseEntity<Car> createCar(@Valid @RequestBody Car car){
        return new ResponseEntity<>(vehicleService.createCar(car),HttpStatus.CREATED);
    }

    @Operation(summary = "update vehicle")

    @PutMapping("/{id}")
    ResponseEntity<Vehicle> updateVehicle( @PathVariable  Long id,@RequestBody  Vehicle vehicle){
        return new ResponseEntity<>(vehicleService.updateVehicle(id,vehicle), HttpStatus.ACCEPTED);
    }


    @Operation(summary = "get vehicle")
    @GetMapping("/{id}")
    ResponseEntity<VehicleDto> getVehicle( @PathVariable  Long id){
        return new ResponseEntity<>(vehicleService.getVehicle(id), HttpStatus.OK);
    }

    @Operation(summary = "get all vehicles")

    @GetMapping()
    ResponseEntity<List<VehicleDto>> getAll(){
        return new ResponseEntity<>(vehicleService.getAll(), HttpStatus.OK);
    }

    @Operation(summary = "get vehicle by its condition")
    @GetMapping("/condition")
    ResponseEntity<List<VehicleDto>> getVehiclesByConditions(@RequestParam String condition){
        return new ResponseEntity<>(vehicleService.getVehiclesCondition(condition),HttpStatus.OK);
    }

    @Operation(summary = "delete vehicle")
    @DeleteMapping("{id}")
    ResponseEntity<?> deleteCostumer(@PathVariable Long id){
        vehicleService.deleteVehicle(id);
        return ResponseEntity.noContent().build();
    }
}
