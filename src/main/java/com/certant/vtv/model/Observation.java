package com.certant.vtv.model;


import com.certant.vtv.utils.Condition;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Observation {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Enumerated(EnumType.STRING)

    @JsonIgnore
    @OneToOne(mappedBy = "observation",targetEntity = VehicleInspection.class,fetch = FetchType.EAGER)
    private VehicleInspection vehicleInspection;

    private Condition lights;
    @Enumerated(EnumType.STRING)
    private Condition licensePlate;
    @Enumerated(EnumType.STRING)
    private Condition mirrors;
    @Enumerated(EnumType.STRING)
    private Condition chassis;
    @Enumerated(EnumType.STRING)
    private Condition glasses;
    @Enumerated(EnumType.STRING)
    private Condition securityVehicle;
    private String description;

}
