package com.certant.vtv.controller;

import com.certant.vtv.model.Costumer;
import com.certant.vtv.service.CostumerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("costumer")
public class CostumerController {

    private CostumerService costumerService;

    @PostMapping()
    ResponseEntity<Costumer> createCostumer(@RequestBody  Costumer costumer){
        return new ResponseEntity<>(costumerService.createCostumer(costumer), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<Costumer> updateCostumer( @PathVariable  Long id,@RequestBody  Costumer costumer){
        return new ResponseEntity<>(costumerService.updateCostumer(id,costumer), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    ResponseEntity<Costumer> getCostumer( @PathVariable  Long id){
        return new ResponseEntity<>(costumerService.getCostumer(id), HttpStatus.ACCEPTED);
    }

    @GetMapping()
    ResponseEntity<List<Costumer>> getAll(){
        return new ResponseEntity<>(costumerService.getAll(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping()
    ResponseEntity<?> deleteCostumer(@PathVariable Long id){
        costumerService.deleteCostumer(id);
        return ResponseEntity.noContent().build();
    }


}
