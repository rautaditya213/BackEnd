package com.example.Service;
import com.example.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void addUser(String username) {
        // Logic to add a user
        userRepository.saveUser(username);
    }

    public List<String> getAllUsers() {
        // Logic to get all users
       return userRepository.findAllUsers();
    }
}
