package com.example.clone.project.controller;

import com.example.clone.project.dto.AddItemDto;
import com.example.clone.project.dto.OrderDto;
import com.example.clone.project.dto.ResponseDto;
import com.example.clone.project.service.AddItemService;
import com.example.clone.project.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OrderController {

        @Autowired
        private OrderService orderService;

        @PostMapping("/add-order")
        public ResponseEntity<ResponseDto> addOrder(@RequestBody OrderDto orderdto)
        {
            return ResponseEntity.ok(orderService.addOrder(orderdto));
        }
    }
