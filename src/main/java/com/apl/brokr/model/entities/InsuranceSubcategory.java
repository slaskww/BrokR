package com.apl.brokr.model.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "insurance_subcategory")
@Getter
@Setter
@ToString
public class InsuranceSubcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subcategory")
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(name = "is_obligatory", nullable = false)
    private boolean isObligatory;
    @ManyToOne()
    @JoinColumn(name="id_general_category", nullable = false)
    private GeneralInsuranceCategory generalCat;
}
