package com.jeffdev.order.domain.dto;

import java.util.List;

public record OrderRequest(
        List<OrderLineItemsRequest> orderLineItems
) {
}
