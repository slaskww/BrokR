package com.apl.brokr.model.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "general_insurance_category")
@Getter
@Setter
@ToString
public class GeneralInsuranceCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private long id;
    private String name;

}
