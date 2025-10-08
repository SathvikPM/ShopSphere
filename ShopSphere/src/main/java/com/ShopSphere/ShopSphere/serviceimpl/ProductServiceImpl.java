package com.ShopSphere.ShopSphere.serviceimpl;

import com.ShopSphere.ShopSphere.dto.ProductDTO;
import com.ShopSphere.ShopSphere.model.Category;
import com.ShopSphere.ShopSphere.model.Product;
import com.ShopSphere.ShopSphere.repository.CategoryRepository;
import com.ShopSphere.ShopSphere.repository.ProductRepository;
import com.ShopSphere.ShopSphere.service.FileStorageService;
import com.ShopSphere.ShopSphere.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductServiceImpl implements ProductService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final FileStorageService fileStorageService;

    public ProductServiceImpl(CategoryRepository categoryRepository,
                             ProductRepository productRepository,
                              FileStorageService fileStorageService ){
        this.categoryRepository=categoryRepository;
        this.productRepository=productRepository;
        this.fileStorageService=fileStorageService;

    }


    @Override
    public ProductDTO createProduct(String name, String description, Double price, Integer stock, MultipartFile file, Long categoryId) {
        if (productRepository.existsByNameIgnoreCase(name)) {
            throw new RuntimeException("Product already exists");
        }
        String imageUrl=fileStorageService.saveFile(file,"products");
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found with ID: " + categoryId));

        Product product=new Product();
       product.setName(name);
       product.setDescription(description);
       product.setPrice(price);
       product.setStock(stock);
       product.setImageUrl(imageUrl);
       product.setCategory(category);
       Product saved=productRepository.save(product);
       ProductDTO productDTO=new ProductDTO(saved.getId(), saved.getName(), saved.getDescription(), saved.getPrice(), saved.getStock(), saved.getImageUrl(),saved.getCategory().getId());
       return  productDTO;


    }
}
