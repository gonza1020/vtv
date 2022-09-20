package com.certant.vtv.model;


import com.certant.vtv.utils.State;
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
    @JoinColumn(name = "inspection_id")
    @OneToOne(fetch = FetchType.LAZY)
    private VehicleInspection vehicleInspection;

    @Enumerated(EnumType.STRING)
    private State suspension;
    @Enumerated(EnumType.STRING)
    private State brakes;
    @Enumerated(EnumType.STRING)
    private State gasEmisions;
}
