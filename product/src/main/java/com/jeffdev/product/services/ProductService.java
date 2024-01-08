package com.jeffdev.product.services;

import com.jeffdev.product.domain.model.ProductEntity;
import com.jeffdev.product.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Page<ProductEntity> listProduct(Pageable pageable){
        return productRepository.findAll(pageable);
    }
}
