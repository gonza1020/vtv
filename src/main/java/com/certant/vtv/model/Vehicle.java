package com.certant.vtv.model;

import com.certant.vtv.dto.PersonDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
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
