package com.certant.vtv.model;

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

    @OneToMany(mappedBy = "inspector")
    private List<VehicleInspection> vehicleInspection;
}
