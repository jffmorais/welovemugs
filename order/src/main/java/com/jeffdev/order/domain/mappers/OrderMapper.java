package com.jeffdev.order.domain.mappers;

import com.jeffdev.order.domain.dto.OrderLineItemsRequest;
import com.jeffdev.order.domain.dto.OrderLineItemsResponse;
import com.jeffdev.order.domain.dto.OrderRequest;
import com.jeffdev.order.domain.dto.OrderResponse;
import com.jeffdev.order.domain.model.OrderEntity;
import com.jeffdev.order.domain.model.OrderLineItemsEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderMapper {

    public OrderEntity mapToEntity(OrderRequest orderRequest){
        return OrderEntity.builder()
                .id(UUID.randomUUID().toString())
                .orderNumber(UUID.randomUUID().toString())
                .orderLineItemsEntityList(
                        orderRequest.orderLineItemsRequestList()
                                .stream()
                                .map(this::mapToEntity)
                                .collect(Collectors.toList())
                )
                .build();
    }

    public OrderResponse mapToResponse(OrderEntity orderEntity){
        return new OrderResponse(
                orderEntity.getId(),
                orderEntity.getOrderNumber(),
                orderEntity.getOrderLineItemsEntityList()
                        .stream()
                        .map(this::mapToResponse)
                        .collect(Collectors.toList())
        );
    }

    public OrderLineItemsEntity mapToEntity(OrderLineItemsRequest orderLineItemsRequest){
        return OrderLineItemsEntity.builder()
                .price(orderLineItemsRequest.price())
                .quantity(orderLineItemsRequest.quantity())
                .skuCode(orderLineItemsRequest.skuCode())
                .build();
    }

    public OrderLineItemsResponse mapToResponse(OrderLineItemsEntity orderLineItemsEntity){
        return new OrderLineItemsResponse(
                orderLineItemsEntity.getId(),
                orderLineItemsEntity.getSkuCode(),
                orderLineItemsEntity.getPrice(),
                orderLineItemsEntity.getQuantity()
        );
    }
}
