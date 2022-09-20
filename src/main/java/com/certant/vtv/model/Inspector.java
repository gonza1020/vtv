package com.certant.vtv.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@AllArgsConstructor
public class Inspector extends Person{

    @JoinColumn(name = "inspection_id")
    @OneToOne(fetch = FetchType.LAZY)
    private VehicleInspection vehicleInspection;
}
