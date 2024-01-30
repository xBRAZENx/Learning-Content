package com.GlobalExceptionHandling.test.Service;

import org.springframework.stereotype.Service;

import com.GlobalExceptionHandling.test.UserNotFoundException;
import com.GlobalExceptionHandling.test.Entity.User;
import com.GlobalExceptionHandling.test.Repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    private static List<User> userList = new ArrayList<>();
    {
    	userList.add(new User(1,"Atharva"));
    	userList.add(new User(2,"Aman"));
    	userList.add(new User(3,"Nishant"));
    	userList.add(new User(4,"Vinit"));
    }
    
    public List<User> getAllUsers(){
    	//return userRepository.findAll();
    	return userList;
    }
    
    public User findUserByUsername(String username) {
       // User user = userRepository.findByUsername(username);
        return userList.stream().filter(u -> u.getUsername().equals(username)).findFirst().get();
    }
    
    public User findUserById(int id) {
    	//return userRepository.findById(id).get();
    	return userList.stream().filter(u -> u.getId()==id).findFirst().get();
    }
    
    public User saveUser(User user) {
    	//return userRepository.save(user);
    	userList.add(user);
    	return user;
    }
    
    public User updateUser(User user) {
    	//return userRepository.save(user);
    	userList.add(user);
    	return user;
    }
    
    public void deleteUser(User user) {
    	System.out.println("Deleting User" + user);
    	//userRepository.delete(user);
    	userList.remove(user);
    }
    
    public void deleteById(int id) {
    	System.out.println("Deleting User" + userList.stream().filter(u -> u.getId()==id).findFirst().get());
    	//userRepository.deleteById(id);
    	userList.remove(userList.stream().filter(u -> u.getId()==id).findFirst().get());
    }
}
 