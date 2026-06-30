package com.fpoly.lab.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProductRequest {

    @NotBlank(message = "Tên sản phẩm không được để trống")
    @Size(min = 3, max = 50, message = "Tên sản phẩm phải từ 3 đến 50 ký tự")
    private String name;

    @NotNull(message = "Giá sản phẩm không được để trống")
    @Min(value = 1000, message = "Giá sản phẩm phải lớn hơn hoặc bằng 1000")
    private Double price;

    private Long categoryId;

    public ProductRequest() {
    }

    public ProductRequest(String name, Double price, Long categoryId) {
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
