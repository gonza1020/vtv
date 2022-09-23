package com.certant.vtv.model;

import com.certant.vtv.utils.CostumerType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@Setter
public class Costumer extends Person{


    @Enumerated(EnumType.STRING)
    private CostumerType costumerType;
    @OneToMany(mappedBy = "costumer", cascade = CascadeType.ALL)
    private List<Vehicle> vehicles;

}
