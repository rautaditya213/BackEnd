package com.demo.first.app;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    private Map<Integer , User> userDb = new HashMap<>();

    @PostMapping
    public String creatUser(@RequestBody User user){
        System.out.println("User created: " + user.getName() + ", Email: " + user.getEmail());
        userDb.put(user.getId(),user);
        System.out.println("User created: " + user.getName() + ", Email: " + user.getEmail());
        return "User created successfully";
    }
}
