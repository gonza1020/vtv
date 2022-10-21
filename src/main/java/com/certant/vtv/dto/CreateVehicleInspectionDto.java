package com.certant.vtv.dto;


import com.certant.vtv.model.Measurement;
import com.certant.vtv.model.Observation;
import com.certant.vtv.utils.Condition;



public class CreateVehicleInspectionDto {

    private Condition conditionn;
    private Double cost;
    private Observation observation;
    private Measurement measurement;
    private Long inspectorId;
    private Long vehicleId;
}
