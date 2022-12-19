package com.springboot.jpa.data.repository;

import com.springboot.jpa.data.entity.Product;
import com.springboot.jpa.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@SpringBootTest
public class ProductRepositoryTestSort {
    @Autowired
    ProductRepository productRepository;

    @Test
    void sortingAndPagingTest(){
        Product product1 = new Product();
        product1.setName("펜");
        product1.setPrice(1000);
        product1.setStock(100);


        Product product2 = new Product();
        product2.setName("펜");
        product2.setPrice(5000);
        product2.setStock(300);


        Product product3 = new Product();
        product3.setName("펜");
        product3.setPrice(500);
        product3.setStock(50);
        product3.setCreatedAt(LocalDateTime.now());
        product3.setCreatedAt(LocalDateTime.now());

        Product savedProduct1 = productRepository.save(product1);
        Product savedProduct2 = productRepository.save(product2);
        Product savedProduct3 = productRepository.save(product3);

        productRepository.findByName("펜", Sort.by(Sort.Order.asc("price")));
        productRepository.findByName("펜",Sort.by(Sort.Order.asc("price"),
                Sort.Order.desc("stock")));
        productRepository.findByName("펜",getSort());
        Page<Product> prpage = productRepository.findByName("펜", PageRequest.of(0,2));
        System.out.println(productRepository.findByName("펜", PageRequest.of(0,2))); // 몇번째 페이지인지?
        System.out.println(prpage.getContent());//배열형태로 값이 출력된다
        System.out.println(productRepository.findByName("펜"));
        String findByNameParam = productRepository.findByNameParam2("펜").stream().map(n->String.valueOf(n))
                        .collect(Collectors.joining());
        System.out.println(findByNameParam);
    }
    private Sort getSort(){
        return Sort.by(
                Sort.Order.asc("price")
                , Sort.Order.desc("stock")
        );
    }
}
