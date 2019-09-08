package com.apl.brokr.model.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@MappedSuperclass
@Getter
@Setter
@ToString
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_name")
    private String companyName;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "krs_number")
    private String krsNumber;
    @Column(name = "nip_number")
    private String nipNumber;
    @Column(name = "regon_number")
    private String regonNumber;
    @Column(name = "pkd_number")
    private String pkdNumber;

    @Embedded
    private Address address;

    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String role;

    @Column(name = "created_on")
    private LocalDateTime createdOn;
    @Column(name = "updated_on")
    private LocalDateTime updatedOn;

    @PrePersist
    public void prePersist() {
        createdOn = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedOn = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User baseUser = (User) o;
        return id.equals(baseUser.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
