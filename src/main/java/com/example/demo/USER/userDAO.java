package com.example.demo.USER;

import com.example.demo.Exception.UserExceptions;

import java.util.List;

public interface userDAO {

    public List<User> FindAllUsers() throws UserExceptions;

    public User AddNewUser(User add) throws UserExceptions;

    public User UpdateDetails(Long id, User update) throws UserExceptions;

    public User DeleteUser (Long id) throws UserExceptions;
}
