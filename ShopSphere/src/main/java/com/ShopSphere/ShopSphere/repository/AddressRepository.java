package com.ShopSphere.ShopSphere.repository;

import com.ShopSphere.ShopSphere.model.Address;
import com.ShopSphere.ShopSphere.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {



}
