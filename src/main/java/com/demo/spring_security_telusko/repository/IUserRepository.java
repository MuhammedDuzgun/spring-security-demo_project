package com.demo.spring_security_telusko.repository;

import com.demo.spring_security_telusko.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
}
