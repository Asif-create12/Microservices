package com.ashok.controller;


import com.ashok.client.GreetFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @Autowired
    private GreetFeignClient greetFeignClient;

    @GetMapping(value = "/welcome")
    public String welcomeMessage() {
        String greetMsg=greetFeignClient.invokeGreetApi();
        String welcome = "Welcome to Asif it";
        return welcome.concat(greetMsg);
    }
}
