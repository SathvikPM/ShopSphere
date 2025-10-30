package com.ShopSphere.ShopSphere.dto;

import com.ShopSphere.ShopSphere.model.ProductStatus;
import java.util.List;

public class ProductResponseDTO {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private Double discount;
    private Integer stockQuantity;
    private String imageUrl;
    private List<String> additionalImages;
    private String brand;
    private Double rating;
    private ProductStatus status;
    private String categoryName; // ✅ show readable category name
}
