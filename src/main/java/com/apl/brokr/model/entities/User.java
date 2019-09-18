package com.apl.brokr.model.entities;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User extends BaseUser {

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<ClientRequest> requests  = new ArrayList<>();
}
