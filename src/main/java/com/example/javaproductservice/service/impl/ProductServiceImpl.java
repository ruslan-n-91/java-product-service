package com.example.javaproductservice.service.impl;

import com.example.javaproductservice.controller.dto.request.CreateProductRequestDto;
import com.example.javaproductservice.controller.dto.request.UpdateProductRequestDto;
import com.example.javaproductservice.controller.dto.response.CreateProductResponseDto;
import com.example.javaproductservice.controller.dto.response.GetProductResponseDto;
import com.example.javaproductservice.controller.dto.response.UpdateProductResponseDto;
import com.example.javaproductservice.controller.exceptionhandler.exception.ProductNotFoundException;
import com.example.javaproductservice.controller.mapper.ProductMapper;
import com.example.javaproductservice.model.Product;
import com.example.javaproductservice.repository.ProductRepository;
import com.example.javaproductservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
//    private final CacheManager cacheManager;

    @Cacheable(value = "products_cache", key = "'allProducts'")
    @Override
    public List<GetProductResponseDto> findAllProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::mapToGetProductResponseDto)
                .toList();
    }

    @Cacheable(value = "products_cache", key = "#productId", unless="#result == null")
    @Override
    public GetProductResponseDto findProductById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product not found by id " + productId));
        return productMapper.mapToGetProductResponseDto(product);
    }

    @Caching(evict = {
            @CacheEvict(value = "products_cache", key = "'allProducts'"),
            @CacheEvict(value = "products_cache", key = "#result.id")
    })
    //@CacheEvict(value = "products_cache", key = "#result.id")
    //@CachePut(value = "products_cache", key = "#result.id")
    @Override
    public CreateProductResponseDto createProduct(CreateProductRequestDto requestDto) {
        Product product = createNewProduct(requestDto);

        product = productRepository.save(product);

        return productMapper.mapToCreateProductResponseDto(product);
    }

    @Caching(evict = {
            @CacheEvict(value = "products_cache", key = "'allProducts'"),
            @CacheEvict(value = "products_cache", key = "#result.id")
    })
    //@CachePut(value = "products_cache", key = "#orderId")
    @Override
    public UpdateProductResponseDto updateProduct(Long orderId, UpdateProductRequestDto requestDto) {
        Product product = productRepository.findById(orderId)
                .orElseThrow(() -> new ProductNotFoundException("Product not found by id " + orderId));

        updateProductFields(product, requestDto);

        product = productRepository.save(product);

        return productMapper.mapToUpdateProductResponseDto(product);
    }

    @Caching(evict = {
            @CacheEvict(value = "products_cache", key = "'allProducts'"),
            @CacheEvict(value = "products_cache", key = "#orderId")
    })
    @Override
    public void deleteProduct(Long orderId) {
        Product product = productRepository.findById(orderId)
                .orElseThrow(() -> new ProductNotFoundException("Product not found by id " + orderId));

        productRepository.delete(product);
    }

    private Product createNewProduct(CreateProductRequestDto requestDto) {
        Product product = new Product();

        if (requestDto.getId() != null) {
            product.setId(requestDto.getId());
        }
        product.setProductName(requestDto.getProductName());
        product.setDescription(requestDto.getDescription());
        product.setQuantity(requestDto.getQuantity());
        product.setCreatedAt(Instant.now());

        return product;
    }

    private void updateProductFields(Product product, UpdateProductRequestDto requestDto) {
        product.setProductName(requestDto.getProductName());
        product.setDescription(requestDto.getDescription());
        product.setQuantity(requestDto.getQuantity());
    }
}
