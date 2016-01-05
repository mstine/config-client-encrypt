package com.mattstine;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
public class ConfigClientApplication {

    @Value("${foo}")
    String foo;

    @Value("${secretProperty}")
    String secretProperty;

    @RequestMapping("/foo")
    public String foo() {
        return foo;
    }

    @RequestMapping("/")
    public String reveal() {
        return secretProperty;
    }

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }
}
