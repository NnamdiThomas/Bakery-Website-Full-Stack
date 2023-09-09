package com.example.demo.Cart;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Cart {
    @Id
    @SequenceGenerator(
            name = "Cart_sequence",
            sequenceName = "Cart_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Cart_sequence")
    private Long id;
    private String name;
    private Integer price;
    private Integer Total;

}
