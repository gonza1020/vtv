package com.certant.vtv.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VehicleDto {
    private String licensePlate;
    private String brand;
    private String model;
    private String owner;
}
