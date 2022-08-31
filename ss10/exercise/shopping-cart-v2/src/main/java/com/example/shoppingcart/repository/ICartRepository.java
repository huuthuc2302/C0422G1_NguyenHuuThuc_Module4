package com.example.shoppingcart.repository;

import com.example.shoppingcart.model.Cart;
import com.example.shoppingcart.model.Product;

public interface ICartRepository {

    void addProduct(Product product, Cart cart);

    void subProduct(Product product, Cart cart);

    Integer countProductQuantity(Cart cart);

    Integer countItemQuantity(Cart cart);

    Float countTotalPayment(Cart cart);

}
