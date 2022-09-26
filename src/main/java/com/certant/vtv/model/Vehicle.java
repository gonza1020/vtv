package com.certant.vtv.model;

import com.certant.vtv.dto.PersonDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String licensePlate;
    private String brand;
    private String model;
    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "costumer_id")
    private Costumer costumer;
    @JsonIgnore
    @OneToMany(mappedBy = "vehicle")
    private List<VehicleInspection> vehicleInspection;

}
