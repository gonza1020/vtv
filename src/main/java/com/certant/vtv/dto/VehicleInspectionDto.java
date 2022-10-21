package com.certant.vtv.dto;

import com.certant.vtv.utils.CostumerType;
import com.certant.vtv.utils.Condition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VehicleInspectionDto {
    private String id;
    private LocalDate inspectionDate;
    private LocalDate expirationDate;
    private Condition inspectionState;
    private CostumerType costumerType;
    private String inspectorName;
    private VehicleDto vehicleDto;
}
