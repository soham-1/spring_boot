package com.example.scandemo;

import com.example.bean.Language;
import org.springframework.stereotype.Component;

@Component
public class C implements Language {

    @Override
    public String greet() {
        return "This is C Language";
    }
}
