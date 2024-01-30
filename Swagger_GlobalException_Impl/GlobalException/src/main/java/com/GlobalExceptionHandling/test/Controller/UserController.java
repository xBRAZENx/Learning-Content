package com.GlobalExceptionHandling.test.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GlobalExceptionHandling.test.UserNotFoundException;
import com.GlobalExceptionHandling.test.Entity.User;
import com.GlobalExceptionHandling.test.Service.UserService;

import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    
    
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
		List<User> list = userService.getAllUsers();
		if(list.size()<=0)return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    	return ResponseEntity.of(Optional.of(list));
    }
    @GetMapping("/{username}")
    public User getUserByUsername (@PathVariable String username) {
    	User user = null;
             user = userService.findUserByUsername(username);
            if (user==null)throw new UserNotFoundException("User is not Present");
            return user;
        
    }
    @GetMapping("/id")
    public User getUserById(@RequestParam int id) {
        
            User user = userService.findUserById(id);
            return user;
    }
    
    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user){
    	userService.saveUser(user);
    	return ResponseEntity.status(HttpStatus.CREATED).build();
		}
    
    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user,@PathVariable int id){
    	user.setId(id);
    	return userService.saveUser(user);
		}
    
    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable int id) {
    	userService.deleteById(id);
    	return "Deleted User with ID : "+id;
    }
    
    @DeleteMapping
    public String deleteUser(@RequestBody User user) {
    	userService.deleteUser(user);
    	return "Deleted User : "+user;
    }
}
