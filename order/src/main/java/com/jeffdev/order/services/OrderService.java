package com.jeffdev.order.services;

import com.jeffdev.order.domain.dto.OrderRequest;
import com.jeffdev.order.domain.dto.OrderResponse;
import com.jeffdev.order.domain.mappers.OrderMapper;
import com.jeffdev.order.domain.model.OrderEntity;
import com.jeffdev.order.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderResponse placeOrder(OrderRequest orderRequest){
        OrderEntity savedOrder = orderRepository.save(orderMapper.mapToEntity(orderRequest));
        log.info("Order was placed with ID {}", savedOrder.getOrderNumber());
        return orderMapper.mapToResponse(savedOrder);
    }
}
