package com.ShopSphere.ShopSphere.serviceimpl;

import com.ShopSphere.ShopSphere.dto.CategoryResponseDTO;
import com.ShopSphere.ShopSphere.dto.ProductRequestDTO;
import com.ShopSphere.ShopSphere.dto.ProductResponseDTO;
import com.ShopSphere.ShopSphere.repository.CategoryRepository;
import com.ShopSphere.ShopSphere.repository.ProductRepository;
import com.ShopSphere.ShopSphere.service.FileStorageService;
import com.ShopSphere.ShopSphere.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public class ProductServiceImpl implements ProductService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final FileStorageService fileStorageService;

    public ProductServiceImpl(ProductRepository productRepository,
                             CategoryRepository categoryRepository,
                             FileStorageService fileStorageService){
        this.productRepository=productRepository;
        this.categoryRepository=categoryRepository;
        this.fileStorageService=fileStorageService;

    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequest, MultipartFile file) {

        categoryRepository.findById(productRequest.getCategoryId()).orElseThrow(()->new RuntimeException("Category not found with id: "+productRequest.getCategoryId()));
        if(productRepository.existsByNameIgnoreCase(productRequest.getName())){
            throw new RuntimeException("Product with this name alredy exists");
        }
    }
}
