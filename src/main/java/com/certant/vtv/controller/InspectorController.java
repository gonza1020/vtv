package com.certant.vtv.controller;


import com.certant.vtv.model.Inspector;
import com.certant.vtv.service.InspectorService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("inspector")
@AllArgsConstructor
public class InspectorController {
    private InspectorService inspectorService;

    @Operation(summary = "Create inspector")

    @PostMapping()
    ResponseEntity<Inspector> createInspector(@RequestBody Inspector inspector){
        return new ResponseEntity<>(inspectorService.createInspector(inspector), HttpStatus.CREATED);
    }

    @Operation(summary = "Update inspector")

    @PutMapping("/{id}")
    ResponseEntity<Inspector> updateInspector( @PathVariable  String id,@RequestBody  Inspector inspector){
        return new ResponseEntity<>(inspectorService.updateInspector(id,inspector), HttpStatus.OK);
    }

    @Operation(summary = "get inspector")
    @GetMapping("/{id}")
    ResponseEntity<Inspector> getCostumer( @PathVariable  String id){
        return new ResponseEntity<>(inspectorService.getInspector(id), HttpStatus.OK);
    }

    @Operation(summary = "get all inspectors")
    @GetMapping()
    ResponseEntity<List<Inspector>> getAll(){
        return new ResponseEntity<>(inspectorService.getAll(), HttpStatus.OK);
    }

    @Operation(summary = "delete inspector")
    @DeleteMapping("{id}")
    ResponseEntity<?> deleteCostumer(@PathVariable String id){
        inspectorService.deleteInspector(id);
        return ResponseEntity.noContent().build();
    }
}
