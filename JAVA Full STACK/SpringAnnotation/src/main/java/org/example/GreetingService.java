package org.example;


import org.springframework.stereotype.Component;


@Component
public class GreetingService {

    public void sayHello() {
        System.out.println("Hello from spring!");
    }
}


