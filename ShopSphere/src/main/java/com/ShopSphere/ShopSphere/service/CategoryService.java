package com.ShopSphere.ShopSphere.service;

import com.ShopSphere.ShopSphere.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    CategoryDTO createCategory();
    List<CategoryDTO> getAllCategory();
    CategoryDTO getCategoryById();
    CategoryDTO updateCategory(Long id,CategoryDTO dto);
    CategoryDTO deleteCategory(Long id);


}
