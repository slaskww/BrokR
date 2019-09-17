package com.apl.brokr.services;

import com.apl.brokr.dto.RegistrationDataDto;
import com.apl.brokr.dto.mappers.UserMapper;
import com.apl.brokr.model.entities.User;
import com.apl.brokr.model.entities.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class RegistrationService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationService(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }


    public void save(RegistrationDataDto data) {
            User user = UserMapper.toEntity(data);
            user.getRoles().add(new UserRole("ROLE_CLIENT"));
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userService.save(user);
    }

    public void update(RegistrationDataDto data) {
            User user = UserMapper.toEntity(data);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userService.save(user);

    }

    public boolean isUsernameInDatabase(String username){
        return userService.existsByUsername(username);
    }

    public RegistrationDataDto getRegistrationDataDto(String username) {

        User user = userService.findByUsername(username);
        RegistrationDataDto dto = UserMapper.toDto(user);
        return dto;
    }
}
