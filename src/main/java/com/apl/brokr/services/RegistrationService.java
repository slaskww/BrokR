package com.apl.brokr.services;

import com.apl.brokr.dto.RegistrationDataDto;
import com.apl.brokr.dto.mappers.BrokerMapper;
import com.apl.brokr.dto.mappers.ClientMapper;
import com.apl.brokr.model.Role;
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


    public void save(RegistrationDataDto data) {

        if (data.getRole().equals("broker")) {
            Broker broker = BrokerMapper.toEntity(data);
            brokerService.save(broker);
        } else {
            Client client = ClientMapper.toEntity(data);
            clientService.save(client);
        }
    }

    public void update(RegistrationDataDto data) {
        if (data.getRole().equals("broker")) {
            Broker broker = BrokerMapper.toEntity(data);
            brokerService.save(broker);
        } else {
            Client client = ClientMapper.toEntity(data);
            clientService.save(client);
        }
    }


  /*  public RegistrationDataDto getRegistrationDataDto(String username, List<String> roles){

        if (roles.contains("broker")){
            Broker broker = brokerService.findByUsername(username);
            return BrokerMapper.toDto(broker);
        } else {Client client = clientService.findByUsername(username);
            return ClientMapper.toDto(client);}
    }*/

    public RegistrationDataDto getRegistrationDataDto(String username) {
        if (brokerService.findByUsername(username) != null) {
            return BrokerMapper.toDto(brokerService.findByUsername(username));
        } else {
            return ClientMapper.toDto(clientService.findByUsername(username));
        }
    }
}
