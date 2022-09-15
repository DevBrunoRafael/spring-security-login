package com.devbrunorafael.springsecuritylogin.domain.repository;

import com.devbrunorafael.springsecuritylogin.domain.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
