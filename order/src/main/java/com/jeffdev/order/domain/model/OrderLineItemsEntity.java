package com.jeffdev.order.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Table(name = "order_line_items")
@Entity(name = "order_line_items")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@EqualsAndHashCode(of = "id")
public class OrderLineItemsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "sku_code")
    private String skuCode;

    private BigDecimal price;

    private Integer quantity;
}
