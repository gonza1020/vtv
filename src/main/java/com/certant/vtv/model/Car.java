package com.certant.vtv.model;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;



@ToString
@SuperBuilder
@Entity
@DiscriminatorValue(value = "CAR")
@NoArgsConstructor
public class Car extends Vehicle{

}
