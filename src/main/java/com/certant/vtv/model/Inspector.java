package com.certant.vtv.model;

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
public class Inspector extends Person{

    @JsonIgnore
    @OneToMany(targetEntity = VehicleInspection.class, mappedBy = "inspector")
    private List<VehicleInspection> vehicleInspection;
}
