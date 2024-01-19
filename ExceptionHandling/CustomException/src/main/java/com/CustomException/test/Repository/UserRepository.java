package com.CustomException.test.Repository;

import com.CustomException.test.UserNotFoundException;
import com.CustomException.test.Entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
