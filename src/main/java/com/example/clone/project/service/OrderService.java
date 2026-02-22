package com.example.clone.project.service;

import com.example.clone.project.dto.OrderDto;
import com.example.clone.project.dto.ResponseDto;
import com.example.clone.project.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderService  {

    ResponseDto addOrder(OrderDto orderdto);
}
