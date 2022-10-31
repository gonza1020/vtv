package com.certant.vtv.controller;

import com.certant.vtv.model.Costumer;
import com.certant.vtv.service.CostumerService;
import com.certant.vtv.service.impl.CostumerServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("costumer")
public class CostumerController {
        private CostumerServiceImpl costumerService;

    @Operation(summary = "Create costumer")
    @PostMapping()
    ResponseEntity<String> createCostumer(@Valid @RequestBody  Costumer costumer, BindingResult result){
        String dni = costumer.getDni();
        Costumer costumer1 = costumerService.findByDni(dni);

        if(dni == null){
            FieldError error = new FieldError("Costumer",dni,"El dni no puede estar vacio");
            result.addError(error);
        }
        if(dni.length() != 8){
            FieldError error = new FieldError("Costumer" , dni, "El dni deber contener 8 caracteres");
            result.addError(error);
        }
        if(costumer1 != null){
            FieldError error = new FieldError("Costumer", dni,"El usuario con el dni ingresado ya se encuentra registrado");
            result.addError(error);
        }
        if (result.hasErrors()){
            return new ResponseEntity<>(result.toString(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(costumerService.createCostumer(costumer).toString(), HttpStatus.CREATED);
    }

    @Operation(summary = "Update costumer")

    @PutMapping("/{id}")
    ResponseEntity<Costumer> updateCostumer( @PathVariable  String id,@RequestBody  Costumer costumer){
        return new ResponseEntity<>(costumerService.updateCostumer(id,costumer), HttpStatus.ACCEPTED);
    }

    @Operation(summary = "get costumer")
    @GetMapping("/{id}")
    ResponseEntity<Costumer> getCostumer( @PathVariable  String id){
        return new ResponseEntity<>(costumerService.getCostumer(id), HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Gett all costumers")
    @GetMapping()
    ResponseEntity<List<Costumer>> getAll(){
        return new ResponseEntity<>(costumerService.getAll(), HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Delete costumer")
    @DeleteMapping("{id}")
    ResponseEntity<?> deleteCostumer(@PathVariable String id){
        costumerService.deleteCostumer(id);
        return ResponseEntity.noContent().build();
    }


}
