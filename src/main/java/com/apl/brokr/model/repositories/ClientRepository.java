package com.apl.brokr.model.repositories;

import com.apl.brokr.model.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByUsername(String username);
    List<Client> findAllByUsername(String username);
}
