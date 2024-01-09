package com.jeffdev.product.domain.mappers;

import com.jeffdev.product.domain.dto.ProductRequest;
import com.jeffdev.product.domain.dto.ProductResponse;
import com.jeffdev.product.domain.model.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductMapper {

    public ProductEntity requestToEntity(ProductRequest productRequest){
        return ProductEntity.builder()
                .id(UUID.randomUUID().toString())
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();
    }

    public ProductResponse entityToResponse(ProductEntity productEntity){
        return new ProductResponse(
                productEntity.getId(),
                productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getPrice()
        );
    }
}
