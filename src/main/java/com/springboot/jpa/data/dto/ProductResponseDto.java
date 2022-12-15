package com.springboot.jpa.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class ProductResponseDto {
    private Long number;
    private String name;
    private int price;
}
