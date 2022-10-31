package com.certant.vtv.controller;

import com.certant.vtv.model.Car;
import com.certant.vtv.repository.CarRepository;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("vehicle/car")
@AllArgsConstructor
public class CarController {

    private CarRepository carRepository;

    @GetMapping()
    @Operation(summary = "Get all cars")
    ResponseEntity<List<Car>> getAllCars(){
        return new ResponseEntity<>(carRepository.findAll(), HttpStatus.OK);
    }
}
