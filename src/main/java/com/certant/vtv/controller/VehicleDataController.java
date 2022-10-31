package com.certant.vtv.controller;


import com.certant.vtv.model.VehicleData;
import com.certant.vtv.service.VehicleDataService;
import com.certant.vtv.service.impl.VehicleDataServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("vehicle-data")
public class VehicleDataController {

    private VehicleDataServiceImpl vehicleDataService;

    @Operation(summary = "get all vehicles")
    @GetMapping()
    public ResponseEntity<List<VehicleData>> getVehicles(){
        return new ResponseEntity<>(vehicleDataService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/vehicleType")
    public ResponseEntity<List<String>> getVehicleType(){

        return new ResponseEntity<>(vehicleDataService.getVehicleType(),HttpStatus.OK);
    }
    @GetMapping("vehicle-type")
    public ResponseEntity<List<String>> getVehicleByType(@RequestParam String vehicleType){
        return new ResponseEntity<>(vehicleDataService.findByVehicleType(vehicleType),HttpStatus.OK);
    }

    @GetMapping("brand")
    public ResponseEntity<List<String>> getVehicleByBrand(@RequestParam String brand){
        return new ResponseEntity<>(vehicleDataService.findByBrand(brand),HttpStatus.OK);
    }
}
