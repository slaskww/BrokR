package com.apl.brokr.model.entities;

import com.apl.brokr.model.Role;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@MappedSuperclass
@Getter
@Setter
@ToString(exclude = "password")
@AllArgsConstructor
@NoArgsConstructor
public class BaseUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_name", nullable = false)
    private String companyName;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "krs_number", nullable = false)
    private String krsNumber;
    @Column(name = "nip_number", nullable = false)
    private String nipNumber;
    @Column(name = "regon_number", nullable = false)
    private String regonNumber;
    @Column(name = "pkd_number", nullable = false)
    private String pkdNumber;

    @Embedded
    private Address address;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(name = "enabled")
    private Boolean enabled = Boolean.TRUE;
    @Enumerated(EnumType.STRING)
    private Role role;

    @ElementCollection
    @CollectionTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "username", referencedColumnName = "username"))
    private Set<UserRole> roles = new HashSet<>();

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
        BaseUser baseUser = (BaseUser) o;
        return id.equals(baseUser.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
