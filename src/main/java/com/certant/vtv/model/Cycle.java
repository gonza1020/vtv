package com.certant.vtv.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@NoArgsConstructor
@Getter
@Setter
@ToString
@SuperBuilder
@Entity
@DiscriminatorValue("CYCLE")
public class Cycle extends Vehicle{
}
