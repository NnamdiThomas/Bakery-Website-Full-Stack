package com.example.demo.Controller;

import com.example.demo.Admin.Admin;
import com.example.demo.Admin.AdminService;
import com.example.demo.Cart.Cart;
import com.example.demo.Cart.CartService;
import com.example.demo.Exception.CartException;
import com.example.demo.Exception.ProductException;
import com.example.demo.Product.Product;
import com.example.demo.Product.ProductService;
import com.example.demo.USER.User;
import com.example.demo.USER.userSERVICE;
import com.example.demo.login.login;
import com.example.demo.login.loginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequiredArgsConstructor
public class ControllerClass {

//    private final JwtService jwtService;
//    private final AuthenticationManager authenticationManager;
    private final AdminService adService;
    private final CartService Cservice;
    private final ProductService service1;
    private final userSERVICE service;
    private final loginService logins;

    @GetMapping("/view")
    public ResponseEntity<List<Product>> viewAllProduct() throws ProductException {
        return new ResponseEntity<List<Product>>(service1.FindAllProduct(), HttpStatus.OK);
    }


    @PostMapping("/product/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product products) throws ProductException {
        Product product = service1.AddProduct(products);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @PostMapping("/cart/add")
    public ResponseEntity<Cart> addCart(@RequestBody Cart cart) throws CartException {
        Cart newCart = Cservice.addCart(cart);
        return new ResponseEntity<Cart>(newCart , HttpStatus.OK);
    }
    @PostMapping("/admin/add")
    public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) throws CartException {
        Admin admin1 = adService.MainDirector(admin);
        return new ResponseEntity<Admin>(admin1 , HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> logins(@RequestBody login Logins) throws CartException {
        String loginDetails = logins.userLogins(Logins);
        return ResponseEntity.ok(loginDetails);
    }

    @GetMapping("/all")
    public List <User> get_user(){
        return service.FindAllUsers();
    }
//
//    @GetMapping("/id/{id}")
//    public ResponseEntity <User> Find_users(@PathVariable("id") long id){
//        User find = service.FindbyId(id);
//        return new ResponseEntity<>(find , HttpStatus.OK);
//    }


    @PostMapping("/add")
    public ResponseEntity<User> Add_users(@RequestBody User users){
        User New_Users = service.AddNewUser(users);
        return new ResponseEntity<>(New_Users, HttpStatus.CREATED);
    }
//
//    @PutMapping("/update")
//    public ResponseEntity <User> update_users(@RequestBody User users){
//        User Updated_user = service.update_user(users);
//        return new ResponseEntity<>(Updated_user, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public  ResponseEntity <User>  update_users(@PathVariable("id") long id){
//        service.delete_user(id);
//        return null;
//    }
/*
    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getEmail());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }

    }
*/
}