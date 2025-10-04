package com.ShopSphere.ShopSphere.controller;

import com.ShopSphere.ShopSphere.dto.CategoryDTO;
import com.ShopSphere.ShopSphere.repository.CategoryRepository;
import com.ShopSphere.ShopSphere.service.CategoryService;
import com.ShopSphere.ShopSphere.serviceimpl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService=categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO dto){

        CategoryDTO created=categoryService.createCategory(dto);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories(){
        List<CategoryDTO> categories=categoryService.getAllCategory();
        return ResponseEntity.ok(categories);
    }

















}
