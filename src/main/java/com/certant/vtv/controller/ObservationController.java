package com.certant.vtv.controller;


import com.certant.vtv.model.Costumer;
import com.certant.vtv.model.Observation;
import com.certant.vtv.service.CostumerService;
import com.certant.vtv.service.ObservationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("observation")
@AllArgsConstructor
public class ObservationController {

    private ObservationService observationService;


    @PostMapping()
    ResponseEntity<Observation> createObservation(@RequestBody Observation observation){
        return new ResponseEntity<>(observationService.createObservation(observation), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<Observation> updateObservation( @PathVariable  Long id,@RequestBody  Observation observation){
        return new ResponseEntity<>(observationService.updateObservation(id,observation), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    ResponseEntity<Observation> getCostumer( @PathVariable  Long id){
        return new ResponseEntity<>(observationService.getObservation(id), HttpStatus.ACCEPTED);
    }

    @GetMapping()
    ResponseEntity<List<Observation>> getAll(){
        return new ResponseEntity<>(observationService.getAll(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping()
    ResponseEntity<?> deleteCostumer(@PathVariable Long id){
        observationService.deleteObservation(id);
        return ResponseEntity.noContent().build();
    }


}
