package com.certant.vtv.model;

import com.certant.vtv.utils.VehicleType;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class VehicleData {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String brand;
    private String model;
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

}
