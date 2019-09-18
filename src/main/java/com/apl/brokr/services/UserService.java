package com.apl.brokr.services;

import com.apl.brokr.model.entities.User;
import com.apl.brokr.model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User findById(Long id){
        return userRepository.findById(id).get();

    }
    public boolean existsByUsername(String username){
       return userRepository.existsByUsername(username);
    }

    public Page<User> getAllClients(Pageable pageable){
       return userRepository.findUsersByRoles_RoleNameIn("ROLE_CLIENT", pageable);
    }
}
