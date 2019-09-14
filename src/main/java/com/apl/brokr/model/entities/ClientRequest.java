package com.apl.brokr.model.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
    private LocalDateTime requestDate;
    @OneToOne
    @JoinColumn(name = "id_client")
    private Client client;
    @ManyToMany
    @JoinTable(name = "request_subcategory" , joinColumns = @JoinColumn(name = "request_id"), inverseJoinColumns = @JoinColumn(name = "subcategory_id"))
    private List<InsuranceSubcategory> subcategories = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name="general_insurance_id")
    private GeneralInsuranceCategory generalInsuranceCategory;

    @PrePersist
    public void prePersist() {
        this.requestDate = LocalDateTime.now();
    }

}
