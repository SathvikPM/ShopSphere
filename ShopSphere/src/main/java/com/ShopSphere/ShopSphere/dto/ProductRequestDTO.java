package com.ShopSphere.ShopSphere.dto;

import com.ShopSphere.ShopSphere.model.ProductStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDTO {

    @NotBlank(message = "Product name is mandatory")
    private String name;

    private String description;

    @NotNull
    private Double price;

    private Double discount;

    private Integer stockQuantity;

    private String imageUrl;

    private List<String> additionalImages;

    private String brand;

    private Double rating;

    private ProductStatus status;

    @NotNull(message = "Category ID is required")
    private Long categoryId; // ✅ only store ID, not full object
}
