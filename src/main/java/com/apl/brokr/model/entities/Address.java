package com.apl.brokr.model.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
@ToString
public class Address {

    private String city;
    private String street;
    @Column(name = "postal_code")
    private String postalCode;
    private String district; //powiat
    private String commune; // gmina
    private String province;  //wojew.
    private String country;
}
