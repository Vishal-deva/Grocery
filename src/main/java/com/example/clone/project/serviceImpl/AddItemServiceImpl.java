package com.example.clone.project.serviceImpl;

import com.example.clone.project.dto.AddItemDto;
import com.example.clone.project.dto.AddItemDtos;
import com.example.clone.project.dto.ResponseDto;
import com.example.clone.project.entity.AddItemEntity;
import com.example.clone.project.repository.AddItemRepository;
import com.example.clone.project.service.AddItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddItemServiceImpl implements AddItemService {

    @Autowired
    private AddItemRepository addItemRepository;

    @Override
    public ResponseDto addItem(AddItemDto addItemDto) {
        ResponseDto response = new ResponseDto();
        try {
            if (addItemDto.getCustomerId() == null) {
                response.setStatusCode("404");
                response.setStatusMessage("User Not Found!....");
                return response;
            }

            // Always search by customerId + productId (cart item is unique by that)
            List<AddItemEntity> entities = addItemRepository
                    .findByCustomerIdAndProductId(addItemDto.getCustomerId(), addItemDto.getProductId());

            if (!entities.isEmpty()) {
                AddItemEntity entity = entities.get(0);

                if ("Add".equalsIgnoreCase(addItemDto.getOperator())) {
                    entity.setQuantity(entity.getQuantity() + addItemDto.getQuantity());
                    addItemRepository.save(entity);
                    response.setStatusCode("200");
                    response.setStatusMessage("Product quantity increased");
                }
                else if ("Sub".equalsIgnoreCase(addItemDto.getOperator())) {
                    int newQuantity = entity.getQuantity() - addItemDto.getQuantity();
                    if (newQuantity <= 0) {
                        addItemRepository.delete(entity);
                        response.setStatusCode("200");
                        response.setStatusMessage("Product removed from cart");
                    } else {
                        entity.setQuantity(newQuantity);
                        addItemRepository.save(entity);
                        response.setStatusCode("200");
                        response.setStatusMessage("Product quantity decreased");
                    }
                }
            } else {
                // No existing item, add as new
                AddItemEntity newEntity = new AddItemEntity();
                newEntity.setCustomerId(addItemDto.getCustomerId());
                newEntity.setProductId(addItemDto.getProductId());
                newEntity.setProductName(addItemDto.getProductName());
                newEntity.setQuantity(addItemDto.getQuantity());
                newEntity.setPrice(addItemDto.getPrice());
                addItemRepository.save(newEntity);

                response.setStatusCode("200");
                response.setStatusMessage("Product Added Successfully");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return response;
    }


    @Override
    public AddItemDtos getProducts(String customerId) {
        AddItemDtos addItemDtos = new AddItemDtos(); // wrapper DTO
        List<AddItemDto> items = new ArrayList<>();

        try {
            List<AddItemEntity> addItemEntities = addItemRepository.findAllByCustomerId(customerId);

            for (AddItemEntity entity : addItemEntities) {
                AddItemDto addItemDto = new AddItemDto();
                addItemDto.setItemId(entity.getItemId());
                addItemDto.setCustomerId(entity.getCustomerId());
                addItemDto.setProductId(entity.getProductId());
                addItemDto.setProductName(entity.getProductName());
                addItemDto.setQuantity(entity.getQuantity());
                addItemDto.setPrice(entity.getPrice());
                // add operator if needed
                items.add(addItemDto);
            }

            addItemDtos.setAddItemDtos(items); // ✅ set list inside wrapper DTO
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return addItemDtos; // ✅ return wrapper DTO
    }

    @Override
    public ResponseDto deleteItem(AddItemDto addItemDto) {
        ResponseDto response = new ResponseDto();
        try {
            if (addItemDto.getCustomerId() == null || addItemDto.getProductId() == null) {
                response.setStatusCode("400");
                response.setStatusMessage("Invalid Request: customerId and productId are required");
                return response;
            }

            // Find item by customerId and productId
            List<AddItemEntity> entities = addItemRepository.findByCustomerIdAndProductId(
                    addItemDto.getCustomerId(), addItemDto.getProductId()
            );

            if (entities.isEmpty()) {
                response.setStatusCode("404");
                response.setStatusMessage("Item not found in cart");
            } else {
                // remove the first matching entity
                addItemRepository.delete(entities.get(0));
                response.setStatusCode("200");
                response.setStatusMessage("Item deleted successfully from cart");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return response;
    }


}
