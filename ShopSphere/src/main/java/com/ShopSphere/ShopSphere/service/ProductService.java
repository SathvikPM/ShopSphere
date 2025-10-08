package com.ShopSphere.ShopSphere.service;

import com.ShopSphere.ShopSphere.dto.ProductDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface ProductService {

    ProductDTO createProduct(String name, String description, Double price, Integer stock, MultipartFile file, Long categoryId);
//    List<ProductDTO> getAllProducts();
//    ProductDTO getProductById(Long id);
//    ProductDTO updateProduct(Long id,ProductDTO productDTO);
//    ProductDTO deleteProduct(Long id);

}
