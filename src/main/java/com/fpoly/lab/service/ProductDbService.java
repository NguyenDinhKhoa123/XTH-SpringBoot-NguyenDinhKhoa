package com.fpoly.lab.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fpoly.lab.dto.request.ProductRequest;
import com.fpoly.lab.dto.response.ProductResponse;
import com.fpoly.lab.model.Category;
import com.fpoly.lab.model.ProductDb;
import com.fpoly.lab.repository.CategoryRepository;
import com.fpoly.lab.repository.ProductDbRepository;

@Service
public class ProductDbService {

    private final ProductDbRepository productDbRepository;
    private final CategoryRepository categoryRepository;

    public ProductDbService(ProductDbRepository productDbRepository,
            CategoryRepository categoryRepository) {
        this.productDbRepository = productDbRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<ProductResponse> getAllProducts() {
        return productDbRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public ProductResponse addProduct(ProductRequest request) {
        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));

        ProductDb product = new ProductDb();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setCategory(category);

        ProductDb savedProduct = productDbRepository.save(product);
        return toResponse(savedProduct);
    }

    public Page<ProductResponse> getProductsWithPagination(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());
        return productDbRepository.findAll(pageable)
                .map(this::toResponse);
    }

    private ProductResponse toResponse(ProductDb product) {
        Category category = product.getCategory();
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                category != null ? category.getId() : null,
                category != null ? category.getCategoryName() : null
        );
    }
}
