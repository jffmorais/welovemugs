package com.jeffdev.product.services;

import com.jeffdev.product.domain.dto.ProductRequest;
import com.jeffdev.product.domain.dto.ProductResponse;
import com.jeffdev.product.domain.mappers.ProductMapper;
import com.jeffdev.product.domain.model.ProductEntity;
import com.jeffdev.product.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<ProductResponse> listProduct(Pageable pageable){
        return productRepository.findAll(pageable)
                .getContent()
                .stream()
                .map(productMapper::entityToResponse)
                .collect(Collectors.toList());
    }

    public ProductResponse createProduct(ProductRequest productRequest){
        ProductEntity savedProduct = productRepository.save(productMapper.requestToEntity(productRequest));
        log.info("Product {} was saved with ID {}", savedProduct.getName(), savedProduct.getId());
        return productMapper.entityToResponse(savedProduct);
    }
}
