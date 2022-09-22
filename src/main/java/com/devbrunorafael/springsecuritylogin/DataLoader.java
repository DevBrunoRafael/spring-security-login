package com.devbrunorafael.springsecuritylogin;

import com.devbrunorafael.springsecuritylogin.model.Role;
import com.devbrunorafael.springsecuritylogin.model.User;
import com.devbrunorafael.springsecuritylogin.repository.RoleRepository;
import com.devbrunorafael.springsecuritylogin.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {

    private RoleRepository roleRepository;
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        Role role1 = new Role();
        role1.setRole("USER");
        roleRepository.save(role1);

        Role role2 = new Role();
        role2.setRole("ADMIN");
        roleRepository.save(role2);

        Role roleUser = roleRepository.findByRole("USER").get();
        Role roleAdmin = roleRepository.findByRole("ADMIN").get();


        User user = new User();
        user.setUsername("user");
        user.setPassword("user");
        user.setRoles(Collections.singletonList(roleUser));
        userRepository.save(user);


        user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        user.setRoles(Collections.singletonList(roleAdmin));
        userRepository.save(user);

    }
}
