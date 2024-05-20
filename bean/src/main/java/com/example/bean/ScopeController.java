package com.example.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScopeController {
    private RandomNumber randomNumber;

    @Autowired
    public ScopeController(RandomNumber randomNumber) {
        this.randomNumber = randomNumber;
    }

    @GetMapping("/random")
    public int getRandom() {
        return this.randomNumber.getRandomNumber();
    }
}
