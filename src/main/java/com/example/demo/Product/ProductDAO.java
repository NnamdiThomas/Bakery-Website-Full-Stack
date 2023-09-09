package com.example.demo.Product;

import com.example.demo.Exception.ProductException;

import java.util.List;
import java.util.Optional;

public interface ProductDAO {

    public List<Product> FindAllProduct() throws ProductException;

    public Product FindProductByName(String Name) throws ProductException;

    public Product AddProduct(Product add) throws ProductException;

    public Product UpdateProduct(Long id, Product update) throws ProductException;

   // public List<Product> ViewByCategory(Integer Id) throws ProductException;

    public Product DeleteProductByName(String name) throws ProductException;

    Product DeleteProduct(Long Id) throws ProductException;
}
