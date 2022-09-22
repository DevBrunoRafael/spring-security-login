package com.devbrunorafael.springsecuritylogin.service;

import com.devbrunorafael.springsecuritylogin.model.User;
import com.devbrunorafael.springsecuritylogin.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class SSUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public SSUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var userModel = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username.concat(" not found!")));

        return new org.springframework.security.core.userdetails.User(
                userModel.getUsername(), userModel.getPassword(), this.getAuthorities(userModel)
        );
    }

    private Set<GrantedAuthority> getAuthorities(User user){
        Set<GrantedAuthority> authorities = new HashSet<>();

        user.getRoles().forEach(role -> {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRole());
            authorities.add(grantedAuthority);
        });

        return authorities;
    }
}
