package com.certant.vtv.model;


import com.certant.vtv.utils.Condition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VehicleInspection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate InspectionDate;
    private LocalDate expirationDate;
    @Enumerated(EnumType.STRING)
    private Condition state;
    private Double cost;
    @OneToOne(mappedBy = "vehicleInspection", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Observation observation;

    @OneToOne(mappedBy = "vehicleInspection", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Measurement measurement;

    @ManyToOne()
    @JoinColumn(name = "inspector_id")
    private Inspector inspector;

    @ManyToOne()
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;


}
