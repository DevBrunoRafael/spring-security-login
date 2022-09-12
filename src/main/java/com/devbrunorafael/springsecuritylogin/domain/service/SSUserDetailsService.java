package com.devbrunorafael.springsecuritylogin.domain.service;

import com.devbrunorafael.springsecuritylogin.domain.model.Role;
import com.devbrunorafael.springsecuritylogin.domain.model.User;
import com.devbrunorafael.springsecuritylogin.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
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

    // alterar esse construtor
    public SSUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // refatorar o método abaixo
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{
            User user = this.userRepository.findByUsername(username);
            if(user == null){
                return null;
            }
            return new org.springframework.security.core.userdetails.User(
              user.getUsername(), user.getPassword(), this.getAuthorities(user)
            );
        } catch (Exception e){
            throw new UsernameNotFoundException("User not found!");
        }
    }

    // refatorar o método abaixo
    private Set<GrantedAuthority> getAuthorities(User user){
        Set<GrantedAuthority> authorities = new HashSet<>();
        for (Role roles : user.getRoles()){
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(roles.getRole());
            authorities.add(grantedAuthority);
        }
        return authorities;
    }
}
