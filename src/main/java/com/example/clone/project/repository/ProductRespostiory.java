package com.example.clone.project.repository;

import com.example.clone.project.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRespostiory extends JpaRepository<ProductEntity ,String> {

    List<ProductEntity> findByProductNameContainingIgnoreCase(String productName);

    Optional<ProductEntity> findByProductName(String productName);
}
