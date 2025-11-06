package com.ShopSphere.ShopSphere.service;

import com.ShopSphere.ShopSphere.dto.ProductRequestDTO;
import com.ShopSphere.ShopSphere.dto.ProductResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface ProductService {

    ProductResponseDTO createProduct(ProductRequestDTO productRequest, MultipartFile image, List<MultipartFile> additionalImages);
    List<ProductResponseDTO> getAllProducts();

    List<ProductResponseDTO> getProductsByCategory(Long id);

    ProductResponseDTO getProductById(Long id);

    ProductResponseDTO updateProduct(Long id,ProductRequestDTO productRequest,MultipartFile image, List<MultipartFile> additionalImages);

    void deleteProduct(Long id);
}
