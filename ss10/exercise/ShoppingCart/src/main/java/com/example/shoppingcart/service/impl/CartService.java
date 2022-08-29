package com.example.shoppingcart.service.impl;

import com.example.shoppingcart.model.Cart;
import com.example.shoppingcart.model.Product;
import com.example.shoppingcart.repository.ICartRepository;
import com.example.shoppingcart.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService implements ICartService {

    @Autowired
    private ICartRepository iCartRepository;

    @Override
    public void addProduct(Product product, Cart cart) {
        this.iCartRepository.addProduct(product, cart);
    }

    @Override
    public void subProduct(Product product, Cart cart) {
        if (this.iCartRepository.countItemQuantity(cart) == 0) {
            return;
        }
        this.iCartRepository.subProduct(product, cart);
    }

    @Override
    public Integer countProductQuantity(Cart cart) {
        return this.iCartRepository.countProductQuantity(cart);
    }

    @Override
    public Integer countItemQuantity(Cart cart) {
        return this.iCartRepository.countItemQuantity(cart);
    }

    @Override
    public Float countTotalPayment(Cart cart) {
        return this.iCartRepository.countTotalPayment(cart);
    }

}
