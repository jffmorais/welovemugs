package com.jeffdev.product.controller;

import com.jeffdev.product.domain.model.ProductEntity;
import com.jeffdev.product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public List<ProductEntity> list(Pageable pageable) {
        return productService.listProduct(pageable).getContent();
    }
}
