package com.certant.vtv.model;


import com.certant.vtv.dto.PersonDto;
import com.certant.vtv.dto.VehicleDto;
import com.certant.vtv.utils.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@AllArgsConstructor
@Getter
@Setter
public class VehicleInspection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Timestamp dateInspection = Timestamp.from(Instant.now());;
    @Enumerated(EnumType.STRING)
    private State state;
    private Double cost;
    @OneToOne(mappedBy = "vehicleInspection", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Observation observation;
    @OneToOne(mappedBy = "vehicleInspection", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Measurement measurement;

    @OneToOne(mappedBy = "vehicleInspection", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Inspector inspector;
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;


}
