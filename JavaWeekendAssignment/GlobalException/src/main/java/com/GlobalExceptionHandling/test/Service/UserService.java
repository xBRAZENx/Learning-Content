package com.GlobalExceptionHandling.test.Service;

import org.springframework.stereotype.Service;

import com.GlobalExceptionHandling.test.UserNotFoundException;
import com.GlobalExceptionHandling.test.Entity.User;
import com.GlobalExceptionHandling.test.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public User findUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UserNotFoundException("User not found with username: " + username);
        }
        return user;
    }
}
 