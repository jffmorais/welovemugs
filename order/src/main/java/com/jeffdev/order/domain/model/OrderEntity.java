package com.jeffdev.order.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "order")
@Entity(name = "order")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@EqualsAndHashCode(of = "id")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "order_number")
    private String orderNumber;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderLineItemsEntity> orderLineItemsEntityList;
}
