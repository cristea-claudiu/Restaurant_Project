package com.mrv.repository;

import com.mrv.entity.concrete.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Admin findByUsernameEquals(String username);

    boolean existsByUsername(String username);
}
