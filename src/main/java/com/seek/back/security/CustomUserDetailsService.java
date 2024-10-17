package com.seek.back.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Definir un usuario en memoria
        if ("admin".equals(username)) {
            UserBuilder builder = User.withUsername("admin");
            builder.password(passwordEncoder.encode("password"));
            builder.roles("ADMIN");
            return builder.build();
        } else if ("user".equals(username)) {
            UserBuilder builder = User.withUsername("user");
            builder.password(passwordEncoder.encode("password"));
            builder.roles("USER");
            return builder.build();
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }
    }
}

