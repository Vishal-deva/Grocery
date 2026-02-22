package com.example.clone.project.controller;


import com.example.clone.project.dto.ProductDto;
import com.example.clone.project.dto.ProductsDto;
import com.example.clone.project.dto.ResponseDto;
import com.example.clone.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/save-products")
    public ResponseEntity<ResponseDto>saveOrupdateProductDetails(@RequestBody ProductDto productDto)
    {
        return ResponseEntity.ok(productService.saveOrupdateProductDetails(productDto));
    }

    @GetMapping("/get-products")
    public ResponseEntity<ProductsDto>searchProduct(@RequestParam String productName)
    {
        return ResponseEntity.ok(productService.searchProduct(productName));
    }

    @GetMapping("/get-Allproducts")
    public ResponseEntity<ProductsDto>getAllProduct()
    {
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @GetMapping("/get-Getproducts")
    public ResponseEntity<ProductDto>getProduct(@RequestParam String productName)
    {
        return ResponseEntity.ok(productService.getProduct(productName));
    }

}
