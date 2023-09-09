package com.example.demo.Admin;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface adminRepo extends JpaRepository<Admin, Long> {


    Optional<Admin> findByPassword(String password);

    Optional<Admin> findByEmail(String email);

    Optional<Admin> findByEmailAndPassword(String email ,String password);

}
