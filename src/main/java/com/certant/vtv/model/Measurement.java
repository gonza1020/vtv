package com.certant.vtv.model;


import com.certant.vtv.utils.Condition;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Measurement {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @JsonIgnore
    @OneToOne(mappedBy = "measurement",targetEntity = VehicleInspection.class,fetch = FetchType.EAGER)
    private VehicleInspection vehicleInspection;

    @Enumerated(EnumType.STRING)
    private Condition suspension;
    @Enumerated(EnumType.STRING)
    private Condition brakes;
    @Enumerated(EnumType.STRING)
    private Condition gasEmisions;
    @Enumerated(EnumType.STRING)
    private Condition frontWheelAssembly;
}
