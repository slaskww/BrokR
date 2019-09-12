package com.apl.brokr.services;

import com.apl.brokr.model.entities.Broker;
import com.apl.brokr.model.repositories.BrokerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BrokerService {

    private BrokerRepository brokerRepository;

    @Autowired
    public BrokerService(BrokerRepository brokerRepository) {
        this.brokerRepository = brokerRepository;
    }


    public void save(Broker broker){
        broker.setLicenceNumber("licence-no-19834");
        brokerRepository.save(broker);
    }

    public Broker findByUsername(String username){
      return brokerRepository.findByUsername(username);
    }
}
