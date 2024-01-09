package com.jeffdev.product.controller;

import com.jeffdev.product.domain.dto.ProductRequest;
import com.jeffdev.product.domain.dto.ProductResponse;
import com.jeffdev.product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public List<ProductResponse> list(Pageable pageable) {
        return productService.listProduct(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse create(@RequestBody ProductRequest productRequest){
        return productService.createProduct(productRequest);
    }
}
