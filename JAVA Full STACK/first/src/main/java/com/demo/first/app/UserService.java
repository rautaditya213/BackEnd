package com.demo.first.app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    private Map<Integer , User> userDb = new HashMap<>();


    public User createUser(User user){
        System.out.println("User created: " + user.getName() + ", Email: " + user.getEmail());
        userDb.putIfAbsent(user.getId(), user);
        return user;
    }


    public User updateUser(User user) {
        if(userDb.containsKey(user.getId()))
        {
            userDb.put(user.getId(),user);
            System.out.println("User updated: " + user.getName() + ", Email: " + user.getEmail());
        }
        else{
            System.out.println("User with ID " + user.getId() + " not found.");
           throw new IllegalArgumentException("User with ID " + user.getId() + " not found.");
        }
        return user;
    }

    public boolean deleteUser(User user) {
        if(userDb.containsKey(user.getId())){
            userDb.remove(user.getId());
            System.out.println("User deleted: "+ user.getName() + ", Email: " + user.getEmail());
            return true;
        }
        else{
            System.out.println("User with id" + user.getId()+ "not found.");
           return false;
        }
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(userDb.values());
    }

    public User getUserById(Integer id) {
        if (userDb.containsKey(id)){
            return userDb.get(id);
        }
        else{
            System.out.println("User with id" + id + "not found.");
            return null;
        }
    }

    public List<User> searchUsers(Integer id ,String name, String email) {

               return userDb.values().stream().filter
                        (u-> (id != null && u.getId() == id) ||
                        (name != null && name.equalsIgnoreCase(u.getName())) ||
                        (email != null && email.equalsIgnoreCase(u.getEmail()))).toList();

    }
}
