package com.ShopSphere.ShopSphere.service;

import com.ShopSphere.ShopSphere.dto.CategoryDTO;
import com.ShopSphere.ShopSphere.dto.CategoryRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface CategoryService {

    CategoryDTO createCategory(CategoryRequest categoryRequest, MultipartFile file);
    List<CategoryDTO> getAllCategories();
    CategoryDTO getCategoryById(Long id);

    CategoryDTO updatecategory(Long id,CategoryRequest categoryRequest,MultipartFile file);

    void deleteCategory(Long id);



}
