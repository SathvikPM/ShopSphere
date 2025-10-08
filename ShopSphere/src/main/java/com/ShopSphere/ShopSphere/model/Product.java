package com.ShopSphere.ShopSphere.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "product name is mandetory")
    @Column(unique = true,nullable = false)
    private String name;

    private  String  description;
    @NotNull(message = "price name is mandetory")
    @Column(nullable = false)
    private Double price;
    @NotNull(message = "stock should be mandetory")
    @Column(unique = true,nullable = false)
    private Integer  stock;

    private String imageUrl;

    @ManyToOne
    @JoinColumn(name="category_id",nullable = false)
    private Category category;
}
