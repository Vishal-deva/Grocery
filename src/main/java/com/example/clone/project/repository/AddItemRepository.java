package com.example.clone.project.repository;

import com.example.clone.project.entity.AddItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AddItemRepository extends JpaRepository<AddItemEntity,String> {



    List<AddItemEntity> findByCustomerIdAndProductId(String customerId, String productId);

    List<AddItemEntity> findAllByCustomerId(String customerId);
}
