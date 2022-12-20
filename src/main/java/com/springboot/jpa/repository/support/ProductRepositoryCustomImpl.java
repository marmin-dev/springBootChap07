package com.springboot.jpa.repository.support;

import com.springboot.jpa.data.entity.Product;
import com.springboot.jpa.data.entity.QProduct;
import com.springboot.jpa.repository.ProductRepositoryCustom;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class ProductRepositoryCustomImpl extends QuerydslRepositorySupport implements
        ProductRepositoryCustom {

    public ProductRepositoryCustomImpl(){
        super(Product.class);
    }

    @Override
    public List<Product> findByName(String name) {
        QProduct product = QProduct.product;

        List<Product> productList = from(product)
                .where(product.name.eq(name))
                .orderBy(product.price.asc())
                .fetch();
        return productList;
    }
}
