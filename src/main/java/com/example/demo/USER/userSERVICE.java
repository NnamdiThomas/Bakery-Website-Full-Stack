package com.example.demo.USER;

import com.example.demo.Exception.UserExceptions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class userSERVICE implements userDAO {

    private final userREPO inter;

   // private final PasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<User> FindAllUsers() throws UserExceptions {
        List<User > FindAll = inter.findAll();
        return FindAll;
    }

    @Override
    public User AddNewUser(User add) throws UserExceptions {

//        String Pwd = bCryptPasswordEncoder.encode(add.getPassword());
//        add.setPassword(Pwd);
        User addUSER = inter.save(add);
        return addUSER;
    }

    @Override
    public User UpdateDetails(Long id, User update) throws UserExceptions {

        return null;
    }

    @Override
    public User DeleteUser(Long id) throws UserExceptions {
        return null;
    }
}
