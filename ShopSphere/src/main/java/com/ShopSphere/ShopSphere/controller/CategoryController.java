package com.ShopSphere.ShopSphere.controller;

import com.ShopSphere.ShopSphere.dto.CategoryDTO;
import com.ShopSphere.ShopSphere.dto.CategoryRequest;
import com.ShopSphere.ShopSphere.repository.CategoryRepository;
import com.ShopSphere.ShopSphere.service.CategoryService;
import com.ShopSphere.ShopSphere.serviceimpl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {


    public final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService=categoryService;
    }

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<CategoryDTO> createCategory(@RequestPart("category") CategoryRequest categoryRequest,
                                                      @RequestPart("file") MultipartFile file){

        CategoryDTO categoryDTO=categoryService.createCategory(categoryRequest,file);
        return  ResponseEntity.ok(categoryDTO);

    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories(){
        List<CategoryDTO> categories=categoryService.getAllCategories();
        return  ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id){
                CategoryDTO category=categoryService.getCategoryById(id);
                return  ResponseEntity.ok(category);
    }

}
