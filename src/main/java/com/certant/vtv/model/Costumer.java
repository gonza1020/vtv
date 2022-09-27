package com.certant.vtv.model;

import com.certant.vtv.utils.CostumerType;
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
public class Costumer extends Person{


    @Enumerated(EnumType.STRING)
    private CostumerType costumerType;
    @JsonIgnore
    @OneToMany(targetEntity = Vehicle.class, mappedBy = "costumer", cascade = CascadeType.ALL)
    private List<Vehicle> vehicles;

}
