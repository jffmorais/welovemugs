package com.jeffdev.product.repositories;

import com.jeffdev.product.domain.model.ProductEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<ProductEntity, String> {
}
