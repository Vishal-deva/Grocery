package com.example.clone.project.controller;


import com.example.clone.project.dto.AddItemDto;
import com.example.clone.project.dto.AddItemDtos;
import com.example.clone.project.dto.ResponseDto;
import com.example.clone.project.service.AddItemService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
@CrossOrigin(origins = "*")
public class AddItemController {

    @Autowired
    private AddItemService addItemService;

    @PostMapping("/add-item")
    public ResponseEntity<ResponseDto>addItem(@RequestBody AddItemDto addItemDto)
    {
        return ResponseEntity.ok(addItemService.addItem(addItemDto));
    }

    @GetMapping("/get-cart-product")
    public ResponseEntity<AddItemDtos>getProducts(@RequestParam String customerId)
    {
        return  ResponseEntity.ok(addItemService.getProducts(customerId));
    }

    @PostMapping("/delete-product")
    public ResponseEntity<ResponseDto>deleteItem(@RequestBody AddItemDto addItemDto)
    {
        return ResponseEntity.ok(addItemService.deleteItem(addItemDto));
    }

}


