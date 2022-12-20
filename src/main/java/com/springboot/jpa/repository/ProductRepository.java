package com.springboot.jpa.repository;

import com.springboot.jpa.data.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.Id;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByName(String name, Sort sort);
    Page<Product> findByName(String name, Pageable pageable);

    @Query("SELECT p FROM Product AS p WHERE p.name=?1")
    List<Product> findByName(String name);

    @Query("SELECT p FROM Product p WHERE p.name = :name")//파라미터 바인딩
    List<Product> findByNameParam(@Param("name") String name);

    @Query("SELECT p.name, p.price, p.stock FROM Product p WHERE p.name = :name")
    List<Object[]> findByNameParam2(@Param("name") String name);

}
