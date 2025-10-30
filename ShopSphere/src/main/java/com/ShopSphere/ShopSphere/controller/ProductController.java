package com.ShopSphere.ShopSphere.controller;

import com.ShopSphere.ShopSphere.dto.ProductRequestDTO;
import com.ShopSphere.ShopSphere.dto.ProductResponseDTO;
import com.ShopSphere.ShopSphere.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

public class ProductController {


    private ProductService productService;


    public ResponseEntity<ProductResponseDTO> createProduct(
            @RequestPart("product")ProductRequestDTO productRequest,
            @RequestPart(value = "file",required = false)MultipartFile file) {

        ProductResponseDTO created =productService.createProduct(productRequest,file);
        return  ResponseEntity.ok(created);

    }
}
