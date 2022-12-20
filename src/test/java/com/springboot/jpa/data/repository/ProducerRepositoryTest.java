package com.springboot.jpa.data.repository;

import com.springboot.jpa.data.entity.Producer;
import com.springboot.jpa.data.entity.Product;
import com.springboot.jpa.repository.ProducerRepository;
import com.springboot.jpa.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ProducerRepositoryTest {
    @Autowired
    ProducerRepository producerRepository;
    @Autowired
    ProductRepository productRepository;

    @Test
    void relationShipTest(){
        Product product1 = new Product();
        product1.setName("동글펜");
        product1.setPrice(500);
        product1.setStock(1000);

        Product product2 = new Product();
        product2.setName("네모 공책");
        product2.setPrice(100);
        product2.setStock(2000);

        Product product3 = new Product();
        product3.setName("지우개");
        product3.setPrice(152);
        product3.setStock(1234);

        List<Product> products = new ArrayList<>();
        List<Producer> producers = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);

        Producer producer1 = new Producer();
        Producer producer2 = new Producer();
        producer1.setCode("flature");
        producer2.setCode("wikiBooks");
        producers.add(producer1);
        producers.add(producer2);

        productRepository.saveAll(products);
        producerRepository.saveAll(producers);

        System.out.println(producerRepository.findById(1L).get().getProducts());


    }
}
