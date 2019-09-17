package com.apl.brokr.model.repositories;

import com.apl.brokr.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    Optional<User> findUserByUsername(String username);
    List<User> findAllByUsername(String username);
}
