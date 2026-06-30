package com.fpoly.lab.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fpoly.lab.dto.request.ProductRequest;
import com.fpoly.lab.dto.response.ProductResponse;
import com.fpoly.lab.service.ProductDbService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/db/products")
public class ProductDbController {

    private final ProductDbService productDbService;

    public ProductDbController(
            ProductDbService productDbService) {

        this.productDbService = productDbService;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getProducts() {

        return ResponseEntity.ok(
                productDbService.getAllProducts()
        );
    }

    @PostMapping
    public ResponseEntity<ProductResponse> saveProduct(
            @Valid @RequestBody ProductRequest request) {

        return ResponseEntity.ok(
                productDbService.addProduct(request)
        );
    }

    @GetMapping("/page")
    public ResponseEntity<Page<ProductResponse>> getProductsPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {

        return ResponseEntity.ok(
                productDbService.getProductsWithPagination(
                        page,
                        size,
                        sortBy
                )
        );
    }
}
