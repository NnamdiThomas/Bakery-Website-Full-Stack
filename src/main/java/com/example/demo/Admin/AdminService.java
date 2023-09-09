package com.example.demo.Admin;

import com.example.demo.Exception.UserExceptions;
import com.example.demo.USER.User;
import com.example.demo.USER.userREPO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {//implements UserDetailsService {


    private final adminRepo repo;

    public Admin MainDirector (Admin add)  {

        Admin newadmin = new Admin();
        newadmin.setName("Osuoha Nnamdi Thomas ");
        newadmin.setPassword("ratrat123");
        newadmin.setEmail("nnamdithomas@gmail.com");

        return repo.save(add);
    }



    /*
    @Autowired
    private userREPO repo;

//    private final SecurityConfig config;



    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<User> user = repo.findByEmail(username);

        return user.map(Admin::new)
                .orElseThrow(() -> new IllegalStateException("user not found " + username));
    }

    public Customer AddStaff (Customer add){
        String encoded = config.passwordEncoder().encode(add.getPassword());
        add.setPassword(encoded);
        return customer_repo.save(add);
    }
*/

}
