package com.codegym.repository;

import com.codegym.model.Product;

import java.util.List;

public interface IProductRepository {

    List<Product> findAll(String name);

    void save(Product product);

    Product findById(Long id);

    void update(Product product);

    void remove(Product product);

}
