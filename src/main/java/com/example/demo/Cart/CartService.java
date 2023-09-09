package com.example.demo.Cart;

import com.example.demo.Exception.CartException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CartService implements CartDAO{

    private final CartRepo repo;

    @Override
    public Cart addCart(Cart item) throws CartException {
        Cart addProduct = repo.save(item);
        return addProduct;
    }

    @Override
    public List<Cart> FindAll() throws CartException {
        List<Cart> findAll = repo.findAll();
        return findAll;
    }

    @Override
    public Cart DeleteCart(Long id) throws CartException {

        Cart deleteCart = repo.deleteCartById(id).orElseThrow(()-> new CartException("No Cart Found"));

        return deleteCart;
    }
}
