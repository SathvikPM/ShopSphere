package com.ShopSphere.ShopSphere.repository;

import com.ShopSphere.ShopSphere.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    boolean existsByNameIgnoreCase(String name);
}
