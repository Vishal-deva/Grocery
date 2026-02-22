package com.example.clone.project.service;

import com.example.clone.project.dto.ProductDto;
import com.example.clone.project.dto.ProductsDto;
import com.example.clone.project.dto.ResponseDto;

public interface ProductService {
    ResponseDto saveOrupdateProductDetails(ProductDto productDto);

    ProductsDto searchProduct(String productName);

    ProductsDto getAllProduct();

    ProductDto getProduct(String productName);
}
