package com.jeffdev.order.domain.dto;

import java.util.List;

public record OrderResponse(
        String id,
        String orderNumber,
        List<OrderLineItemsResponse> orderLineItems
) {
}
