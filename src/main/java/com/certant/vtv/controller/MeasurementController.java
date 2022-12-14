package com.certant.vtv.controller;

import com.certant.vtv.model.Costumer;
import com.certant.vtv.model.Measurement;
import com.certant.vtv.service.CostumerService;
import com.certant.vtv.service.MeasurementService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("measurement")
@AllArgsConstructor
public class MeasurementController {

    private MeasurementService measurementService;


    @PostMapping()
    ResponseEntity<Measurement> createMeasurement(@RequestBody Measurement measurement){
        return new ResponseEntity<>(measurementService.createMeasurement(measurement), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<Measurement> updateMeasurement( @PathVariable  String id,@RequestBody  Measurement measurement){
        return new ResponseEntity<>(measurementService.updateMeasurement(id,measurement), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Measurement> getMeasurement( @PathVariable  String id){
        return new ResponseEntity<>(measurementService.getMeasurement(id), HttpStatus.OK);
    }

    @GetMapping()
    ResponseEntity<List<Measurement>> getAll(){
        return new ResponseEntity<>(measurementService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    ResponseEntity<?> deleteMeasurement(@PathVariable String id){
        measurementService.deleteMeasurement(id);
        return ResponseEntity.noContent().build();
    }
}
