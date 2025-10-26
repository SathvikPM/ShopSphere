package com.ShopSphere.ShopSphere.serviceimpl;

import com.ShopSphere.ShopSphere.dto.CategoryResponseDTO;
import com.ShopSphere.ShopSphere.dto.CategoryRequestDTO;
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
    public CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequest, MultipartFile file) {
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

        CategoryResponseDTO categoryResponse =new CategoryResponseDTO();
        categoryResponse.setId(saved.getId());
        categoryResponse.setName(category.getName());
        categoryResponse.setDescription(category.getDescription());
        categoryResponse.setImageUrl(saved.getImageUrl());
        return categoryResponse;

    }

    @Override
    public List<CategoryResponseDTO> getAllCategories() {
       List<Category> categories=categoryRepository.findAll();
       return  categories.stream().map(c->{
           CategoryResponseDTO categoryResponse=new CategoryResponseDTO();
           categoryResponse.setName(c.getName());
           categoryResponse.setId(c.getId());
           categoryResponse.setDescription(c.getDescription());
           categoryResponse.setImageUrl(c.getImageUrl());
           return categoryResponse;
       }).collect(Collectors.toList());
    }



    @Override
    public CategoryResponseDTO getCategoryById(Long id) {
        Category category=categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
        CategoryResponseDTO categoryResponse=new CategoryResponseDTO();
        categoryResponse.setId(category.getId());
        categoryResponse.setName(category.getName());
        categoryResponse.setDescription(category.getDescription());
        categoryResponse.setImageUrl(category.getImageUrl());
         return categoryResponse;
    }

    @Override
    public CategoryResponseDTO updatecategory(Long id, CategoryRequestDTO categoryRequest, MultipartFile file) {
       Category category=categoryRepository.findById(id).orElseThrow(()->new RuntimeException("category not found with id "+id));

       if(categoryRequest.getName() != null && !categoryRequest.getName().equalsIgnoreCase(category.getName())) {
           boolean exists = categoryRepository.findAll()
                   .stream().anyMatch(c -> !c.getId().equals(id) && c.getName().equalsIgnoreCase(categoryRequest.getName()));
           if (exists) {
               throw new RuntimeException("Category with this name already exists");
           }
       }

        category.setName(categoryRequest.getName());
        category.setDescription(categoryRequest.getDescription());

       if(file!=null && !file.isEmpty()){
           fileStorageService.deleteFile(category.getImageUrl());
           String imageUrl=fileStorageService.saveFile(file,"category");
           category.setImageUrl(imageUrl);
       }
       Category updatedcategory=categoryRepository.save(category);

       CategoryResponseDTO categoryResponse =new CategoryResponseDTO(updatedcategory.getId(),updatedcategory.getName(),updatedcategory.getDescription(),updatedcategory.getImageUrl());
       return categoryResponse;



    }

    @Override
    public void deleteCategory(Long id) {
        Category category=categoryRepository.findById(id).orElseThrow(()->new RuntimeException("category not found with id "+id));
        fileStorageService.deleteFile(category.getImageUrl());
        categoryRepository.delete(category);

    }
}
