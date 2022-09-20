package com.certant.vtv.model;


import com.certant.vtv.utils.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Stack;

@Entity
@AllArgsConstructor
@Getter
@Setter
public class Observation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)

    @JoinColumn(name = "inspection_id")
    @OneToOne(fetch = FetchType.LAZY)
    private VehicleInspection vehicleInspection;

    private State lights;
    @Enumerated(EnumType.STRING)
    private State licensePlate;
    @Enumerated(EnumType.STRING)
    private State mirrors;
    @Enumerated(EnumType.STRING)
    private State chassis;
    @Enumerated(EnumType.STRING)
    private State glasses;
    @Enumerated(EnumType.STRING)
    private State securityVehicle;
    private String description;

}
