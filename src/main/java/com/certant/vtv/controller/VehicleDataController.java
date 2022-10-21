package com.certant.vtv.controller;


import com.certant.vtv.model.VehicleData;
import com.certant.vtv.service.VehicleDataService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("vehicle-data")
public class VehicleDataController {

    private VehicleDataService vehicleDataService;

    @Operation(summary = "get all vehicles")
    @GetMapping()
    public ResponseEntity<List<VehicleData>> getVehicles(){
        return new ResponseEntity<>(vehicleDataService.getAll(), HttpStatus.OK);
    }
}
