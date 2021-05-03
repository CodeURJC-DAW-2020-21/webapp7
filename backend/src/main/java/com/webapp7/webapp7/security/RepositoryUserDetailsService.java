package com.webapp7.webapp7.security;

import com.webapp7.webapp7.Service.UserService;
import com.webapp7.webapp7.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RepositoryUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userService.findByName(name);

        List<GrantedAuthority> roles = new ArrayList<>();
        String rol= user.getRol();
        roles.add(new SimpleGrantedAuthority("ROLE_" + rol));

        return new org.springframework.security.core.userdetails.User(user.getName(),
                user.getPassword(), roles);
    }
}