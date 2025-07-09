package com.example.javaproductservice.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductResponseDto {
    private Long id;
    private String productName;
    private String description;
    private Integer quantity;
    private Instant createdAt;
}
