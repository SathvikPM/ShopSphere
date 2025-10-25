package com.ShopSphere.ShopSphere.serviceimpl;

import com.ShopSphere.ShopSphere.dto.CategoryDTO;
import com.ShopSphere.ShopSphere.dto.CategoryRequest;
import com.ShopSphere.ShopSphere.model.Category;
import com.ShopSphere.ShopSphere.repository.CategoryRepository;
import com.ShopSphere.ShopSphere.service.CategoryService;
import com.ShopSphere.ShopSphere.service.FileStorageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final FileStorageService fileStorageService;
    public CategoryServiceImpl(CategoryRepository categoryRepository,FileStorageService fileStorageService){
        this.categoryRepository=categoryRepository;
        this.fileStorageService=fileStorageService;
    }

    @Override
    public CategoryDTO createCategory(CategoryRequest categoryRequest, MultipartFile file) {
        boolean exists=categoryRepository.findAll()
                .stream()
                        .anyMatch(c->c.getName()
                        .equalsIgnoreCase(categoryRequest.getName()));
        if(exists){
            throw new RuntimeException("Category already exists");
        }
        String imageUrl=fileStorageService.saveFile(file, "category");


        Category category=new Category();
        category.setName(categoryRequest.getName());
        category.setDescription(categoryRequest.getDescription());
        category.setImageUrl(imageUrl);

        Category saved=categoryRepository.save(category);

        CategoryDTO categoryDTO=new CategoryDTO();
        categoryDTO.setId(saved.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setDescription(category.getDescription());
        categoryDTO.setImageUrl(saved.getImageUrl());
        return categoryDTO;

    }

    @Override
    public List<CategoryDTO> getAllCategories() {
       List<Category> categories=categoryRepository.findAll();
       return  categories.stream().map(c->{
           CategoryDTO dto=new CategoryDTO();
           dto.setName(c.getName());
           dto.setId(c.getId());
           dto.setDescription(c.getDescription());
           dto.setImageUrl(c.getImageUrl());
           return dto;
       }).collect(Collectors.toList());
    }



    @Override
    public CategoryDTO getCategoryById(Long id) {
        Category category=categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
        CategoryDTO dto=new CategoryDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setDescription(category.getDescription());
        dto.setImageUrl(category.getImageUrl());
         return dto;
    }
}
