package com.apl.brokr.model.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "broker")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Broker extends BaseUser {


    @Column(name = "licence_no", nullable = false)
    private String licenceNumber;

}
