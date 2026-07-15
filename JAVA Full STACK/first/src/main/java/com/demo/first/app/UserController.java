package com.demo.first.app;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    private Map<Integer , User> userDb = new HashMap<>();

    @PostMapping
    public ResponseEntity<User> creatUser(@RequestBody User user){
        userDb.putIfAbsent(user.getId(),user);
        System.out.println("User created: " + user.getName() + ", Email: " + user.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user){
        if(userDb.containsKey(user.getId()))
        {
            userDb.put(user.getId(),user);
            System.out.println("User updated: " + user.getName() + ", Email: " + user.getEmail());
        }
        else{
            System.out.println("User with ID " + user.getId() + " not found.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @DeleteMapping
    public ResponseEntity<User> deleteUser(@RequestBody User user){
        if(userDb.containsKey(user.getId())){
            userDb.remove(user.getId());
            System.out.println("User deleted: "+ user.getName() + ", Email: " + user.getEmail());
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }
        else{
            System.out.println("User with id" + user.getId()+ "not found.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable int id){
        if(userDb.containsKey(id)){
            User user = userDb.get(id);
            userDb.remove(id);
            System.out.println("User deleted: "+ user.getName() + ", Email: " + user.getEmail());
            return "User deleted successfully";
        }
        else{
            System.out.println("User with id" + id + "not found.");
            return "User with id" + id + "not found.";
        }
    }

    @GetMapping
    public ResponseEntity<Map<Integer, User> >getAllUsers(){
        return ResponseEntity.status(HttpStatus.FOUND).body(userDb);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Integer id)
    {
        User user = userDb.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
