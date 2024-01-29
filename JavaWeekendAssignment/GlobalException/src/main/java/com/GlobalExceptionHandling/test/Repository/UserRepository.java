package com.GlobalExceptionHandling.test.Repository;

import com.GlobalExceptionHandling.test.UserNotFoundException;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GlobalExceptionHandling.test.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
