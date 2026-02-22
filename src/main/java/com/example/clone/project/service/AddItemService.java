package com.example.clone.project.service;

import com.example.clone.project.dto.AddItemDto;
import com.example.clone.project.dto.AddItemDtos;
import com.example.clone.project.dto.ResponseDto;

public interface AddItemService {

    ResponseDto addItem(AddItemDto addItemDto);

    AddItemDtos getProducts(String customerId);

    ResponseDto deleteItem(AddItemDto addItemDto);
}
