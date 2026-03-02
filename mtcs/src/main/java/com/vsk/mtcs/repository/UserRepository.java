package com.vsk.mtcs.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vsk.mtcs.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
