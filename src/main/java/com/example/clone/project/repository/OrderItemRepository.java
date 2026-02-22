package com.example.clone.project.repository;

import com.example.clone.project.entity.OrderEntity;
import com.example.clone.project.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity,String> {
}
