package com.example.demo.Exception;

public class AdminNotFoundException extends RuntimeException {
    public AdminNotFoundException (String message) {
        super(message);
    }
}
