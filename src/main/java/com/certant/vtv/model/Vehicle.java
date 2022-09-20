package com.certant.vtv.model;

import com.certant.vtv.dto.PersonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Getter
@Setter
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String licensePlate;
    private String brand;
    private String model;

    @ManyToOne()
    @JoinColumn(name = "costumer_id")
    private Costumer costumer;
}
