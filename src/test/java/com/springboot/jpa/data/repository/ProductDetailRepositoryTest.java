package com.springboot.jpa.data.repository;

import com.springboot.jpa.data.entity.Product;
import com.springboot.jpa.data.entity.ProductDetail;
import com.springboot.jpa.repository.ProductDetailRepository;
import com.springboot.jpa.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductDetailRepositoryTest {

    @Autowired
    ProductDetailRepository productDetailRepository;

    @Autowired
    ProductRepository productRepository;

    @Test
    public void saveAndReadTest1(){
        Product product = new Product();
        product.setName("스프링부트JPA");
        product.setPrice(5000);
        product.setStock(500);
        productRepository.save(product);

        ProductDetail productDetail = new ProductDetail();
        productDetail.setProduct(product);
        productDetail.setDescription("정말 좋은 책이예요!");

        productDetailRepository.save(productDetail);
        //생성한 데이터 조회
        System.out.println("savedProduct : " + productDetailRepository.findById(
                productDetail.getId()).get().getProduct());
        System.out.println("savedProductDetail : " + productDetailRepository.findById(productDetail.getId())
                .get());
    }

}
