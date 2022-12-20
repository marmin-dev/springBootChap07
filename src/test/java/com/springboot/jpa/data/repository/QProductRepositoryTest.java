package com.springboot.jpa.data.repository;

import com.querydsl.core.types.Predicate;
import com.springboot.jpa.data.entity.Product;
import com.springboot.jpa.data.entity.QProduct;
import com.springboot.jpa.repository.QProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.Optional;

@DataJpaTest
public class QProductRepositoryTest {
    @Autowired
    QProductRepository qProductRepository;

    @Test
    public void queryDSLTest1(){
        Predicate predicate = QProduct.product.name.containsIgnoreCase("펜")
                .and(QProduct.product.price.between(1000,2500));
        Optional<Product> foundProduct = qProductRepository.findOne(predicate);
        if(foundProduct.isPresent()){
            Product product = foundProduct.get();
            System.out.println(product.getNumber());
            System.out.println(product.getName());
            System.out.println(product.getPrice());
            System.out.println(product.getStock());
        }
    }
    @Test
    public void queryDSLTest2(){
        QProduct qProduct = QProduct.product;
        Iterable<Product> productList = qProductRepository.findAll(
                qProduct.name.contains("펜")
        );
        for (Product product : productList){
            System.out.println(product.getNumber());
            System.out.println(product.getName());
            System.out.println(product.getPrice());
            System.out.println(product.getStock());
        }
    }
}
