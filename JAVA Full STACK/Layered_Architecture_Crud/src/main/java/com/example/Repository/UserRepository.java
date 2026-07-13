package com.example.Repository;

import java.util.*;
import com.example.DB.DatabaseConnection;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private final DatabaseConnection databaseConnection;

    public UserRepository(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
        this.databaseConnection.init();
    }

    public List<String> findAllUsers() {
        return databaseConnection.getUsers();
    }

    public void saveUser(String user) {
        databaseConnection.addUser(user);
    }

}

