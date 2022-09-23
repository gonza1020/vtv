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
    ResponseEntity<Measurement> updateMeasurement( @PathVariable  Long id,@RequestBody  Measurement measurement){
        return new ResponseEntity<>(measurementService.updateMeasurement(id,measurement), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    ResponseEntity<Measurement> getMeasurement( @PathVariable  Long id){
        return new ResponseEntity<>(measurementService.getMeasurement(id), HttpStatus.ACCEPTED);
    }

    @GetMapping()
    ResponseEntity<List<Measurement>> getAll(){
        return new ResponseEntity<>(measurementService.getAll(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping()
    ResponseEntity<?> deleteMeasurement(@PathVariable Long id){
        measurementService.deleteMeasurement(id);
        return ResponseEntity.noContent().build();
    }
}
