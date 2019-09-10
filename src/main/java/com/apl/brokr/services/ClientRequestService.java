package com.apl.brokr.services;

import com.apl.brokr.model.repositories.ClientRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClientRequestService {

    private ClientRequestRepository clientRequestRepository;

    @Autowired
    public ClientRequestService(ClientRequestRepository clientRequestRepository) {
        this.clientRequestRepository = clientRequestRepository;
    }
}
