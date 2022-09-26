package com.certant.vtv.model;


import com.certant.vtv.utils.Condition;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Observation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)

    @JoinColumn(name = "inspection_id",referencedColumnName = "id")
    @OneToOne(fetch = FetchType.EAGER)
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
