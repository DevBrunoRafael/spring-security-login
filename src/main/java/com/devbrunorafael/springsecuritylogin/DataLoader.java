package com.devbrunorafael.springsecuritylogin;

import com.devbrunorafael.springsecuritylogin.domain.model.Role;
import com.devbrunorafael.springsecuritylogin.domain.model.User;
import com.devbrunorafael.springsecuritylogin.domain.repository.RoleRepository;
import com.devbrunorafael.springsecuritylogin.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@AllArgsConstructor
//@Component
public class DataLoader implements CommandLineRunner {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception{
        Role role1 = new Role();
        role1.setRole("ADMIN");
        roleRepository.save(role1);

        Role role2 = new Role();
        role2.setRole("USER");
        roleRepository.save(role2);

        Role adminRole = roleRepository.findByRole("ADMIN");
        Role userRole = roleRepository.findByRole("ADMIN");

        User user = new User();
        user.setEmail("user@user.com");
        user.setUsername("user");
        user.setPassword(passwordEncoder.encode("123"));
        user.setName("bruno");
        user.setLastName("rafael");
        user.setEnable(true);
        user.setRoles(Collections.singletonList(adminRole));
        userRepository.save(user);

        user = new User();
        user.setEmail("adm@adm.com");
        user.setUsername("adm");
        user.setPassword(passwordEncoder.encode("321"));
        user.setName("jonas");
        user.setLastName("gabriel");
        user.setEnable(true);
        user.setRoles(Collections.singletonList(adminRole));
        userRepository.save(user);

    }

}
