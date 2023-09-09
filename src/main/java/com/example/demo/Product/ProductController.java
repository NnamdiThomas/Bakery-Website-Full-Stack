
package com.example.demo.Product;

import com.example.demo.Exception.ProductException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@RestController
//@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping("/view")
    public ResponseEntity<List<Product>> viewAllProduct() throws ProductException {
        return new ResponseEntity<List<Product>>(service.FindAllProduct(), HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product products) throws ProductException {
        Product product = service.AddProduct(products);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id ,@RequestBody Product products) throws ProductException {
        Product product = service.UpdateProduct(id ,products);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }
/*
    @GetMapping("/view/{categoryId}")
    public ResponseEntity<List<Product>> viewProductByCategoryId(@PathVariable("categoryId") Integer categoryId)
            throws ProductException {
        return new ResponseEntity<List<Product>>(service.ViewByCategory(categoryId), HttpStatus.OK);
    }
*/
    @GetMapping("/search/{name}")
    public ResponseEntity<Product> Add_users(@PathVariable("name") String name) {
    Product New_Users = service.FindProductByName(name);
    return new ResponseEntity<>(New_Users, HttpStatus.OK);
}

    @DeleteMapping("/remove/{productId}")
    public ResponseEntity<Product> removeProductById(@PathVariable("productId") Long productId)
            throws ProductException {
        return new ResponseEntity<Product>(service.DeleteProduct(productId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<Product> removeProductByName(@PathVariable("name") String name)
            throws ProductException {
        return new ResponseEntity<Product>(service.DeleteProductByName(name), HttpStatus.OK);
    }

}
    