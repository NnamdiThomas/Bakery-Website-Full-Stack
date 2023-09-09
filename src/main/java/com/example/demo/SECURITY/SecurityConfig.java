package com.example.demo.SECURITY;

import com.example.demo.Admin.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//@RequiredArgsConstructor
public class SecurityConfig {
  /*  @Autowired
    private final JwtAuthFilter authFilter;

    @Bean
    //authentication
    public UserDetailsService userDetailsService() {
       /* UserDetails admin = User.withUsername("Basant")
                .password(passwordEncoder().encode("Pwd1"))
                .roles("ADMIN")
                .build();
        UserDetails user = User.withUsername("John")
                .password(passwordEncoder().encode("Pwd2"))
                .roles("USER","ADMIN","HR")
                .build();
        return new InMemoryUserDetailsManager(admin, user);
        return new AdminService();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/login","/add","/authenticate")
                .permitAll()
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/all")
                .authenticated()
                .and()
                .formLogin()
                .and()
                .build();
    }
*/
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
/*
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
*/
}
