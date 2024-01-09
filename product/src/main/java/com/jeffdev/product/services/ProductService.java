package com.jeffdev.product.services;

import com.jeffdev.product.domain.dto.ProductRequest;
import com.jeffdev.product.domain.dto.ProductResponse;
import com.jeffdev.product.domain.mappers.ProductMapper;
import com.jeffdev.product.domain.model.ProductEntity;
import com.jeffdev.product.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductMapper productMapper;

    public List<ProductResponse> listProduct(Pageable pageable){
        return productRepository.findAll(pageable)
                .getContent()
                .stream()
                .map(product -> productMapper.entityToResponse(product))
                .collect(Collectors.toList());
    }

    public ProductResponse createProduct(ProductRequest productRequest){
        ProductEntity savedProduct = productRepository.save(productMapper.requestToEntity(productRequest));
        return productMapper.entityToResponse(savedProduct);
    }
}
