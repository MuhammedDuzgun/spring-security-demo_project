package com.demo.spring_security_telusko.security;

import com.demo.spring_security_telusko.entity.Users;
import com.demo.spring_security_telusko.model.UserPrincipal;
import com.demo.spring_security_telusko.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = userRepository.findByUsername(username);
        if(user == null) {
            System.out.println("user not found");
            throw new UsernameNotFoundException(username + " not found");
        }

        return new UserPrincipal(user);
    }

}
