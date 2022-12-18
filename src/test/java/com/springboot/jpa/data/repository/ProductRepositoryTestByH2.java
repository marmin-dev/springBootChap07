package com.springboot.jpa.data.repository;

import com.springboot.jpa.data.entity.Product;
import com.springboot.jpa.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductRepositoryTestByH2 {

    @Autowired
    private ProductRepository productRepository;

    @Test //데이터 저장 테스트
    void saveTest(){
        //given
        Product product = new Product();
        product.setName("펜");
        product.setPrice(1000);
        product.setStock(1000);

        //when
        Product savedProduct = productRepository.save(product);
        //then
        assertEquals(product.getName(),savedProduct.getName());
        assertEquals(product.getPrice(),savedProduct.getPrice());
        assertEquals(product.getStock(),savedProduct.getStock());
    }
    @Test //Get
    void selectTest(){
        //given
        Product product = new Product();
        product.setName("펜");
        product.setPrice(1000);
        product.setStock(1000);

        Product savedProduct = productRepository.saveAndFlush(product);
        //when
        Product foundProduct = productRepository.findById(savedProduct.getNumber()).get();

        //then
        assertEquals(product.getName(),foundProduct.getName());
        assertEquals(product.getPrice(),foundProduct.getPrice());
        assertEquals(product.getStock(),foundProduct.getStock());
    }
}

