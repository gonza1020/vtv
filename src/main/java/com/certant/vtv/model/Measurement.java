package com.certant.vtv.model;


import com.certant.vtv.utils.Condition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "inspection_id",referencedColumnName = "id")
    @OneToOne(fetch = FetchType.EAGER)
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
