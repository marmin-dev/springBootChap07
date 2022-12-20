package com.springboot.jpa.data.repository;

import com.springboot.jpa.data.entity.Product;
import com.springboot.jpa.data.entity.Provider;
import com.springboot.jpa.repository.ProductRepository;
import com.springboot.jpa.repository.ProviderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProviderRepositoryTest {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProviderRepository providerRepository;

    @Test
    void relationTest1(){
        //given
        Provider provider = new Provider();
        provider.setName("OO물산");
        providerRepository.save(provider);

        Product product = new Product();
        product.setName("가위");
        product.setPrice(5000);
        product.setStock(500);
        product.setProvider(provider);

        productRepository.save(product);
        //when/then
        System.out.println(
                "product : " + productRepository.findById(1L)
                        .orElseThrow(RuntimeException::new)
        );
        System.out.println(
                "provider : " + providerRepository.findById(1L)
                        .orElseThrow(RuntimeException::new)
        );

    }
}
