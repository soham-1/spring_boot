package com.example.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Java implements Language {

    JDK jdk;

    @Override
    public String greet() {
        return this.jdk.greetJDK();
    }

    @Autowired
    public void setCompiler(JDK jdk) {
        this.jdk = jdk;
    }
}
