package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    void save(Product product);

    Product findById(Long id);

    void update(Product product);

    void remove(Product product);

    List<Product> searchProductByName(Product product);

}
