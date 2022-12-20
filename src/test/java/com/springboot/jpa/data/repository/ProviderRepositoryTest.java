package com.springboot.jpa.data.repository;

import com.springboot.jpa.data.entity.Category;
import com.springboot.jpa.data.entity.Product;
import com.springboot.jpa.data.entity.Provider;
import com.springboot.jpa.repository.CategoryRepository;
import com.springboot.jpa.repository.ProductRepository;
import com.springboot.jpa.repository.ProviderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProviderRepositoryTest {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProviderRepository providerRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    void relationTest1(){
        //given
        Provider provider = new Provider();
        provider.setName("OO물산");
        providerRepository.save(provider);

        Product product1 = new Product();
        product1.setName("가위");
        product1.setPrice(5000);
        product1.setStock(500);
        product1.setProvider(provider);

        Product product2 = new Product();
        product2.setName("가방");
        product2.setPrice(4000);
        product2.setStock(300);
        product2.setProvider(provider);

        productRepository.save(product1);
        productRepository.save(product2);

        List<Product> products = providerRepository.findById(provider.getId()).get()
                .getProductList();
        for(Product product : products){
            System.out.println(product);
        }
    }
    @Test
    void relationShipTest2(){
        //테스트 데이터 생성
        Product product = new Product();
        product.setName("펜");
        product.setPrice(2000);
        product.setStock(100);

        productRepository.save(product);

        Category category = new Category();
        category.setCode("s1");
        category.setName("도서");
        category.getProducts().add(product);

        categoryRepository.save(category);

        //테스트코드
        List<Product> products = categoryRepository.findById(1L).get().getProducts();

        for(Product produc : products ){
            System.out.println(produc);
        }
    }
}
