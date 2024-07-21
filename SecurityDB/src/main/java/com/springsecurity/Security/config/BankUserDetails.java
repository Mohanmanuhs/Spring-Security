package com.springsecurity.Security.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


//we are giving the username and password from functions instead of giving it from application.properties file

PasswordEncoder passwordEncoder = new ByCryptPasswordEncoder();

@Service
public class BankUserDetails implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String uname ,pass;
        //repo.findByUser(user)
        //size>0
        List<GrantedAuthority> authorities1=new ArrayList<>();

        //we first encode the password entered by user and we have to match it with stored encoded value
        String encodedPass = passwordEncoder.encode("test"); 
        authorities1.add(new SimpleGrantedAuthority("ADMIN"));
        return new User("test",encodedPass,authorities1);
    }
}
