package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Load user from database
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username : " + username));

        // Convert roles to GrantedAuthority
        Collection<GrantedAuthority> authorities = getAuthorities(user.getRole());

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),  // Use phoneNo as the username
                user.getPassword(),
                authorities
        );
    }

    private Collection<GrantedAuthority> getAuthorities(String role) {
        // Convert the single role string to a GrantedAuthority
        return Set.of(new SimpleGrantedAuthority("ROLE_" + role));
    }
}