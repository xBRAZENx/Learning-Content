package com.GlobalExceptionHandling.test.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GlobalExceptionHandling.test.UserNotFoundException;
import com.GlobalExceptionHandling.test.Entity.User;
import com.GlobalExceptionHandling.test.Service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{username}")
    public String getUserByUsername(@PathVariable String username) {
        
            User user = userService.findUserByUsername(username);
            return "User Found";
        
    }
}
