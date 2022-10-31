package com.certant.vtv.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@SuperBuilder
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Vehicle_type",
discriminatorType = DiscriminatorType.STRING)
public class Vehicle {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String licensePlate;
    private String brand;
    private String model;
    @ManyToOne(targetEntity = Costumer.class)
    @JoinColumn(name = "costumer_id")
    private Costumer costumer;
    private String version;
    @JsonIgnore
    @OneToMany(targetEntity = VehicleInspection.class,mappedBy = "vehicle")
    @ToString.Exclude
    private List<VehicleInspection> vehicleInspection;



}
