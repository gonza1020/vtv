package com.certant.vtv.model;


import com.certant.vtv.utils.Condition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VehicleInspection {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private LocalDate inspectionDate;
    private LocalDate expirationDate;
    @Enumerated(EnumType.STRING)
    private Condition conditionn;
    private Double cost;

    @OneToOne(targetEntity = Observation.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "observation_id",referencedColumnName = "id")
    private Observation observation;

    @JoinColumn(name = "measurement_id",referencedColumnName = "id")
    @OneToOne(targetEntity = Measurement.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Measurement measurement;


    @ManyToOne(targetEntity = Inspector.class)
    @JoinColumn(name = "inspector_id")
    private Inspector inspector;

    @ManyToOne(targetEntity = Vehicle.class)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;


}
