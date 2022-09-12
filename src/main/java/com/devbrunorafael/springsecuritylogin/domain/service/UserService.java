package com.devbrunorafael.springsecuritylogin.domain.service;

import com.devbrunorafael.springsecuritylogin.domain.model.User;
import com.devbrunorafael.springsecuritylogin.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public User findUser(String username){
        return this.userRepository.findByUsername(username);
    }
}
