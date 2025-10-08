package com.ShopSphere.ShopSphere.controller;

import com.ShopSphere.ShopSphere.dto.ProductDTO;
import com.ShopSphere.ShopSphere.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/products")
public class ProductController {

    private  final ProductService productService ;

    public ProductController(ProductService productService){
        this.productService=productService;

    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestParam("name") String name,
                                                    @RequestParam("file") MultipartFile file,
                                                    @RequestParam("description") String description,
                                                    @RequestParam("price") Double price,
                                                    @RequestParam("stock")Integer stock,
                                                    @RequestParam("category")Long categoryId){
        ProductDTO productDTO=productService.createProduct(name,description,price,stock,file,categoryId);
        return  ResponseEntity.ok(productDTO);
    }

}
