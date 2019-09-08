package com.apl.brokr.model.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "request")
@Getter
@Setter
@ToString
public class ClientRequest {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id")
    private Long id;
    @Column(name = "request_date")
    private LocalDate requestDate;
    @OneToOne
    @JoinColumn(name = "id_client")
    private Client client;
    @OneToMany
    @JoinTable(name = "request_subcategory" , joinColumns = @JoinColumn(name = "request_id"), inverseJoinColumns = @JoinColumn(name = "subcategory_id"))
    private Collection<InsuranceSubcategory> subcategories = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name="general_insurance_id")
    private GeneralInsuranceCategory generalInsuranceCategory;
}
