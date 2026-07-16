package com.demo.first.app;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    // In-memory database to store users
    private Map<Integer , User> userDb = new HashMap<>();


    // Create user
    @PostMapping
    public ResponseEntity<User> creatUser(@RequestBody User user){
        userDb.putIfAbsent(user.getId(),user);
        System.out.println("User created: " + user.getName() + ", Email: " + user.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }


    // Update user
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


    // Delete user
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


    // Delete user by id
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


    // Get all users
    @GetMapping
    public ResponseEntity<Map<Integer, User> >getAllUsers(){
        return ResponseEntity.status(HttpStatus.FOUND).body(userDb);
    }

    // Path variable example
    // Get user by id and orderId
    @GetMapping("/{id}/orders/{orderId}")
    public ResponseEntity<User> getUserOrder(@PathVariable(required = false)Integer id,@PathVariable(required = false) Integer orderId)
    {
        User user = userDb.get(id);
        System.out.println("User with id " + id + " and orderId " + orderId + " found: " +
                user.getName() + ", Email: " + user.getEmail());
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    // Get user by id single User only
    // path variable name must be same as the parameter name in the method
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable(required = false) Integer id)
    {
        User user = userDb.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    //@Getmapping("/users","/users/{id}") this can be possible but not recommended because it will create ambiguity in the request mapping and will throw an error.
    //Request parameter example
    // /search?name=john sample example of query parameter
    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUser(@RequestParam(required = false) Integer id,
                                                 @RequestParam(required = false) String name,
                                                 @RequestParam(required = false) String email)
    {
        System.out.println(id);
        System.out.println("Searching user with id " + id + ", name " + name + ", email " + email);
        List<User> users =userDb.values().stream().filter
                (u-> (id != null && u.getId() == id) ||
                          (name != null && name.equalsIgnoreCase(u.getName())) ||
                          (email != null && email.equalsIgnoreCase(u.getEmail()))).toList();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }


    @GetMapping("/info")
    public String getInfo(@RequestHeader("User-Agent") String userAgent)
    {
        System.out.println("User-Agent: " + userAgent);
        return "User-Agent: " + userAgent;

    }
}
