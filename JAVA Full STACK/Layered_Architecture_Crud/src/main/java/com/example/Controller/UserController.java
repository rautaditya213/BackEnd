package com.example.Controller;


import com.example.Service.UserService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    public void createUser(String username) {
        // Logic to create a user
        userService.addUser(username);
        System.out.println("User created: " + username);
    }

    public void listUsers() {
        // Logic to list users
        List<String> users = userService.getAllUsers();
        System.out.println("Listing users: " + users);
    }
}
