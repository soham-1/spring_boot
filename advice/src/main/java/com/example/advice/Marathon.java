package com.example.advice;

import org.springframework.stereotype.Component;

import java.sql.Time;

@Component
public class Marathon {

    private int kms;

    public int getKms() {
        return kms;
    }

    public void setKms(int kms) {
        this.kms = kms;
    }

    public void addMarathon(int km) {
        System.out.println(km + " km marathon starts");
    }

    public boolean isWinner(int indv) {
        return true;
    };

    public void runMarathon() {
        try {
            Thread.sleep(3000);
        } catch (Exception e) {

        }
    }
}
