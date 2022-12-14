package com.example.shoppingcart.repository.impl;

import com.example.shoppingcart.model.Cart;
import com.example.shoppingcart.model.Product;
import com.example.shoppingcart.repository.ICartRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class CartRepository implements ICartRepository {

    private boolean checkItemInCart(Product product, Cart cart) {
        Map<Product, Integer> products = cart.getProducts();
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return true;
            }
        }
        return false;
    }

    private Map.Entry<Product, Integer> selectItemInCart(Product product, Cart cart) {
        Map<Product, Integer> products = cart.getProducts();
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return entry;
            }
        }
        return null;
    }

    @Override
    public void addProduct(Product product, Cart cart) {
        Map<Product, Integer> products = cart.getProducts();
        if (!checkItemInCart(product, cart)) {
            products.put(product, 1);
            cart.setProducts(products);
        } else {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product, cart);
            Integer newQuantity = itemEntry.getValue() + 1;
            products.replace(itemEntry.getKey(), newQuantity);
            cart.setProducts(products);
        }
    }

    @Override
    public void subProduct(Product product, Cart cart) {
        Map<Product, Integer> products = cart.getProducts();
        if (!checkItemInCart(product, cart)) {
            return;
        } else {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product, cart);
            Integer newQuantity = itemEntry.getValue() - 1;
            products.replace(itemEntry.getKey(), newQuantity);
            cart.setProducts(products);
        }
    }

    @Override
    public Integer countProductQuantity(Cart cart) {
        Map<Product, Integer> products = cart.getProducts();
        Integer productQuantity = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    @Override
    public Integer countItemQuantity(Cart cart) {
        return cart.getProducts().size();
    }

    @Override
    public Float countTotalPayment(Cart cart) {
        Map<Product, Integer> products = cart.getProducts();
        float payment = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }

}
