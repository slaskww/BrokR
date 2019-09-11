package com.apl.brokr.model.repositories;

import com.apl.brokr.model.entities.Broker;
import com.apl.brokr.model.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrokerRepository extends JpaRepository<Broker, Long> {

    Broker findByUsername(String username);
}
