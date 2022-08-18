package com.codegym.repository.impl;

import com.codegym.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class IProductRepository implements com.codegym.repository.IProductRepository {

    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Iphone 13", "15000000", "Chính Hãng", "Apple"));
        products.put(2, new Product(2, "Iphone 11 Pro", "12000000", "Chính Hãng", "Apple"));
        products.put(3, new Product(3, "Iphone 12 Pro Max", "20000000", "Chính Hãng", "Apple"));
        products.put(4, new Product(4, "Samsung Note 22", "18000000", "Chính Hãng", "Samsung"));
        products.put(5, new Product(5, "Xiaomi Mi Mix 3", "21000000", "Chính Hãng", "Xiaomi"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> searchProductByName(String name) {
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().toLowerCase().contains(name.toLowerCase())) {
                productList.add(products.get(i));
            }
        }
        return productList;
    }
}
