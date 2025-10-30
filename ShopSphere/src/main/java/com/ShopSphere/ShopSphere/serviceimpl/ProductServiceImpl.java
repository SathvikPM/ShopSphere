package com.ShopSphere.ShopSphere.serviceimpl;

import com.ShopSphere.ShopSphere.dto.ProductRequestDTO;
import com.ShopSphere.ShopSphere.dto.ProductResponseDTO;
import com.ShopSphere.ShopSphere.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public class ProductServiceImpl implements ProductService {

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequest, MultipartFile file) {
        return null;
    }
}
