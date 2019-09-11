package com.apl.brokr.model.repositories;

import com.apl.brokr.model.entities.ClientRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRequestRepository extends JpaRepository<ClientRequest, Long> {

    List<ClientRequest> findAllByClient_Username(String username);
}
