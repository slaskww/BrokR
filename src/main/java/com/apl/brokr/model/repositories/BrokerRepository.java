package com.apl.brokr.model.repositories;

import com.apl.brokr.model.entities.Broker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrokerRepository extends JpaRepository<Broker, Long> {

    Broker findByUsername(String username);
}
