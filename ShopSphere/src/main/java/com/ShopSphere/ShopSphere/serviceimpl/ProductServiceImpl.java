package com.ShopSphere.ShopSphere.serviceimpl;

import com.ShopSphere.ShopSphere.dto.CategoryResponseDTO;
import com.ShopSphere.ShopSphere.dto.ProductRequestDTO;
import com.ShopSphere.ShopSphere.dto.ProductResponseDTO;
import com.ShopSphere.ShopSphere.model.Category;
import com.ShopSphere.ShopSphere.model.Product;
import com.ShopSphere.ShopSphere.model.ProductStatus;
import com.ShopSphere.ShopSphere.repository.CategoryRepository;
import com.ShopSphere.ShopSphere.repository.ProductRepository;
import com.ShopSphere.ShopSphere.service.FileStorageService;
import com.ShopSphere.ShopSphere.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
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
    public ProductResponseDTO createProduct(ProductRequestDTO productRequest, MultipartFile image, List<MultipartFile> additionalImages) {

        Category category =categoryRepository.findById(productRequest.getCategoryId()).orElseThrow(()->
                new RuntimeException("Category not found with id: "+productRequest.getCategoryId()));
        if(productRepository.existsByNameIgnoreCase(productRequest.getName())){
            throw new RuntimeException("Product with this name alredy exists");
        }


        String imageUrl=fileStorageService.saveFile(image,"product");


        List<String> additionalImageUrls=new ArrayList<>();
        if(additionalImages!=null &&  !additionalImages.isEmpty()){
            for(MultipartFile file:additionalImages){
              String filepath=fileStorageService.saveFile(file,"product");
              additionalImageUrls.add(filepath);
            }
        }

        Product product=new Product();


        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setImageUrl(imageUrl);
        product.setAdditionalImages(additionalImageUrls);
        product.setBrand(productRequest.getBrand());
        product.setDiscount(productRequest.getDiscount());
        product.setCategory(category);
        product.setPrice(productRequest.getPrice());
        product.setStatus(productRequest.getStatus());
        product.setStockQuantity(productRequest.getStockQuantity());
        product.setRating(productRequest.getRating());


        Product saved =productRepository.save(product);

        ProductResponseDTO dto=new ProductResponseDTO();
        dto.setId(saved.getId());
        dto.setName(saved.getName());
        dto.setDescription(saved.getDescription());
        dto.setImageUrl(saved.getImageUrl());
        dto.setAdditionalImages(additionalImageUrls);
        dto.setBrand(saved.getBrand());
        dto.setDiscount(saved.getDiscount());
        dto.setCategoryName(saved.getName());
        dto.setPrice(saved.getPrice());
        dto.setStatus(saved.getStatus());
        dto.setStockQuantity(saved.getStockQuantity());
        dto.setRating(saved.getRating());


        return  dto;

    }
}
