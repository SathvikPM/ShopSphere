package com.ShopSphere.ShopSphere.service;

import com.ShopSphere.ShopSphere.dto.ProductRequestDTO;
import com.ShopSphere.ShopSphere.dto.ProductResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {

    ProductResponseDTO createProduct(ProductRequestDTO productRequest, MultipartFile file);
}
