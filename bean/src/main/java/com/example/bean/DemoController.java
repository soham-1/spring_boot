package com.example.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Language language;
    private ConfigDemo configDemo;

    @Autowired
    @Qualifier("fieldInjection")
    private Language fieldInjection;

    @Autowired
    private FieldInjection fieldInjection1;

    @Autowired
    public DemoController(@Qualifier("java") Language language, ConfigDemo configDemo) {
        this.language = language;
        this.configDemo = configDemo;
    }

    @GetMapping("/greet")
    public String greetHello() {
        return language.greet();
    }

    @GetMapping("/greet/fieldInjection")
    public String greetFieldInjection() {
        return fieldInjection1.greet();
    }

    @GetMapping("/greet/sayHello")
    public String sayHello() {
        return this.configDemo.sayHello();
    }
}
