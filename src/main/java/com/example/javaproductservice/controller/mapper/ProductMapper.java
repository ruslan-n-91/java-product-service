package com.example.javaproductservice.controller.mapper;

import com.example.javaproductservice.controller.dto.response.CreateProductResponseDto;
import com.example.javaproductservice.controller.dto.response.GetProductResponseDto;
import com.example.javaproductservice.controller.dto.response.UpdateProductResponseDto;
import com.example.javaproductservice.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "productName", target = "productName")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "createdAt", target = "createdAt")
    GetProductResponseDto mapToGetProductResponseDto(Product product);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "productName", target = "productName")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "createdAt", target = "createdAt")
    CreateProductResponseDto mapToCreateProductResponseDto(Product product);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "productName", target = "productName")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "createdAt", target = "createdAt")
    UpdateProductResponseDto mapToUpdateProductResponseDto(Product product);
}
