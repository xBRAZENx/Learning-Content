package com.CustomException.test.Service;

import org.springframework.stereotype.Service;

import com.CustomException.test.UserNotFoundException;
import com.CustomException.test.Entity.User;
import com.CustomException.test.Repository.UserRepository;

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
