package com.example.demo.Cart;

import com.example.demo.Exception.CartException;

import java.util.List;

public interface CartDAO {

    public Cart addCart(Cart item) throws CartException;

    public List<Cart> FindAll() throws CartException;

    public Cart DeleteCart(Long id) throws CartException;


}
