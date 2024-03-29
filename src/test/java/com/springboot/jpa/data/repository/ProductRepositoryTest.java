package com.springboot.jpa.data.repository;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.springboot.jpa.data.entity.Product;
import com.springboot.jpa.data.entity.QProduct;
import com.springboot.jpa.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@DataJpaTest
public class ProductRepositoryTest {
    @Autowired
    ProductRepository productRepository;
    @PersistenceContext
    EntityManager entityManager;

    @Test
    void queryDslTest(){
        JPAQuery<Product> query = new JPAQuery(entityManager);
        //QueryDSL을 사용하기 위해서 JPAQuery객체를 사용한다 빌더형식으로 쿼리 작성
        QProduct qProduct = QProduct.product;

        List<Product> productList = query
                .from(qProduct)
                .where(qProduct.name.eq("펜"))
                .orderBy(qProduct.price.asc())
                .fetch();

        for(Product product : productList){
            System.out.println("-------------");
            System.out.println();
            System.out.println("Product Number : " + product.getNumber());
            System.out.println("Product Name : " + product.getName());
            System.out.println("Product Price : " + product.getPrice());
            System.out.println("Product Stock : " + product.getStock());
            System.out.println();
            System.out.println("---------------");
        }
    }
    @Test
    void queryDslTest2(){
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        QProduct qProduct = QProduct.product;

        List<Product> productList = jpaQueryFactory.selectFrom(qProduct)
                .where(qProduct.name.eq("펜"))
                .orderBy(qProduct.price.asc())
                .fetch();

        for(Product product : productList){
            System.out.println("-------------");
            System.out.println();
            System.out.println("Product Number : " + product.getNumber());
            System.out.println("Product Name : " + product.getName());
            System.out.println("Product Price : " + product.getPrice());
            System.out.println("Product Stock : " + product.getStock());
            System.out.println();
            System.out.println("---------------");
        }
    }
    @Test
    void queryDslTest3(){
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        QProduct qProduct = QProduct.product;

        List<String> productList = jpaQueryFactory
                .select(qProduct.name)
                .from(qProduct)
                .where(qProduct.name.eq("펜"))
                .orderBy(qProduct.price.asc())
                .fetch();

        for (String product : productList){
            System.out.println("-----------");
            System.out.println("ProductName : " + product);
            System.out.println("------------");
        }
        List<Tuple> tupleList = jpaQueryFactory.select(qProduct.name,qProduct.price)
                .from(qProduct)
                .where(qProduct.name.eq("펜"))
                .orderBy(qProduct.price.asc())
                .fetch();
        for(Tuple tuple : tupleList){
            System.out.println("-----------");
            System.out.println("ProductName : " + qProduct.name);
            System.out.println("ProductPrice : " + qProduct.price);
            System.out.println("------------");
        }
    }
//    @Autowired
//    JPAQueryFactory jpaQueryFactory;

    @Test
    void queryDslTest4(){
//        QProduct qProduct = QProduct.product;
//
//        List<String> productList = jpaQueryFactory
//                .select(qProduct.name)
//                .from(qProduct)
//                .where(qProduct.name.eq("펜"))
//                .orderBy(qProduct.price.asc())
//                .fetch();
//        for(String product : productList){
//            System.out.println("---------");
//            System.out.println("ProductName : " + product);
//            System.out.println("---------");
//        }
    }


}
