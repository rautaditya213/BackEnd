package com.demo.first;


import com.demo.first.app.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }

    @GetMapping("/getuser")
    public User getUser() {
        User user= new User(1, "John Doe", "abc@gmail.com");
        return user;

    }
}
