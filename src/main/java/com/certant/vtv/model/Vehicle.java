package com.certant.vtv.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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

    @Pattern(regexp = "[A-Za-z]{3}[\\d]{3}|[A-Za-z]{2}[\\d]{3}[A-Za-z]{2}", message = "Patente incorrecta. Los formatos validos son: ABC123 o AB123CD")
    private String licensePlate;
    @NotBlank(message = "La marca no puede estar vacia")
    private String brand;
    @NotBlank(message = "El modelo no puede estar vacio")
    private String model;
    @ManyToOne(targetEntity = Costumer.class)
    @JoinColumn(name = "costumer_id")
    private Costumer costumer;
    @JsonIgnore
    @OneToMany(targetEntity = VehicleInspection.class,mappedBy = "vehicle")
    private List<VehicleInspection> vehicleInspection;

}
