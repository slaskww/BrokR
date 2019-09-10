package com.apl.brokr.services;

import com.apl.brokr.model.repositories.BrokerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrokerService {

    private BrokerRepository brokerRepository;

    @Autowired
    public BrokerService(BrokerRepository brokerRepository) {
        this.brokerRepository = brokerRepository;
    }
}
