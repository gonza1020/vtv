package com.certant.vtv.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@Setter
public class Costumer extends Person{

    @OneToMany(mappedBy = "costumer", cascade = CascadeType.ALL)
    private List<Vehicle> vehicles;
}
