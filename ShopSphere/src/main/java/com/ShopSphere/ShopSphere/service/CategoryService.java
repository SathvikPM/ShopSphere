package com.ShopSphere.ShopSphere.service;

import com.ShopSphere.ShopSphere.dto.CategoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    CategoryDTO createCategory(CategoryDTO dto);
    List<CategoryDTO> getAllCategory();
//    CategoryDTO getCategoryById();
//    CategoryDTO updateCategory(Long id,CategoryDTO dto);
//    CategoryDTO deleteCategory(Long id);


}
