package com.springboot.jpa.repository;

import com.springboot.jpa.data.entity.Product;

import java.util.List;

public interface ProductRepositoryCustom {
    List<Product> findByName(String name);
}
