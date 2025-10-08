package com.ShopSphere.ShopSphere.dto;

import com.ShopSphere.ShopSphere.model.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private int id;

    @NotBlank(message = "product name is mandetory")
    private String name;

    private  String  description;

    @NotNull(message = "price name is mandetory")
    private Double price;

    @NotNull(message = "stock should be mandetory")
    private Integer  stock;

    private String imageUrl;

    @NotNull(message = "Category is mandatory")
    private Long categoryId;
}