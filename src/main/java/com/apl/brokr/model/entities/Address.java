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

    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String street;
    @Column(name = "postal_code", nullable = false)
    private String postalCode;
    private String district; //powiat
    private String commune; // gmina
    private String province;  //wojew.
    @Column(nullable = false)
    private String country;
}
