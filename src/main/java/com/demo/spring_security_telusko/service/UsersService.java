package com.demo.spring_security_telusko.service;

import com.demo.spring_security_telusko.entity.Users;
import com.demo.spring_security_telusko.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private IUserRepository userRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public UsersService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users register(Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

}
