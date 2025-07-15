package com.example.javaproductservice.controller;

import com.example.javaproductservice.controller.dto.request.CreateProductRequestDto;
import com.example.javaproductservice.controller.dto.request.UpdateProductRequestDto;
import com.example.javaproductservice.controller.dto.response.CreateProductResponseDto;
import com.example.javaproductservice.controller.dto.response.GetProductResponseDto;
import com.example.javaproductservice.controller.dto.response.UpdateProductResponseDto;
import com.example.javaproductservice.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
@Tag(name = "Product Service", description = "API для работы с продуктами")
public class ProductController {
    private final ProductService productService;

    @GetMapping()
    @Operation(summary = "Чтение всех продуктов")
    public ResponseEntity<List<GetProductResponseDto>> getAllProducts() {
        return ResponseEntity.ok(productService.findAllProducts());
    }

    @GetMapping("/{productId}")
    @Operation(summary = "Чтение конкретного продукта")
    public ResponseEntity<GetProductResponseDto> getProductById(@PathVariable("productId") Long productId) {
        return ResponseEntity.ok(productService.findProductById(productId));
    }

    @PostMapping()
    @Operation(summary = "Создание нового продукта")
    public ResponseEntity<CreateProductResponseDto> createProduct(@RequestBody CreateProductRequestDto requestDto) {
        return ResponseEntity.ok(productService.createProduct(requestDto));
    }

    @PutMapping("/{productId}")
    @Operation(summary = "Изменение продукта")
    public ResponseEntity<UpdateProductResponseDto> updateProduct(@PathVariable("productId") Long productId,
                                                                @RequestBody UpdateProductRequestDto requestDto) {
        return ResponseEntity.ok(productService.updateProduct(productId, requestDto));
    }

    @DeleteMapping("/{productId}")
    @Operation(summary = "Удаление продукта")
    public ResponseEntity<Void> deleteProduct(@PathVariable("productId") Long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }
}
