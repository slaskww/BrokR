package com.apl.brokr.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "broker")
public class Broker extends User {

    @Column(name = "licence_no", nullable = false)
    private String licenceNumber;
}
