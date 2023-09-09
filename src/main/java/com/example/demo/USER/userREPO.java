package com.example.demo.USER;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface userREPO extends JpaRepository<User, Long> {


    Optional<User> findByEmail(String email);

    Optional<User> findByPassword(String password);
    Optional<User> findByEmailAndPassword(String email, String password);
}
