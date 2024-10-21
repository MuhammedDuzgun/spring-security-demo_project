package com.demo.spring_security_telusko.service;

import com.demo.spring_security_telusko.entity.Users;
import com.demo.spring_security_telusko.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Users register(Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public String verify(Users user) {
        Authentication authenticaiton = authenticationManager.authenticate
                (new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if (authenticaiton.isAuthenticated()) {
            return jwtService.generateToken(user.getUsername());
        }

        return "Authentication Failed";
    }
}
