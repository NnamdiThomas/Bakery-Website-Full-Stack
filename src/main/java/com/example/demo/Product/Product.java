package com.example.demo.Product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Product {
    @Id
    @SequenceGenerator(
            name = "Product_sequence",
            sequenceName = "Product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Product_sequence")
    private Long id;
    private String name;
    private String ProductSize;
    private String ProductAmount;
    private ProductType productType;
    private LocalDate ManufacturingDate;
    private String ImageURL;
}
