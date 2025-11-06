package com.ShopSphere.ShopSphere.controller;

import com.ShopSphere.ShopSphere.dto.ProductRequestDTO;
import com.ShopSphere.ShopSphere.dto.ProductResponseDTO;
import com.ShopSphere.ShopSphere.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {


    private final ProductService productService;

    public  ProductController(ProductService productService){
        this.productService=productService;

    }




    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<ProductResponseDTO> createProduct(
            @RequestPart("product")ProductRequestDTO productRequest,
            @RequestPart(value = "image",required = false)MultipartFile image,
            @RequestPart(value = "additionalImages",required = false)List<MultipartFile> additionalImages) {

        ProductResponseDTO created =productService.createProduct(productRequest,image,additionalImages);
        return  ResponseEntity.ok(created);

    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts(){
        List<ProductResponseDTO> products=productService.getAllProducts();
        return ResponseEntity.ok(products);
    }
}
