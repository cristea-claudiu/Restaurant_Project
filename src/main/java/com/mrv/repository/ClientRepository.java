package com.mrv.repository;

import com.mrv.entity.concrete.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

public interface ClientRepository extends JpaRepository<Client,Integer> {
    Client findByUsernameEquals(String username);
}
