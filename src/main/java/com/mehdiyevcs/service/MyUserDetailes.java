package com.mehdiyevcs.service;

import com.mehdiyevcs.model.User;
import com.mehdiyevcs.repository.UserRepository;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailes implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        User user = null;
        user = userRepo.findByUsername(username);

        if (user.equals(null))
            throw new UsernameNotFoundException("Username Not Found!");

        UserBuilder builder = org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder();

        return builder
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole()).build();
    }
}
