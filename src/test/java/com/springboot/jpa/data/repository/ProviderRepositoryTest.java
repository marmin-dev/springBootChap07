package com.springboot.jpa.data.repository;

import com.springboot.jpa.data.entity.Category;
import com.springboot.jpa.data.entity.Product;
import com.springboot.jpa.data.entity.Provider;
import com.springboot.jpa.repository.CategoryRepository;
import com.springboot.jpa.repository.ProductRepository;
import com.springboot.jpa.repository.ProviderRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

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
    @Test
    void cascadeTest(){
        Provider provider = savedProvider("새로운 공급 업체");

        Product product1 = savedProduct("상품1",1000,1000);
        Product product2 = savedProduct("상품2",500,1500);
        Product product3 = savedProduct("상품3",750,500);

        //연관관계 설정
        product1.setProvider(provider);
        product2.setProvider(provider);
        product3.setProvider(provider);

        provider.getProductList().addAll(Lists.newArrayList(product1,product2,product3));

        providerRepository.save(provider);
    }
    private Provider savedProvider(String name){
        Provider provider = new Provider();
        provider.setName(name);
        return provider;
    }
    public Product savedProduct(String name, int price, int stock){
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setStock(stock);
        return product;
    }
    @Test
    @Transactional
    void orphanRemovalTest(){
        Provider provider = savedProvider("새로운 공급업체");
        Product product1 = savedProduct("상품1",1000,1000);
        Product product2 = savedProduct("상품2",500,1500);
        Product product3 = savedProduct("상품3",750,500);

        product1.setProvider(provider);
        product2.setProvider(provider);
        product3.setProvider(provider);

        provider.getProductList().addAll(Lists.newArrayList(product1,product2,product3));
        providerRepository.saveAndFlush(provider);

        providerRepository.findAll().forEach(System.out::println);
        productRepository.findAll().forEach(System.out::println);

        Provider foundProvider = providerRepository.findById(1L).get();
        foundProvider.getProductList().remove(0);

        providerRepository.findAll().forEach(System.out::println);
        productRepository.findAll().forEach((System.out::println));
    }
}
