package com.certant.vtv.controller;

import com.certant.vtv.dto.VTypeDto;
import com.certant.vtv.dto.VehicleDto;
import com.certant.vtv.model.Car;
import com.certant.vtv.model.Cycle;
import com.certant.vtv.model.Vehicle;
import com.certant.vtv.service.impl.VehicleServiceImpl;
import com.certant.vtv.utils.VehicleType;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.FieldPosition;
import java.util.List;

@RestController
@RequestMapping("vehicle")
@AllArgsConstructor
public class VehicleController {

    private VehicleServiceImpl vehicleService;
    private ModelMapper mapper;


    @Operation(summary = "create vehicle")
    @PostMapping()
    ResponseEntity<String> createVehicle(@Valid @RequestBody VTypeDto vehicle, BindingResult result){


        String licensePlate = vehicle.getLicensePlate();
        VehicleDto vehicleUnique = vehicleService.findByLicensePlate(licensePlate);
        if(licensePlate == null){
            FieldError error = new FieldError("Vehicle",licensePlate,"La patente no puede quedar vacia, por favor, ingresa la patente correctamente");
            result.addError(error);
        }
        if(!licensePlate.matches("[A-Za-z]{3}[\\d]{3}|[A-Za-z]{2}[\\d]{3}[A-Za-z]{2}")){
            FieldError error = new FieldError("Vehicle",licensePlate,"La patente ingresada no es correcta: El formato valido es ABC123 o AB123CD");
            result.addError(error);
        }
        if (vehicleUnique != null){
            FieldError error = new FieldError("Vehicle", licensePlate, "El vehiculo con la patente ingresada ya existe. Por favor, intente nuevamente");
            result.addError(error);
        }
        if(result.hasErrors()){
            return new ResponseEntity<>(result.toString(),HttpStatus.BAD_REQUEST);
        }
        if(vehicle.getVehicleType() == VehicleType.CAR){
            Car car = mapper.map(vehicle, Car.class);
            return new ResponseEntity<>(vehicleService.createCar(car).toString(), HttpStatus.CREATED);

        } else if (vehicle.getVehicleType() == VehicleType.CYCLE) {
            Cycle cycle = mapper.map(vehicle, Cycle.class);
            return new ResponseEntity<>(vehicleService.createCycle(cycle).toString(), HttpStatus.CREATED);

        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Operation(summary = "create car")
    @PostMapping("/car" )
    ResponseEntity<Car> createCar(@Valid @RequestBody Car car){
        return new ResponseEntity<>(vehicleService.createCar(car),HttpStatus.CREATED);
    }

    @Operation(summary = "update vehicle")
    @PutMapping("/{id}")
    ResponseEntity<String> updateVehicle( @PathVariable  String id,@RequestBody  VTypeDto vehicle){
        return new ResponseEntity<>(vehicleService.updateVehicle(id,vehicle).toString(), HttpStatus.ACCEPTED);
    }


    @Operation(summary = "get vehicle")
    @GetMapping("/{id}")
    ResponseEntity<VehicleDto> getVehicle( @PathVariable  String id){
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

    @Operation(summary = "get vehicle by its license plate")
    @GetMapping("licensePlate")
    ResponseEntity<VehicleDto> getByLicensePlate(@RequestParam String licensePlate){
        return new ResponseEntity<>(vehicleService.findByLicensePlate(licensePlate),HttpStatus.OK);
    }

    @Operation(summary = "delete vehicle")
    @DeleteMapping("{id}")
    ResponseEntity<?> deleteCostumer(@PathVariable String id){
        vehicleService.deleteVehicle(id);
        return ResponseEntity.noContent().build();
    }
}
