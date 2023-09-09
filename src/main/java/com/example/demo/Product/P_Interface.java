package com.example.demo.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface P_Interface extends JpaRepository<Product , Long> {
    Optional<Product> findByName(String name);

}
