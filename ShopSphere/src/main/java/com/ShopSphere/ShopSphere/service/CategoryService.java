package com.ShopSphere.ShopSphere.service;

import com.ShopSphere.ShopSphere.dto.CategoryResponseDTO;
import com.ShopSphere.ShopSphere.dto.CategoryRequestDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface CategoryService {

    CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequest, MultipartFile file);
    List<CategoryResponseDTO> getAllCategories();
    CategoryResponseDTO getCategoryById(Long id);

    CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO categoryRequest, MultipartFile file);

    void deleteCategory(Long id);



}
