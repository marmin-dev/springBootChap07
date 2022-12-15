package com.springboot.jpa.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
public class ProductDto {
    private String name;
    private int price;
    private int stock;
}
