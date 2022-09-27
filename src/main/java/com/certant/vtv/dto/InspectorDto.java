package com.certant.vtv.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InspectorDto {
  
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String phoneNumber;
}
