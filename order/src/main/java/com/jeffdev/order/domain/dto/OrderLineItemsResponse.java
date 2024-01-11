package com.jeffdev.order.domain.dto;

import java.math.BigDecimal;

public record OrderLineItemsResponse(
        String id,
        String skuCode,
        BigDecimal price,
        Integer quantity
) {
}
