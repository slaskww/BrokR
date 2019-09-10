package com.apl.brokr.services;

import com.apl.brokr.dto.RegistrationDataDto;
import com.apl.brokr.dto.mappers.BrokerMapper;
import com.apl.brokr.dto.mappers.ClientMapper;
import com.apl.brokr.model.entities.Broker;
import com.apl.brokr.model.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private BrokerService brokerService;
    private ClientService clientService;

    @Autowired
    public RegistrationService(BrokerService brokerService, ClientService clientService) {
        this.brokerService = brokerService;
        this.clientService = clientService;
    }


    public void save(RegistrationDataDto data){

        if(data.getRole().equals("broker")){
            Broker broker = BrokerMapper.toEntity(data);
            brokerService.save(broker);
        }
        else{
            Client client = ClientMapper.toEntity(data);
            clientService.save(client);
        }
    }
}
