package com.ShopSphere.ShopSphere.serviceimpl;

import com.ShopSphere.ShopSphere.dto.CategoryDTO;
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
    public CategoryDTO createCategory(String name, MultipartFile file) {
        boolean exists=categoryRepository.findAll()
                .stream()
                .anyMatch(c->c.getName().equalsIgnoreCase(name));
        if(exists){
            throw new RuntimeException("category alredy Exists");
        }
        String imageUrl=fileStorageService.saveFile(file);

        Category category=new Category();
        category.setName(name);
        category.setImageUrl(imageUrl);
        Category saved=categoryRepository.save(category);

        CategoryDTO categoryDTO=new CategoryDTO(saved.getId(), saved.getName(), saved.getImageUrl());
        return categoryDTO;

    }
    //    @Override
//    public List<CategoryDTO> getAllCategory() {
//        List<Category> categories=categoryRepository.findAll();
//        List<CategoryDTO> dtoList=categories.stream().map(c->new CategoryDTO(c.getId(),c.getName())).toList();
//        return  dtoList;
//    }

//    @Override
//    public CategoryDTO getCategoryById(Long id) {
//        Category category=categoryRepository.findById(id).orElse(null);
////        CategoryDTO response=new CategoryDTO(category.getId(),category.getName());
//        return response;
//    }

//    @Override
//    public CategoryDTO updateCategory(Long id, CategoryDTO dto) {
//        Category category=categoryRepository.findById(id).orElse(null);
//        category.setName(dto.getName());
//        Category updated=categoryRepository.save(category);
//        return new CategoryDTO(updated.getId(), updated.getName());
//    }

    @Override
    public void deleteCategory(Long id) {
        Category category=categoryRepository.findById(id).orElse(null);
         categoryRepository.delete(category);


    }
}
