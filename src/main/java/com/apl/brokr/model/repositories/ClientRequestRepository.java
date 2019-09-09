package com.apl.brokr.model.repositories;

import com.apl.brokr.model.entities.ClientRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRequestRepository extends JpaRepository<ClientRequest, Long> {
}
