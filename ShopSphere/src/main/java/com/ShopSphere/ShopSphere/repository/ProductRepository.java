package com.ShopSphere.ShopSphere.repository;

import com.ShopSphere.ShopSphere.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
