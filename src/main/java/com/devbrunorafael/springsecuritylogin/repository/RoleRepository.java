package com.devbrunorafael.springsecuritylogin.repository;

import com.devbrunorafael.springsecuritylogin.model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Optional<Role> findByRole(String role);
}
