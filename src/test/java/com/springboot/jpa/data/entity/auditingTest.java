package com.springboot.jpa.data.entity;

import com.springboot.jpa.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@DataJpaTest
public class auditingTest {
    @Autowired
    ProductRepository productRepository;
    @Test
    public void auditingTest(){
        Product product = new Product();
        product.setName("펜");
        product.setPrice(1000);
        product.setStock(100);

        Product savedProduct = productRepository.save(product);

        System.out.println("ProductName " + savedProduct.getName());
        System.out.println("CreatedAt" + savedProduct.getCreatedAt());
    }
}
