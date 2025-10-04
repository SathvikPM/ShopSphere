package com.ShopSphere.ShopSphere.serviceimpl;

import com.ShopSphere.ShopSphere.dto.CategoryDTO;
import com.ShopSphere.ShopSphere.model.Category;
import com.ShopSphere.ShopSphere.repository.CategoryRepository;
import com.ShopSphere.ShopSphere.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository=categoryRepository;
    }
    @Override
    public CategoryDTO createCategory(CategoryDTO dto) {

        boolean exists=categoryRepository.findAll().
                stream().anyMatch(c->c.getName().equalsIgnoreCase(dto.getName()));
        if(exists){
            throw new RuntimeException("Category already Exists");
        }
        Category category=new Category();
        category.setName(dto.getName());

        Category saved=categoryRepository.save(category);

        CategoryDTO response=new CategoryDTO();
        response.setId(saved.getId());
        response.setName(saved.getName());

        return  response;
    }

    @Override
    public List<CategoryDTO> getAllCategory() {
        List<Category> categories=categoryRepository.findAll();
        List<CategoryDTO> dtoList=categories.stream().map(c->new CategoryDTO(c.getId(),c.getName())).toList();
        return  dtoList;
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        Category category=categoryRepository.findById(id).orElse(null);
        CategoryDTO response=new CategoryDTO(category.getId(),category.getName());
        return response;
    }

    @Override
    public CategoryDTO updateCategory(Long id, CategoryDTO dto) {
        Category category=categoryRepository.findById(id).orElse(null);
        category.setName(dto.getName());
        Category updated=categoryRepository.save(category);
        return new CategoryDTO(updated.getId(), updated.getName());
    }

    @Override
    public void deleteCategory(Long id) {
        Category category=categoryRepository.findById(id).orElse(null);
         categoryRepository.delete(category);


    }
}
