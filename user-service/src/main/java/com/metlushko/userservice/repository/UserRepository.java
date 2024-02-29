package com.metlushko.userservice.repository;


import com.metlushko.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsernameOrEmail(String username, String email);

    Optional<User> findById(Long aLong);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
