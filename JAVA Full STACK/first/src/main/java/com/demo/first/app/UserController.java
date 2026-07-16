package com.demo.first.app;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService = new UserService();

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Create user
    @PostMapping
    public ResponseEntity<User> creatUser(@RequestBody User user){
       User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }


    // Update user
    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user){
        User updated = userService.updateUser(user);
        if(updated==null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }


    // Delete user
    @DeleteMapping
    public ResponseEntity<User> deleteUser(@RequestBody User user){

        boolean deleted = userService.deleteUser(user);
        if(deleted) return ResponseEntity.status(HttpStatus.OK).body(user);
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


//    // Delete user by id
//    @DeleteMapping("/{id}")
//    public String deleteUserById(@PathVariable int id){
//        if(userDb.containsKey(id)){
//            User user = userDb.get(id);
//            userDb.remove(id);
//            System.out.println("User deleted: "+ user.getName() + ", Email: " + user.getEmail());
//            return "User deleted successfully";
//        }
//        else{
//            System.out.println("User with id" + id + "not found.");
//            return "User with id" + id + "not found.";
//        }
//    }

    // Get all users
    @GetMapping
    public List <User> getAllUsers(){
        return userService.getAllUsers();
    }

    // Path variable example
    // Get user by id and orderId
//    @GetMapping("/{id}/orders/{orderId}")
//    public ResponseEntity<User> getUserOrder(@PathVariable(required = false)Integer id,@PathVariable(required = false) Integer orderId)
//    {
//        User user = userDb.get(id);
//        System.out.println("User with id " + id + " and orderId " + orderId + " found: " +
//                user.getName() + ", Email: " + user.getEmail());
//        return ResponseEntity.status(HttpStatus.OK).body(user);
//    }

    // Get user by id single User only
    // path variable name must be same as the parameter name in the method
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable(required = false) Integer id)
    {
        User user = userService.getUserById(id);
        if(user==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    // @Getmapping("/users","/users/{id}") this can be possible but not recommended because it will create ambiguity in the request mapping and will throw an error.
    // Request parameter example
    // /search?name=john sample example of query parameter
    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUser( @RequestParam(required = false) Integer id,
                                                  @RequestParam(required = false) String name,
                                                  @RequestParam(required = false) String email )
    {
       return ResponseEntity.status(HttpStatus.OK).body(userService.searchUsers(id,name,email));
    }


    @GetMapping("/info")
    public String getInfo(@RequestHeader("User-Agent") String userAgent)
    {
        System.out.println("User-Agent: " + userAgent);
        return "User-Agent: " + userAgent;
    }

    //Exception handling example
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String,Object>> handleIllegealArgumentException(IllegalArgumentException ex){
        Map<String, Object > errorResponse = new HashMap<>();
        errorResponse.put("message", ex.getMessage());
        errorResponse.put("timestamped", LocalDateTime.now());
        errorResponse.put("error", HttpStatus.BAD_REQUEST);
        errorResponse.put("status", HttpStatus.BAD_REQUEST.value());
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
