package com.example.demo.Product;

import com.example.demo.Exception.ProductException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class ProductService implements ProductDAO {

   private final P_Interface p_interface;

    @Override
    public List<Product> FindAllProduct() throws ProductException {
        List<Product> products = p_interface.findAll();
        if (products.size() >= 0) {
            return products;
        }else {
            throw new ProductException("NO PRODUCT FOUND IN THE STACK");
        }
    }

    @Override
    public Product FindProductByName(String Name) throws ProductException {

            return p_interface.findByName(Name).orElseThrow(() -> new IllegalStateException("ACCOUNT " + Name + " NOT FOUND"));
        }


    public Product FindByEmail(String name){
        return p_interface.findByName(name).orElseThrow(()-> new IllegalStateException(name+" NOT FOUND"));
    }


    @Override
    public Product AddProduct(Product add) throws ProductException {
        boolean NameExist = p_interface.findByName(add.getName()).isPresent();
        if (NameExist) {
            throw new ProductException("NO PRODUCT ADDED TO THE STACK");

        }else {
            return p_interface.save(add);
        }
    }

    @Override
    public Product UpdateProduct(Long id, Product update) throws ProductException {
        Optional<Product> FindProduct = p_interface.findById(update.getId());
        if (FindProduct.isPresent()) {
            return p_interface.save(update);
        }else {
            throw new ProductException("PRODUCT NOT FOUND");
        }
    }
/*
    @Override
    public List<Product> ViewByCategory(Integer ) throws ProductException {
        Optional<Category> category = categoryRepo.findById(Id);
        if (category.isPresent()){
            return category.get().getProductList();
        }else {
            throw new ProductException("NO PRODUCT IN THIS CATEGORY");
        }

    }
*/
    @Override
    public Product DeleteProductByName(String name) throws ProductException {
        Product DeleteItem = p_interface.findByName(name).orElseThrow(()-> new IllegalStateException("PRODUCT DOES NOT EXISTS"));
        p_interface.delete(DeleteItem);
        return null;
    }

    @Override
    public Product DeleteProduct(Long Id) throws ProductException {
        Product DeleteItem = p_interface.findById(Id).orElseThrow(()-> new IllegalStateException("PRODUCT DOES NOT EXISTS"));
        p_interface.delete(DeleteItem);
        return null;
    }
}
