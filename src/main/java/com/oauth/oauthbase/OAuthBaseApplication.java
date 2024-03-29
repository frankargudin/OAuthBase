package com.oauth.oauthbase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class OAuthBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(OAuthBaseApplication.class, args);
    }

    @RequestMapping(value = "/products")
    public String getProductName() {
        return "Honey";

    }
}