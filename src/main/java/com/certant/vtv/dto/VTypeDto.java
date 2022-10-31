package com.certant.vtv.dto;

import com.certant.vtv.model.Costumer;
import com.certant.vtv.utils.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VTypeDto {
    private VehicleType vehicleType;
    private String licensePlate;
    private String brand;
    private String model;
    private Costumer costumer;
    private String cc;
    private String carType;
    private Integer doors;
}
