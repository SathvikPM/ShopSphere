package com.ShopSphere.ShopSphere.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Product name is mandatory")
    @Column(unique = true, nullable = false)
    private String name;

    private String description;

    @NotNull
    private Double price;

    private Double discount;

    private Integer stockQuantity;

    private String imageUrl;

    @ElementCollection
    private List<String> additionalImages;

    private String brand;

    private Double rating;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
