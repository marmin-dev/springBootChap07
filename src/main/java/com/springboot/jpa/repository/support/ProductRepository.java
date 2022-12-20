package com.springboot.jpa.repository.support;

import com.springboot.jpa.data.entity.Product;
import com.springboot.jpa.repository.ProductRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ProductRepositorySupport")
public interface ProductRepository extends JpaRepository<Product,Long> , ProductRepositoryCustom {
}
