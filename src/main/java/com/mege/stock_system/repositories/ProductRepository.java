package com.mege.stock_system.repositories;

import com.mege.stock_system.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, String> {
    @Query(value = "SELECT * FROM products WHERE name=%:name%", nativeQuery = true)
    Optional<ProductModel> findByName(@RequestParam("name")String name);
}