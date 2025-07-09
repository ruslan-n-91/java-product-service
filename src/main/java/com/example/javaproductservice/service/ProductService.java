package com.example.javaproductservice.service;

import com.example.javaproductservice.controller.dto.request.CreateProductRequestDto;
import com.example.javaproductservice.controller.dto.request.UpdateProductRequestDto;
import com.example.javaproductservice.controller.dto.response.CreateProductResponseDto;
import com.example.javaproductservice.controller.dto.response.GetProductResponseDto;
import com.example.javaproductservice.controller.dto.response.UpdateProductResponseDto;

import java.util.List;

public interface ProductService {
    List<GetProductResponseDto> findAllProducts();

    GetProductResponseDto findProductById(Long orderId);

    CreateProductResponseDto createProduct(CreateProductRequestDto requestDto);

    UpdateProductResponseDto updateProduct(Long orderId, UpdateProductRequestDto requestDto);

    void deleteProduct(Long orderId);
}
