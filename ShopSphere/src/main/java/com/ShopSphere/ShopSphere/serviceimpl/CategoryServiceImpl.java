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
        category.setName(category.getName());
        category.setDescription(category.getDescription());
        category.setImageUrl(imageUrl);

        Category saved=categoryRepository.save(category);

        CategoryDTO categoryDTO=new CategoryDTO();
        categoryDTO.setId(saved.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setDescription(category.getDescription());
        categoryDTO.setImageUrl(saved.getImageUrl());
        return categoryDTO;

    }


    //    @Override
//    public List<CategoryDTO> getAllCategory() {
//        List<Category> categories=categoryRepository.findAll();
//        List<CategoryDTO> dtoList=categories.stream().map(c->new CategoryDTO(c.getId(),c.getName(),c.getImageUrl())).toList();
//        return  dtoList;
//    }

//    @Override
//    public CategoryDTO getCategoryById(Long id) {
//        Category category=categoryRepository.findById(id).orElse(null);
//        CategoryDTO response=new CategoryDTO(category.getId(),category.getName(),category.getImageUrl());
//        return response;
//    }
//
//    @Override
//    public CategoryDTO updateCategory(Long id, CategoryDTO dto) {
//        Category category=categoryRepository.findById(id).orElse(null);
//        category.setName(dto.getName());
//        if(dto.getImageUrl()!=null){
//            category.setImageUrl(dto.getImageUrl());
//        }
//        Category updated=categoryRepository.save(category);
//        return new CategoryDTO(updated.getId(), updated.getName(),updated.getImageUrl());
//    }
//
//    @Override
//    public void deleteCategory(Long id) {
//        Category category=categoryRepository.findById(id).orElse(null);
////         Optionally delete the file
//         if(category!=null){
//             fileStorageService.deleteFile(category.getImageUrl());
//             categoryRepository.delete(category);
//         }
//
//
//    }
}
