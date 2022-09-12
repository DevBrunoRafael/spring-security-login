package com.devbrunorafael.springsecuritylogin.domain.repository;

import com.devbrunorafael.springsecuritylogin.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
