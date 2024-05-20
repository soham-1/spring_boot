package com.example.bean;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value="request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RandomNumber {
    private int randomNumber;

    public RandomNumber() {
        randomNumber = (int) (Math.random()*10);
    }

    public int getRandomNumber() {
        return randomNumber;
    }
}
