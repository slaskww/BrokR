package com.apl.brokr.services;

import com.apl.brokr.dto.RegistrationDataDto;
import com.apl.brokr.dto.mappers.UserMapper;
import com.apl.brokr.model.entities.User;
import com.apl.brokr.model.entities.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RegistrationService {

    private UserService userService;

    @Autowired
    public RegistrationService(UserService userService) {
        this.userService = userService;
    }


    public void save(RegistrationDataDto data) {
            User user = UserMapper.toEntity(data);
            user.getRoles().add(new UserRole("CLIENT"));
            userService.save(user);
    }

    public void update(RegistrationDataDto data) {
            User user = UserMapper.toEntity(data);
            userService.save(user);

    }


  /*  public RegistrationDataDto getRegistrationDataDto(String username, List<String> roles){

        if (roles.contains("broker")){
            Broker broker = brokerService.findByUsername(username);
            return BrokerMapper.toDto(broker);
        } else {User client = clientService.findByUsername(username);
            return UserMapper.toDto(client);}
    }*/

    public RegistrationDataDto getRegistrationDataDto(String username) {

        User user = userService.findByUsername(username);
        System.out.println("test");
        RegistrationDataDto dto = UserMapper.toDto(user);
        System.out.println("test");
        return dto;
    }
}
