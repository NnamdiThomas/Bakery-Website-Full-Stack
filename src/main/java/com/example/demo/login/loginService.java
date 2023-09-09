package com.example.demo.login;


import com.example.demo.Admin.Admin;
import com.example.demo.Admin.adminRepo;
import com.example.demo.Exception.UserExceptions;
import com.example.demo.USER.User;
import com.example.demo.USER.userREPO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class loginService implements loginDAO{

    private final userREPO repo;

    private final adminRepo adRepo;

    //private final PasswordEncoder encoder;



    @Override
    public String userLogins(login UserLOgin) throws RuntimeException {
        String msg ="";

        Admin adminEmail = adRepo.findByEmail(UserLOgin.getEmail()).orElseThrow(()-> new RuntimeException(""));
        Admin adminPwd = adRepo.findByPassword(UserLOgin.getPassword()).orElseThrow(()-> new UserExceptions(""));


        User pwds = repo.findByPassword(UserLOgin.getPassword()).orElseThrow(() -> new RuntimeException(""));
        User cred = repo.findByEmail(UserLOgin.getEmail()).orElseThrow(()-> new RuntimeException(""));

        if (cred != null && pwds != null || adminEmail != null && adminPwd != null){
            String pwd = UserLOgin.getPassword();

             Optional<User> user = repo.findByEmailAndPassword(UserLOgin.getEmail(), UserLOgin.getPassword());//EncodedPWD);
            Optional<Admin> admin = adRepo.findByEmailAndPassword(UserLOgin.getEmail(), UserLOgin.getPassword());
                if (user.isPresent()){
                    return "user";
            } else if (admin.isPresent()) {
                return "Admin";
            }

        }else {
            return null;
        }
        return null;
    }
}
