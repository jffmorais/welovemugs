package com.jeffdev.order.services;

import com.jeffdev.order.domain.dto.OrderRequest;
import com.jeffdev.order.domain.dto.OrderResponse;
import com.jeffdev.order.domain.mappers.OrderMapper;
import com.jeffdev.order.domain.model.OrderEntity;
import com.jeffdev.order.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

@Transactional
    public OrderResponse placeOrder(OrderRequest orderRequest){
//        TODO request validation
        OrderEntity toSave = orderMapper.mapToEntity(orderRequest);
        toSave.setOrderLineItems(
                orderRequest.orderLineItems()
                        .stream()
                        .map(orderLineItem -> orderMapper.mapToEntity(orderLineItem, toSave))
                        .collect(Collectors.toList())
        );
        OrderEntity savedOrder = orderRepository.save(toSave);
        log.info("Order was placed with ID {}", savedOrder.getOrderNumber());
        return orderMapper.mapToResponse(savedOrder);
    }
}
