package com.example.clone.project.serviceImpl;

import com.example.clone.project.dto.OrderDto;
import com.example.clone.project.dto.OrderItemDto;
import com.example.clone.project.dto.ResponseDto;
import com.example.clone.project.entity.OrderEntity;
import com.example.clone.project.entity.OrderItemEntity;
import com.example.clone.project.repository.OrderItemRepository;
import com.example.clone.project.repository.OrderRepository;
import com.example.clone.project.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl implements OrderService {

@Autowired
    private OrderRepository orderRepository;

@Autowired
private OrderItemRepository orderItemRepository;

    @Override
    public ResponseDto addOrder(OrderDto orderdto) {
        ResponseDto response = new ResponseDto();
        try{
            if(!(orderdto.getCustomerId() == null)) {
                if (orderdto.getOrderId() == null) {
                    OrderEntity orderEntity = new OrderEntity();
                    orderEntity.setCustomerId(orderdto.getCustomerId());
                    orderEntity.setCustomerName(orderdto.getCustomerName());
                    orderEntity.setCustomerAddress(orderdto.getCustomerAddress());
                    orderEntity.setCustomerEmail(orderdto.getCustomerEmail());
                    orderEntity.setOrderStatus(orderdto.getOrderStatus());
                    orderEntity.setTotalAmount(orderdto.getTotalAmount());
                    OrderEntity id = orderRepository.save(orderEntity);

                    if (orderdto.getItems() != null && !orderdto.getItems().isEmpty()) {
                        for (OrderItemDto orderItemDto : orderdto.getItems()) {
                            OrderItemEntity orderItemEntity = new OrderItemEntity();
                            orderItemEntity.setOrderId(id.getOrderId());
                            orderItemEntity.setProductId(orderItemDto.getProductId());
                            orderItemEntity.setQuantity(orderItemDto.getQuantity());
                            orderItemEntity.setPricePerUnit(orderItemDto.getPricePerUnit());
                            orderItemEntity.setTotalPrice(orderItemDto.getPricePerUnit() * orderItemDto.getQuantity());
                            orderItemRepository.save(orderItemEntity);
                        }
                    }
                    response.setStatusCode("200");
                    response.setStatusMessage("Order created successfully");
                }
            }
            else
            {
                response.setStatusMessage("Customert Is Not Found Please Register!....");
            }
        } catch (Exception e) {
            response.setStatusCode("500");
            response.setStatusMessage("Failed to create order: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return response;
    }
}
