package com.jeffdev.product.domain.model;

import jakarta.persistence.*;
import lombok.*;


import java.math.BigDecimal;

@Table(name = "product")
@Entity(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@EqualsAndHashCode(of = "id")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}
